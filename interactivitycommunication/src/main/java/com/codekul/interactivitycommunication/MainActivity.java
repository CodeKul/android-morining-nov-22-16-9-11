package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_NEXT_ACTIVITY = 1524 ;
    private int idImage;
    private ImageView selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNext).setOnClickListener(this::click);
        findViewById(R.id.imageFirst).setOnClickListener(this::click);
        findViewById(R.id.imageSecond).setOnClickListener(this::click);
        findViewById(R.id.imageThird).setOnClickListener(this::click);
    }

    private void click(View view) {
        if(view.getId() == R.id.btnNext) startNextActivity();
        if(view.getId() == R.id.imageFirst) {
            idImage = R.drawable.ic_accessibility_black_24dp;
            selectedImage = (ImageView) view;
        }
        if(view.getId() == R.id.imageSecond) {
            idImage = R.drawable.ic_adb_black_24dp;
            selectedImage = (ImageView) view;
        }
        if(view.getId() == R.id.imageThird) {
            idImage = R.drawable.ic_airplanemode_active_black_24dp;
            selectedImage = (ImageView) view;
        }
    }

    private void startNextActivity() {
        Intent intent =
                new Intent(this, NextActivity.class);

        Bundle bundle = new Bundle();
        bundle.putInt("selectedImage",idImage);

        intent.putExtras(bundle);

        //startActivity(intent);
        startActivityForResult(intent, REQ_NEXT_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_NEXT_ACTIVITY) {

            if(resultCode == RESULT_OK){
                if(data != null){
                    Bundle bundle = data.getExtras();
                    int selectedColor = bundle.getInt(NextActivity.KEY_SELECTED_COLOR);
                    selectedImage.setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);
                }
            }
        }
    }
}
