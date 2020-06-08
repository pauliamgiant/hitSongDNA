module hitSongDNA {

    requires javafx.controls;
    requires javafx.fxml;
    requires eu.hansolo.medusa;
    requires com.dlsc.formsfx;



    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}