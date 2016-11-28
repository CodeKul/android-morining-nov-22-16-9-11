package com.codekul.nestedlayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int avengerCounter = 0;
    ArrayList<Avenger> avengers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       findViewById(R.id.btnNext).setOnClickListener(this::clicked);
       findViewById(R.id.btnPrev).setOnClickListener(this::clicked);

        avengers.add(new Avenger("Iron Man",R.drawable.iron,"When an industrialist is captured, he constructs a high-tech armoured suit to escape. Once he manages to escape, he decides to use his suit to fight against evil forces and save the world."));
        avengers.add(new Avenger("Hulk",R.drawable.hulk,"The Hulk is a fictional superhero created by writer Stan Lee and artist Jack Kirby, who first appeared in the debut issue of the comic book The Incredible Hulk in May 1962 published by Marvel Comics"));
        avengers.add(new Avenger("Black Widow",R.drawable.bw,"Black Widow is a fictional superhero appearing in American comic books published by Marvel Comics. Created by editor and plotter Stan Lee, scripter Don Rico, and artist Don Heck, the character first appeared in Tales of Suspense No. 52"));
        avengers.add(new Avenger("Captain America",R.drawable.captain,"Captain America is a fictional superhero appearing in American comic books published by Marvel Comics. Created by cartoonists Joe Simon and Jack Kirby, the character first appeared in Captain America Comics #1 (cover dated March 1941) from Timely Comics, a predecessor of Marvel Comics. Captain America was designed as a patriotic supersoldier who often fought the"));
        avengers.add(new Avenger("Thor",R.drawable.thor,"Thor is exiled by his father Odin, the King of Asgard, to the Earth to live among mortals. When he lands on Earth, his trusted weapon Mjolnir is discovered and captured by S.H.I.E.L.D."));
    }

    private void clicked(View view) {
        if(view.getId() == R.id.btnNext) nextImage();
        else prevImage();
    }

    private void prevImage() {
        Log.i("Prev - ","Counter "+avengerCounter+ "Size - "+avengers.size());
        avengerCounter = avengerCounter <= 0 ? avengers.size()-1 : --avengerCounter ;
        makeAvengerPage(avengers.get(avengerCounter));
    }

    private void nextImage() {
        Log.i("Next - ","Counter "+avengerCounter + "Size - "+avengers.size());
        avengerCounter = avengerCounter >= avengers.size()-1 ? 0 : ++avengerCounter;
        makeAvengerPage(avengers.get(avengerCounter));
    }

    private void makeAvengerPage(Avenger avenger){

        ((TextView)findViewById(R.id.textAvengerName)).setText(avenger.getName());
        ((ImageView)findViewById(R.id.imageAvenger)).setImageResource(avenger.getImage());
        ((TextView)findViewById(R.id.textAvengerInfo)).setText(avenger.getInfo());
    }
}
