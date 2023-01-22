package dev.fhtwoode.xweather.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import dev.fhtwoode.xweather.Data.Location;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class frm_configurateController {

    @FXML
    private Button bt_LoadConfig;

    @FXML
    private Button bt_SaveConfig;

    @FXML
    private Button bt_searchLocation;

    @FXML
    private Button bt_selectLocation;

    @FXML
    private Button bt_update_uprate;

    @FXML
    private Button bt_updatelocationAPIKey;

    @FXML
    private Button bt_updateweatherAPIKey;

    @FXML
    private FontAwesomeIconView icn_search;

    @FXML
    private FontAwesomeIconView icn_update_rate;

    @FXML
    private Label lb_locsetup_log;

    @FXML
    private ListView<?> lv_Locations;

    @FXML
    private RadioButton rb_imperialunits;

    @FXML
    private RadioButton rb_metricunits;

    @FXML
    private TextField tb_locationAPIKey;

    @FXML
    private TextField tb_uprate_hh;

    @FXML
    private TextField tb_uprate_mm;

    @FXML
    private TextField tb_uprate_ss;

    @FXML
    private TextField tb_weatherAPIKey;

    @FXML
    private TextField tf_serachLocation;

    @FXML
    void bt_LoadConfigButtonClicked(MouseEvent event) {

    }

    @FXML
    void bt_SaveConfigButtonClicked(MouseEvent event) {

    }

    @FXML
    void bt_searchLocationButtonClicked(MouseEvent event) {

        String searchLocationtext = tf_serachLocation.getText();

        Location new_loc = new Location();
        try {
            String API_return = startConnection("test");

            ObjectMapper mapper = new ObjectMapper();
            //new_loc = mapper.readerFor(Location.class).readValue(API_return);
            //new_loc = mapper.readValue(API_return, Location.class);

            JsonNode new_node = mapper.readTree(API_return);
            String namee = new_node.get("name").asText();

            new_loc = mapper.readerFor(Location.class).readValue(API_return);

            System.out.println(new_loc.getLabel());
        } catch (Exception e)
        {

        }

    }

    @FXML
    void bt_selectLocationButtonClicked(MouseEvent event) {

    }

    @FXML
    void bt_update_uprateButtonClicked(MouseEvent event) {

    }

    @FXML
    void bt_updatelocationAPIKey_ButtonClicked(MouseEvent event) {

    }

    @FXML
    void bt_updateweatherAPIKey_ButtonClicked(MouseEvent event) {

    }

    @FXML
    void icn_searchButtonClicked(MouseEvent event) {

    }

    @FXML
    void icn_update_rateButtonClicked(MouseEvent event) {

    }

    @FXML
    void rb_imperialunits_Action(MouseEvent event) {

    }

    @FXML
    void rb_metricunits_Action(MouseEvent event) {

    }

    @FXML
    void tb_uprate_hh_Action(ActionEvent event) {

    }

    @FXML
    void tb_uprate_mm_Action(ActionEvent event) {

    }

    @FXML
    void tb_uprate_ss_Action(ActionEvent event) {

    }

    private String startConnection(String header) throws IOException {

        try (final Socket socket = new Socket("api.positionstack.com",80)) {
            final String request = "/v1/forward?access_key=0fe88b60549294f08f0a9402b26b04ef&query=Wien&output=json Connection:close Host:api.positionstack.com";

            final OutputStream outputStream = socket.getOutputStream();
            outputStream.write(request.getBytes(StandardCharsets.UTF_8));

            final InputStream inputStream = socket.getInputStream();
            final String response = readAsString(inputStream);
            //System.out.println(response);
            outputStream.close();
            inputStream.close();

            System.out.println(response);

            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static String readAsString(final InputStream inputStream) throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toString(StandardCharsets.UTF_8.name());
    }
}

