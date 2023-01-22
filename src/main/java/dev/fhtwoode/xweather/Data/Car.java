package dev.fhtwoode.xweather.Data;

public class Car {

    public Car() {
    }

    public Car(String brand, int doors) {
        this.brand = brand;
        this.doors = doors;
    }

    private String brand = null;
    private int doors = 0;

    public String getBrand() { return this.brand; }
    public void   setBrand(String brand){ this.brand = brand;}

    public int  getDoors() { return this.doors; }
    public void setDoors (int doors) { this.doors = doors; }

}

// standard getters setters

