module dev.fhtwoode.xweather {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;


    opens dev.fhtwoode.xweather to javafx.fxml;
    exports dev.fhtwoode.xweather;
    exports dev.fhtwoode.xweather.Controller;
    opens dev.fhtwoode.xweather.Controller to javafx.fxml;
    exports dev.fhtwoode.xweather.Data;
    opens dev.fhtwoode.xweather.Data to javafx.fxml;
}