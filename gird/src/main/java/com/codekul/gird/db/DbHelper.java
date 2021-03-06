package com.codekul.gird.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;

/**
 * Created by aniruddha on 23/11/16.
 */

public class DbHelper  extends SQLiteOpenHelper{

    private Context context;

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        this.context = context;
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {

        Observable<String> ob = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                createTables(db);

                insertData(db);

                readPanchang(db);

                return null;
            }
        });
        ob.subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i("@melayer","Db Ops completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("@melayer","Db Ops Error "+e);
            }

            @Override
            public void onNext(String s) {
                Log.i("@melayer","Db Ops next "+s);
            }
        });
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void createTables(SQLiteDatabase db){

        StringBuilder builder = new StringBuilder();
        try {
            InputStream is = context.getAssets()
                    .open("collective_data_sheet.sql");
            while(true){
                int ch = is.read();

                if(ch == -1) break;
                else builder.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("@melayer","---------> created string builder");
        db.execSQL(builder.toString());
        Log.i("@melayer","---------> created the database");

    }
    private void insertData(SQLiteDatabase db){

        try {
            InputStream is = context.getAssets()
                    .open("tab_collective_data_sheet.sql");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while(true){
                String insert = br.readLine();
                Log.i("@melayer","@@@ Row read - "+insert);
                if(insert == null) break;
                else {
                    db.execSQL(insert);
                    Log.i("@melayer","*** Row Inserted");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readPanchang(SQLiteDatabase db){
        Cursor c = db.query("collective_data_sheet",null,null,null,null,null,null);

        while(c.moveToNext()){
            Log.i("@melayer","===> "+c.getString(c.getColumnIndex("day_summary")));
        }
    }
}
