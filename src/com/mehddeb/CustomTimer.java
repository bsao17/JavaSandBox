package com.mehddeb;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Soundbank;
import javax.sound.midi.spi.SoundbankReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.TimerTask;

public class CustomTimer extends TimerTask {

    public static int time;

    @Override
    public void run(){
        if (time != 0){
            System.out.println("il reste " + --time + " secondes !");
        } else {
            SoundbankReader sound = new SoundbankReader() {
                @Override
                public Soundbank getSoundbank(URL url) throws InvalidMidiDataException, IOException {
                    return null;
                }

                @Override
                public Soundbank getSoundbank(InputStream stream) throws InvalidMidiDataException, IOException {
                    return null;
                }

                @Override
                public Soundbank getSoundbank(File file) throws InvalidMidiDataException, IOException {
                    return null;
                }
            };
            cancel();
        }
    }
}
