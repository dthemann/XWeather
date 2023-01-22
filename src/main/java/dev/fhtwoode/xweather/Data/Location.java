package dev.fhtwoode.xweather.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Location {

    @JsonProperty("latitude")
    public double getLatitude() {
        return this.latitude; }
    public void setLatitude(double latitude) {
        this.latitude = latitude; }
    double latitude;

    @JsonProperty("longitude")
    public double getLongitude() {
        return this.longitude; }
    public void setLongitude(double longitude) {
        this.longitude = longitude; }
    double longitude;
    @JsonProperty("type")
    public String getType() {
        return this.type; }
    public void setType(String type) {
        this.type = type; }
    String type;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("number")
    public String getNumber() {
        return this.number; }
    public void setNumber(String number) {
        this.number = number; }
    String number;
    @JsonProperty("postal_code")
    public String getPostal_code() {
        return this.postal_code; }
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code; }
    String postal_code;
    @JsonProperty("street")
    public String getStreet() {
        return this.street; }
    public void setStreet(String street) {
        this.street = street; }
    String street;
    @JsonProperty("confidence")
    public int getConfidence() {
        return this.confidence; }
    public void setConfidence(int confidence) {
        this.confidence = confidence; }
    int confidence;
    @JsonProperty("region")
    public String getRegion() {
        return this.region; }
    public void setRegion(String region) {
        this.region = region; }
    String region;
    @JsonProperty("region_code")
    public String getRegion_code() {
        return this.region_code; }
    public void setRegion_code(String region_code) {
        this.region_code = region_code; }
    String region_code;
    @JsonProperty("county")
    public String getCounty() {
        return this.county; }
    public void setCounty(String county) {
        this.county = county; }
    String county;
    @JsonProperty("locality")
    public String getLocality() {
        return this.locality; }
    public void setLocality(String locality) {
        this.locality = locality; }
    String locality;
    @JsonProperty("administrative_area")
    public Object getAdministrative_area() {
        return this.administrative_area; }
    public void setAdministrative_area(Object administrative_area) {
        this.administrative_area = administrative_area; }
    Object administrative_area;
    @JsonProperty("neighbourhood")
    public String getNeighbourhood() {
        return this.neighbourhood; }
    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood; }
    String neighbourhood;
    @JsonProperty("country")
    public String getCountry() {
        return this.country; }
    public void setCountry(String country) {
        this.country = country; }
    String country;
    @JsonProperty("country_code")
    public String getCountry_code() {
        return this.country_code; }
    public void setCountry_code(String country_code) {
        this.country_code = country_code; }
    String country_code;
    @JsonProperty("continent")
    public String getContinent() {
        return this.continent; }
    public void setContinent(String continent) {
        this.continent = continent; }
    String continent;
    @JsonProperty("label")
    public String getLabel() {
        return this.label; }
    public void setLabel(String label) {
        this.label = label; }
    String label;
}
