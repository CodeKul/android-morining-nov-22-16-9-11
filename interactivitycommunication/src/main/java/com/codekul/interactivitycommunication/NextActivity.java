package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NextActivity extends AppCompatActivity {

    public static final String KEY_SELECTED_COLOR = "selectedColor";

    private int selectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        initImageView();

        findViewById(R.id.btnBack).setOnClickListener(this::clicked);
        findViewById(R.id.btnRed).setOnClickListener(this::clicked);
        findViewById(R.id.btnGreen).setOnClickListener(this::clicked);
        findViewById(R.id.btnBlue).setOnClickListener(this::clicked);
    }

    private void initImageView(){
        Intent responsibleIntent = getIntent();
        Bundle bundle = responsibleIntent.getExtras();
        int imageId =  bundle.getInt("selectedImage");

        ((ImageView)findViewById(R.id.imageSelected))
                .setImageResource(imageId);
    }

    private void clicked(View view) {
        if(view.getId() == R.id.btnBack) {

            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_SELECTED_COLOR, selectedColor);
            intent.putExtras(bundle);

            setResult(RESULT_OK, intent);
            finish();
        }
        if(view.getId() == R.id.btnRed) colorImageView(Color.RED);
        if(view.getId() == R.id.btnGreen) colorImageView(Color.GREEN);
        if(view.getId() == R.id.btnBlue) colorImageView(Color.BLUE);
    }

    private void colorImageView(int color){
        selectedColor = color;
        ((ImageView)findViewById(R.id.imageSelected)).setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }
}
