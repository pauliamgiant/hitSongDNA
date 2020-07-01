module hitSongDNA {

    requires javafx.controls;
    requires javafx.fxml;
    requires eu.hansolo.medusa;
    requires com.dlsc.formsfx;
    requires de.jensd.fx.glyphs.fontawesome;
    requires de.jensd.fx.glyphs.commons;
    requires json.simple;
    requires eu.hansolo.tilesfx;








    opens org.openjfx to javafx.fxml;
    exports org.openjfx;



}