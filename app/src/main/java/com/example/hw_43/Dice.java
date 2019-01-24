package com.example.hw_43;

import android.app.Activity;
import android.widget.ImageView;


import java.util.Random;

/**
 * dice class manages a single die and its rolls
 */
public class Dice implements Runnable
{
    private ImageView diceView;
    private Activity activity;

    private Random rand = new Random();
    public Dice(ImageView newDice, Activity newActivity){
        diceView = newDice;
        activity = newActivity;
    }

    /**
     * runs for a minimum of 10 * 300 milliseconds (10 flips of face)
     */
    public void run() {
        int stop = rand.nextInt(20);
        stop += 10;

        for (int i = 0; i <= stop; i++)
        {
            changeFace();
            try {
                Thread.sleep(300);
            }
            catch (InterruptedException ex) {;}

        }

    }


    /**
     * asks UI thread to update dice images based on randomized face appearance
     */
    public void changeFace() {
        final int randFace = rand.nextInt(6) + 1;
        //randFace++; //make range turn out to 1-6

        ((Activity) this.activity).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (randFace) {
                    case 1: {
                        diceView.setImageResource(R.mipmap.one);
                        break;
                    }
                    case 2: {
                        diceView.setImageResource(R.mipmap.two);
                        break;
                    }
                    case 3: {
                        diceView.setImageResource(R.mipmap.three);
                        break;
                    }
                    case 4: {
                        diceView.setImageResource(R.mipmap.four);
                        break;
                    }
                    case 5: {
                        diceView.setImageResource(R.mipmap.five);
                        break;
                    }
                    case 6: {
                        diceView.setImageResource(R.mipmap.six);
                        break;
                    }

                }
            }
        });

    }


}
