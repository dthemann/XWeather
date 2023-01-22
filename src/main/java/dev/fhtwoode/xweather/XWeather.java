package dev.fhtwoode.xweather;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.Properties;

import java.io.IOException;

public class XWeather extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(XWeather.class.getResource("frm_weatherappmain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}