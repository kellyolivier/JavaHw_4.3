package com.example.hw_43;

import android.widget.ImageView;

import java.util.Random;

public class Dice implements Runnable
{
    private ImageView diceView;

    private Random rand = new Random();
    public Dice(ImageView newDice){
        diceView = newDice;
    }

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

    public void changeFace()
    {
        int randFace = rand.nextInt(6);
        randFace++; //make range turn out to 1-6

        switch (randFace)
        {
            case 1:
                diceView.setImageResource(R.mipmap.one);
                break;
            case 2:
                diceView.setImageResource(R.mipmap.two);
                break;
            case 3:
                diceView.setImageResource(R.mipmap.three);
                break;
            case 4:
                diceView.setImageResource(R.mipmap.four);
                break;
            case 5:
                diceView.setImageResource(R.mipmap.five);
                break;
            case 6:
                diceView.setImageResource(R.mipmap.six);
                break;

        }
    }


}
