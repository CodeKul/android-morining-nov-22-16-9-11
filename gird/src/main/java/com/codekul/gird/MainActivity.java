package com.codekul.gird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.codekul.gird.db.DbHelper;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
//A1:K366
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("@melayer",""+getFirstDay(new GregorianCalendar(), 2017,1));

        new DbHelper(this, "myDb", null, 1).getWritableDatabase();
    }

    private void createGrid(){

        ((GridView)findViewById(R.id.gridCalendar)).setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1));
    }

    private String getFirstDay(Calendar calendar, int year, int month){
        String weekDay = "";

        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month - 1);
        calendar.set(Calendar.DAY_OF_MONTH,1);

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if (Calendar.MONDAY == day) {
            weekDay = "सोम";
        } else if (Calendar.TUESDAY == day) {
            weekDay = "मंगळ";
        } else if (Calendar.WEDNESDAY == day) {
            weekDay = "बुध";
        } else if (Calendar.THURSDAY == day) {
            weekDay = "गुरु";
        } else if (Calendar.FRIDAY == day) {
            weekDay = "शुक्र";
        } else if (Calendar.SATURDAY == day) {
            weekDay = "शनी";
        } else if (Calendar.SUNDAY == day) {
            weekDay = "रवी";
        }
        return weekDay;
    }
}
