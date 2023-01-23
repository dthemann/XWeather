package dev.fhtwoode.xweather.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.fhtwoode.xweather.Data.Location;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.JsonMappingException;


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
    private ListView<String> lv_Locations;

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
            List<Location> API_return = mapLocationstoList(getLocationsJsonString(searchLocationtext));

            ObservableList<String> ob_list = FXCollections.observableArrayList();

            for (Location temp :  API_return)
            {
                ob_list.add(temp.getLabel() + " | " + temp.getAdministrative_area() + " | Lat:" + temp.getLatitude() + " | Lng:" + temp.getLongitude());
            }

            lv_Locations.setItems(ob_list);

        } catch (Exception e)
        {

        }

    }

    @FXML
    void bt_selectLocationButtonClicked(MouseEvent event) {

        String location = lv_Locations.getSelectionModel().getSelectedItem();
        Double new_lat = Double.parseDouble(location.substring(location.indexOf("Lat:") + 1, location.indexOf("|", location.indexOf("Lat:"))));
        Double new_lng = Double.parseDouble(location.substring(location.indexOf("Lng:") + 1, location.length()));

        System.out.println("Selected Lat: " + new_lat);
        System.out.println("Selected Lng: " + new_lng);

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

    private String getLocationsJsonString(String searchLocation) throws IOException {

        StringBuilder API_return = new StringBuilder();
        String bufferString = "";

        try {
            StringBuilder request_string = new StringBuilder();
            request_string.append("http://api.positionstack.com/v1/forward?access_key=0fe88b60549294f08f0a9402b26b04ef&query=");
            request_string.append(searchLocation);
            request_string.append("&fields=results.latitude,results.longitude&output=json");

            //URL url = new URL("http://api.positionstack.com/v1/forward?access_key=0fe88b60549294f08f0a9402b26b04ef&query=Wien&fields=results.latitude,results.longitude&output=json");
            URL url = new URL(request_string.toString());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            } else
            {
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                while ((bufferString = br.readLine())!= null) {
                    API_return.append(bufferString);
                }
                conn.disconnect();
                return API_return.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Location> mapLocationstoList(String jsonString)
    {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String con_string = jsonString.substring(jsonString.indexOf("["), jsonString.lastIndexOf("]") + 1);
            List<Location> loc_List = objectMapper.readValue(con_string, new TypeReference<List<Location>>(){});
            return loc_List;
        }catch (JsonParseException e) {
            e.printStackTrace();
        }catch (JsonMappingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

