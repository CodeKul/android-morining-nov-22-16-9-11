package com.codekul.uixml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getWindow().setBackgroundDrawableResource(R.drawable.ic_eye);

        Button btnOkay = (Button) findViewById(R.id.btnOkay);
        /*btnOkay.setOnClickListener(v -> {

        });*/

        btnOkay.setOnClickListener(this::clicked);

        /*btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textInfo = (TextView) findViewById(R.id.textInfo);
                textInfo.setText("Anonymus Inner type");
            }
        });*/

//        btnOkay.setOnClickListener(new Click());
    }

   /* private class Click implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            TextView textInfo = (TextView) findViewById(R.id.textInfo);
            textInfo.setText("Click class");
        }
    }*/

    public void clicked(View view) {
        TextView textInfo = (TextView) findViewById(R.id.textInfo);
        textInfo.setText("Method ref");
    }
}
