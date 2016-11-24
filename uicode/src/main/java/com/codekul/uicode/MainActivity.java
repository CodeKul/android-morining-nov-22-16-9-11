package com.codekul.uicode;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = this;// activity is a context

        LinearLayout layoutRoot = new LinearLayout(context);
        layoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
        layoutRoot.setOrientation(LinearLayout.VERTICAL);

        Button btn = new Button(context);
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        btn.setText("Okay");
        layoutRoot.addView(btn);

        setContentView(layoutRoot);
    }
}
