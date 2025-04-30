package com.mediaplayer.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.mediaplayer.models.Song;

public class HomeController implements Initializable {

    @FXML
    private ImageView PlayerImage;
    @FXML
    private Button addmusic;
    private Song s;

    public HomeController() {
       this.s  = new Song();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image(getClass().getResource("/com/mediaplayer/assets/logo.jpg").toExternalForm());
        PlayerImage.setImage(image);
    }
    @FXML
    private void Addmusic(){
        FileChooser fc =  new FileChooser();
        fc.setTitle("Select File");

        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Audio Files", "*.mp3"),
        new FileChooser.ExtensionFilter("All Files","*.*"));

        File selected = fc.showOpenDialog(addmusic.getScene().getWindow());

        if(selected != null){
            s.setPath(selected.getAbsolutePath());
            s.setName(selected.getName());
        }

        System.out.println(s.getName());

    }

}
