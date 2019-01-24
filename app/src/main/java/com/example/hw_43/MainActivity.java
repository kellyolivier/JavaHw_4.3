package com.example.hw_43;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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

/**
 * handles Dice UI thread and creation of dice threads
 */
public class MainActivity extends AppCompatActivity {

    private Dice[] cs = new Dice[5];
    Button rollButton;
    TextView testText;
    ImageView imgOne, imgTwo, imgThree, imgFour, imgFive;


    @Override
    /**
     * start dice and call make threads
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = findViewById(R.id.button2);

        //connect images
        imgOne  = findViewById(R.id.imgOne);
        imgTwo  = findViewById(R.id.imgTwo);
        imgThree  = findViewById(R.id.imgThree);
        imgFour = findViewById(R.id.imgFour);
        imgFive = findViewById(R.id.imgFive);


        //create dice
        cs[0] = new Dice(imgOne, this);
        cs[1] = new Dice(imgTwo, this);
        cs[2] = new Dice(imgThree, this);
        cs[3] = new Dice(imgFour, this);
        cs[4] = new Dice(imgFive, this);


        //listen for roll button click to start threads
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeDiceThreads();
            }
        });

    }

    /**
     * create threads that call on dice objs
     */
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
