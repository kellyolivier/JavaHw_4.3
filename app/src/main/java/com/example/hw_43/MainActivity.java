package com.example.hw_43;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Dice[] cs = new Dice[5];
    Button rollButton;
    TextView testText;
    ImageView imgOne, imgTwo, imgThree, imgFour, imgFive, imgSix;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = findViewById(R.id.button2);
        testText = findViewById(R.id.test);

        imgOne  = findViewById(R.id.imgOne);
        imgTwo  = findViewById(R.id.imgTwo);
//        imgThree  = findViewById(R.id.imgThree);
//        imgFour = findViewById(R.id.imgFour);

        cs[0] = new Dice(imgOne);
        cs[1] = new Dice(imgTwo);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testText.setText("Button clicked");
                cs[0].changeFace();
            }
        });

    }

    public void makeDiceThreads()
    {
        for (int i=0; i< cs.length; i++) {
            Thread t = new Thread(cs[i]);
            t.start();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {;}
        }
    }



}
