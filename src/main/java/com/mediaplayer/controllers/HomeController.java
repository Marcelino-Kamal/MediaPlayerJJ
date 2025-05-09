package com.mediaplayer.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mediaplayer.models.Song;

public class HomeController implements Initializable {

    @FXML
    private ImageView myimg;
    @FXML
    private Button Add, PlayBtn;
    @FXML
    private TextArea msg;
    @FXML
    private TextArea SongList;
    Song s;
    List<Song> songList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Image image = new Image(getClass().getResource("/com/mediaplayer/assets/logo.jpg").toExternalForm());
        myimg.setImage(image);

    }

    @FXML
    private void Addmusic() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Select File");

        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Audio Files", "*.mp3"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));

        File selected = fc.showOpenDialog(Add.getScene().getWindow());

        if (selected != null) {
            s = new Song();
            s.setName(selected.getName());
            s.setPath(selected.getAbsolutePath());
            songList.add(s);
            refreshSongListDisplay();
            msg.setText("Song Added Successfully");
        } else {
            System.out.println("failed to add Song");
        }

    }

   
    @FXML
    private void PlaySong() {
        if (!songList.isEmpty()) {
            File file = new File(songList.get(0).getPath());
            Media media = new Media(file.toURI().toString());
            MediaPlayer mp = new MediaPlayer(media);
            mp.play();
        } else {
            msg.setText("No songs available to play.");
        }
    }

    private void refreshSongListDisplay() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < songList.size(); i++) {
            sb.append(i + 1).append(". ").append(songList.get(i).getName()).append("\n");
        }
        SongList.setText(sb.toString());
    }

}
