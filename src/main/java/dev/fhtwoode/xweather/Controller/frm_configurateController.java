package dev.fhtwoode.xweather.Controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import dev.fhtwoode.xweather.Data.Car;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


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

        String return_string = "";

        try {
            URL url = new URL("http://api.positionstack.com/v1/forward?access_key=0fe88b60549294f08f0a9402b26b04ef&query=Wien&fields=results.latitude,results.longitude&output=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = "";
            String buffer_string = "";
            System.out.println("Output from Server .... \n");

            while ((output = br.readLine()) != null) {
                System.out.println(output);
                buffer_string = output;
            }

            conn.disconnect();
            return_string = buffer_string;


        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        Car car = new Car();

        try{
            ObjectMapper objectMapper = new ObjectMapper();

            String carJson ="{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
            car = objectMapper.readValue(carJson, Car.class);

            ///String teststr = "[{\"latitude\":48.198674,\"longitude\":16.348388,\"type\":\"locality\",\"name\":\"Vienna\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":1,\"region\":\"Wien\",\"region_code\":\"WI\",\"county\":null,\"locality\":\"Vienna\",\"administrative_area\":\"Wien\",\"neighbourhood\":null,\"country\":\"Austria\",\"country_code\":\"AUT\",\"continent\":\"Europe\",\"label\":\"Vienna, WI, Austria\"},{\"latitude\":48.20269,\"longitude\":16.381556,\"type\":\"localadmin\",\"name\":\"Wien\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":1,\"region\":\"Wien\",\"region_code\":\"WI\",\"county\":null,\"locality\":null,\"administrative_area\":\"Wien\",\"neighbourhood\":null,\"country\":\"Austria\",\"country_code\":\"AUT\",\"continent\":\"Europe\",\"label\":\"Wien, Austria\"},{\"latitude\":43.166644,\"longitude\":-83.780621,\"type\":\"localadmin\",\"name\":\"Vienna\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":1,\"region\":\"Michigan\",\"region_code\":\"MI\",\"county\":\"Genesee County\",\"locality\":null,\"administrative_area\":\"Vienna\",\"neighbourhood\":null,\"country\":\"United States\",\"country_code\":\"USA\",\"continent\":\"North America\",\"label\":\"Vienna, MI, USA\"},{\"latitude\":43.233897,\"longitude\":-75.777709,\"type\":\"localadmin\",\"name\":\"Vienna\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":1,\"region\":\"New York\",\"region_code\":\"NY\",\"county\":\"Oneida County\",\"locality\":null,\"administrative_area\":\"Vienna\",\"neighbourhood\":null,\"country\":\"United States\",\"country_code\":\"USA\",\"continent\":\"North America\",\"label\":\"Vienna, NY, USA\"},{\"latitude\":48.192288,\"longitude\":16.096632,\"type\":\"county\",\"name\":\"Wien Umgebung\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":0.4,\"region\":\"Lower Austria\",\"region_code\":\"NO\",\"county\":\"Wien Umgebung\",\"locality\":null,\"administrative_area\":null,\"neighbourhood\":null,\"country\":\"Austria\",\"country_code\":\"AUT\",\"continent\":\"Europe\",\"label\":\"Wien Umgebung, NO, Austria\"},{\"latitude\":48.191481,\"longitude\":16.099486,\"type\":\"county\",\"name\":\"Wien-Umgebung District\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":0.4,\"region\":\"Lower Austria\",\"region_code\":\"NO\",\"county\":\"Wien-Umgebung District\",\"locality\":null,\"administrative_area\":null,\"neighbourhood\":null,\"country\":\"Austria\",\"country_code\":\"AUT\",\"continent\":\"Europe\",\"label\":\"Wien-Umgebung District, NO, Austria\"},{\"latitude\":29.3783,\"longitude\":-96.79248,\"type\":\"locality\",\"name\":\"Vienna\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":1,\"region\":\"Texas\",\"region_code\":\"TX\",\"county\":\"Lavaca County\",\"locality\":\"Vienna\",\"administrative_area\":null,\"neighbourhood\":null,\"country\":\"United States\",\"country_code\":\"USA\",\"continent\":\"North America\",\"label\":\"Vienna, TX, USA\"},{\"latitude\":39.66086,\"longitude\":-92.78436,\"type\":\"locality\",\"name\":\"Wien\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":1,\"region\":\"Missouri\",\"region_code\":\"MO\",\"county\":\"Chariton County\",\"locality\":\"Wien\",\"administrative_area\":\"Bee Branch Township\",\"neighbourhood\":null,\"country\":\"United States\",\"country_code\":\"USA\",\"continent\":\"North America\",\"label\":\"Wien, MO, USA\"},{\"latitude\":43.178142,\"longitude\":-83.737106,\"type\":\"locality\",\"name\":\"Vienna\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":1,\"region\":\"Michigan\",\"region_code\":\"MI\",\"county\":\"Genesee County\",\"locality\":\"Vienna\",\"administrative_area\":\"Clio\",\"neighbourhood\":null,\"country\":\"United States\",\"country_code\":\"USA\",\"continent\":\"North America\",\"label\":\"Vienna, MI, USA\"},{\"latitude\":42.690542,\"longitude\":-80.835771,\"type\":\"locality\",\"name\":\"Vienna\",\"number\":null,\"postal_code\":null,\"street\":null,\"confidence\":1,\"region\":\"Ontario\",\"region_code\":\"ON\",\"county\":\"Elgin\",\"locality\":\"Vienna\",\"administrative_area\":null,\"neighbourhood\":null,\"country\":\"Canada\",\"country_code\":\"CAN\",\"continent\":\"North America\",\"label\":\"Vienna, ON, Canada\"}]";
            //List<Location> loc_List = objectMapper.readValue(teststr, new TypeReference<List<Location>>(){});

            System.out.println("Test");
        }catch (JsonParseException e) {
            e.printStackTrace();
        }catch (JsonMappingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return return_string;
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

