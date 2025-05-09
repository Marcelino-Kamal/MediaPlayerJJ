module com.mediaplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;

    opens com.mediaplayer to javafx.fxml;
    exports com.mediaplayer;
    opens com.mediaplayer.controllers to javafx.fxml;
    exports com.mediaplayer.controllers;
}
