package ro.mta.se.lab.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Country {
    ArrayList<City> cities;
    StringProperty countryCode;

    public Country(ArrayList<City> cities, String countryCode) {
        this.cities = cities;
        this.countryCode = new SimpleStringProperty(countryCode);
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public String getCountryCode() {
        return countryCode.get();
    }

    public StringProperty countryCodeProperty() {
        return countryCode;
    }

    public void addCity(String cityID, String cityName, Float latitude, Float longitude) {
        cities.add(new City(cityID,cityName,latitude,longitude));
    }
}
