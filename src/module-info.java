module hitSongDNA {

    requires javafx.controls;
    requires javafx.fxml;
    requires eu.hansolo.medusa;

    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}