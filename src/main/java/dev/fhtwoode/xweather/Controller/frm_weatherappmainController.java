package dev.fhtwoode.xweather.Controller;

import dev.fhtwoode.xweather.XWeather;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class frm_weatherappmainController extends XWeather {

    @FXML
    private ImageView IV_Location;

    @FXML
    private ImageView IV_WeatherForecast;

    @FXML
    private ImageView IV_WeatherNow;

    @FXML
    private Button bt_Configure;

    @FXML
    private Button bt_Update;

    @FXML
    private Label lbl_Log;

    @FXML
    private TextArea ta_Location;

    @FXML
    private TextArea ta_WeatherForecast;

    @FXML
    private TextArea ta_WeatherNow;

    @FXML
    void bt_Configure_Clicked(MouseEvent event) {

        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(XWeather.class.getResource("frm_configurate.fxml"));
            Scene configurate_scene = new Scene(fxmlLoader.load(), 800, 400);

            Stage config_Window = new Stage();
            config_Window.setScene(configurate_scene);
            config_Window.initModality(Modality.WINDOW_MODAL);
            config_Window.initOwner(IV_Location.getScene().getWindow());
            config_Window.show();
        }catch (IOException e)
        {

        }

    }

    @FXML
    void bt_Update_Clicked(MouseEvent event) {

        try {
            String configFilePath = "src/main/resources/application.properties";
            FileInputStream propsInput = new FileInputStream(configFilePath);
            Properties prop = new Properties();
            prop.load(propsInput);

            System.out.println(prop.getProperty("openweather_api_key"));
            System.out.println(prop.getProperty("openweather_api_hostname"));


        } catch (Exception e)
        {

        }

    }

}
