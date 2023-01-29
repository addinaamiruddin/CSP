package com.example.csp;

import java.io.File;
        import java.net.URL;
        import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.media.Media;
        import javafx.scene.media.MediaPlayer;
        import javafx.scene.media.MediaView;
        import javafx.util.Duration;

public class VideoController implements Initializable{

    @FXML
    private MediaView mediaView;

    @FXML
    private Button playButton, pauseButton, resetButton;

    private File file;
    private Media media;
    String EE="src/main/java/videos/EE_video.mp4";
    String ECE="src/main/java/videos/ECE_video.mp4";
    String CE="src/main/java/videos/CE_video.mp4";
    String ME="src/main/java/videos/ME_video.mp4";
    String CS="src/main/java/videos/CS_video.mp4";

    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public void playVideoEE(ActionEvent event) {
        file = new File("src/main/java/videos/EE_video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }

    public void playVideoECE(ActionEvent event) {
        file = new File("src/main/java/videos/ECE_video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }

    public void playVideoCE(ActionEvent event) {
        file = new File("src/main/java/videos/CE_video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }

    public void playVideoME(ActionEvent event) {
        file = new File("src/main/java/videos/ME_video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }

    public void playVideoCS(ActionEvent event) {
        file = new File("src/main/java/videos/CS_video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }


}

