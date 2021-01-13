package ro.mta.se.lab.model;

import javafx.beans.property.*;

/**
 * Model class used for saving specific values
 * for a City.
 *
 * @author Andrei Brinzea
 */

public class City {
    /**
     * Members of class <b>City</b>
     * <i>cityID: </i> ID of city
     * <i>name: </i> name of city
     * <i>latitude: </i> latitude of city
     * <i>longitude: </i> longitude of city
     */

    StringProperty cityID;
    StringProperty name;
    FloatProperty latitude;
    FloatProperty longitude;

    /**
     * <b>City</b> class constructor
     * @param cityID ID of city
     * @param name name of city
     * @param latitude latitude of city
     * @param longitude longitude of city
     */
    public City(String cityID, String name, float latitude, float longitude) {
        this.cityID = new SimpleStringProperty(cityID);
        this.name = new SimpleStringProperty(name);
        this.latitude = new SimpleFloatProperty(latitude);
        this.longitude = new SimpleFloatProperty(longitude);
    }

    /**
     * Function used to return city ID
     * @return ID of city in String format
     */
    public String getCityID() {
        return cityID.get();
    }

    /**
     * Function used to return city ID
     * @return ID of city in StringProperty format
     */
    public StringProperty cityIDProperty() {
        return cityID;
    }

    /**
     * Function used to return city name
     * @return name of city in String format
     */
    public String getName() {
        return name.get();
    }

    /**
     * Function used to return city name
     * @return name of city in StringProperty format
     */
    public StringProperty nameProperty() {
        return name;
    }

    /**
     * Function used to return city latitude
     * @return latitude of city in float format
     */
    public float getLatitude() {
        return latitude.get();
    }

    /**
     * Function used to return city latitude
     * @return latitude of city in FloatProperty format
     */
    public FloatProperty latitudeProperty() {
        return latitude;
    }

    /**
     * Function used to return city longitude
     * @return longitude of city in float format
     */
    public float getLongitude() {
        return longitude.get();
    }

    /**
     * Function used to return city longitude
     * @return longitude of city in FloatProperty format
     */
    public FloatProperty longitudeProperty() {
        return longitude;
    }


}
