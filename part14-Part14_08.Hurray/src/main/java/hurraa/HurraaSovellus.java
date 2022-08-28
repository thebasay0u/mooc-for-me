package hurraa;

import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button button = new Button("Hurraa!");
        pane.setCenter(button);
        String url = "sound.wav";

        // final URL sound = getClass().getResource("Applause-Yannick_Lemieux.wav");

        button.setOnMouseClicked((event) -> {
            // playSound(url);
        });

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    // protected void playSound(String soundFile) {

    // File f = new File(soundFile);
    // try {
    // AudioInputStream audioIn = AudioSystem.getAudioInputStream(new Audio);
    // Clip clip = AudioSystem.getClip();
    // clip.open(audioIn);

    // clip.start();
    // } catch (UnsupportedAudioFileException | IOException |
    // LineUnavailableException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    public static void main(String[] args) {
        launch(HurraaSovellus.class);
    }

}
