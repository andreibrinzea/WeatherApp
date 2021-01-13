package ro.mta.se.lab.model;

import javafx.beans.property.*;

public class City {
    StringProperty cityID;
    StringProperty name;
    FloatProperty latitude;
    FloatProperty longitude;

    public City(String cityID, String name, float latitude, float longitude) {
        this.cityID = new SimpleStringProperty(cityID);
        this.name = new SimpleStringProperty(name);
        this.latitude = new SimpleFloatProperty(latitude);
        this.longitude = new SimpleFloatProperty(longitude);
    }


    public String getCityID() {
        return cityID.get();
    }

    public StringProperty cityIDProperty() {
        return cityID;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public float getLatitude() {
        return latitude.get();
    }

    public FloatProperty latitudeProperty() {
        return latitude;
    }

    public float getLongitude() {
        return longitude.get();
    }

    public FloatProperty longitudeProperty() {
        return longitude;
    }


}
