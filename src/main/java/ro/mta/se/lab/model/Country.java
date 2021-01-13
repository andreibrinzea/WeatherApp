package ro.mta.se.lab.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * Model class used for saving specific values
 * for a Country.
 *
 * @author Andrei Brinzea
 */

public class Country {
    /**
     * Members of class <b>Country</b>
     * <i>cities: </i> list of cities from country
     * <i>countryCode: </i> specific country code
     */
    ArrayList<City> cities;
    StringProperty countryCode;

    /**
     * <b>Country</b> class constructor
     * @param cities list of cities from country
     * @param countryCode specific country code
     */
    public Country(ArrayList<City> cities, String countryCode) {
        this.cities = cities;
        this.countryCode = new SimpleStringProperty(countryCode);
    }

    /**
     * Function used to return a list of cities from country
     * @return list of cities from country
     */
    public ArrayList<City> getCities() {
        return cities;
    }

    /**
     * Function used to return country code country
     * @return country code in String format
     */
    public String getCountryCode() {
        return countryCode.get();
    }

    /**
     * Function used to return country code
     * @return country code in StringProperty format
     */
    public StringProperty countryCodeProperty() {
        return countryCode;
    }

    /**
     * Function used to a city in cities list
     * @param cityID ID of city
     * @param cityName name if city
     * @param latitude latitude of city
     * @param longitude longitude of city
     */
    public void addCity(String cityID, String cityName, Float latitude, Float longitude) {
        cities.add(new City(cityID, cityName, latitude, longitude));
    }
}
