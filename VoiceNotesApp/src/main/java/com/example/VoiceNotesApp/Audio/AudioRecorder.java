package com.example.VoiceNotesApp.Audio;

import org.springframework.stereotype.Component;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

@Component
public class AudioRecorder {

    public String Record(){

        try {
            // Audio Format
            AudioFormat format = new AudioFormat(44100, 16, 2, true, true);

            // Get a target data line
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(info);

            // Open the target line
            targetLine.open(format);

            // Start recording audio
            targetLine.start();

            // Write captured audio to a file
            File outputFile = new File("C:\\Users\\ConorLynam\\PersonalProjects\\SpeechToText\\recorded_audio.wav");
            AudioSystem.write(new AudioInputStream(targetLine), AudioFileFormat.Type.WAVE, outputFile);

            // Record for 5 seconds
            Thread.sleep(5000);
            return outputFile.getAbsolutePath();

        } catch (LineUnavailableException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
