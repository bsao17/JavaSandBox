package com.mehddeb;

import java.util.TimerTask;

public class CustomTimer extends TimerTask {

    public static int time;

    @Override
    public void run(){
        if (time != 0){
            System.out.println("il reste " + --time + " secondes !");
        } else {
            cancel();
        }
    }
}
