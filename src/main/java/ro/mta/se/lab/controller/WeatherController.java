package ro.mta.se.lab.controller;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;
import ro.mta.se.lab.CustomExceptions.InvalidCountryException;
import ro.mta.se.lab.Helpers.Logger;
import ro.mta.se.lab.Helpers.WeatherClient;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.model.Country;
import ro.mta.se.lab.model.CountryNames;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class WeatherController {
    private final ObservableList<Country> countryData;
    private final ObservableList<City> currentCitiesData;

    @FXML
    private ComboBox<Country> countryBox;

    @FXML
    private ComboBox<City> cityBox;

    @FXML
    private Label cityLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label pressureLabel;

    @FXML
    private Label humidityLabel;

    @FXML
    private Label windLabel;

    @FXML
    private Label degreeLabel;

    @FXML
    private ImageView imageView;


    public WeatherController(ObservableList<Country> countryData) {
        this.countryData = countryData;
        currentCitiesData = FXCollections.observableArrayList();
    }

    @FXML
    private void initialize() {
        countryBox.setPromptText("Choose a country");
        cityBox.setPromptText("City");

        countryBox.itemsProperty().setValue(countryData);

        countryBox.setConverter(new StringConverter<Country>() {
            @Override
            public String toString(Country country) {
                String countryName = null;
                try {
                    countryName = CountryNames.getInstance().getCountryNamesbyCode(country.getCountryCode());

                    if (countryName.equals("")) {
                        countryName = CountryNames.getInstance().getCountryNamesbyCode(countryData.get(0).getCountryCode());
                    }
                } catch (InvalidCountryException e) {
                    e.printStackTrace();
                }
                return countryName;
            }

            @Override
            public Country fromString(String val) {
                String countryName = "";

                for (Country country : countryData) {
                    try {
                        countryName = CountryNames.getInstance().getCountryNamesbyCode(country.getCountryCode());
                    } catch (InvalidCountryException e) {
                        e.printStackTrace();
                    }
                    if (countryName.equals(val)) {
                        return country;
                    }
                }
                return countryData.get(0);
            }
        });

        countryBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Country>() {
            @Override
            public void changed(ObservableValue<? extends Country> observable, Country oldValue, Country newValue) {
                if (newValue != null) {
                    showCities(newValue.getCountryCode());
                    cityBox.getSelectionModel().selectFirst();
                }
            }
        });

        cityBox.setConverter(new StringConverter<City>() {
            @Override
            public String toString(City city) {
                return city.getName();
            }

            @Override
            public City fromString(String val) {
                for (City city : currentCitiesData) {
                    if (city.getName().equals(val)) {
                        return city;
                    }
                }
                return currentCitiesData.get(0);
            }
        });

        cityBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<City>() {
            @Override
            public void changed(ObservableValue<? extends City> observable, City oldValue, City newValue) {
                if (newValue != null) {
                    showWeatherVoid(newValue.getCityID());
                }
            }
        });

        countryBox.getSelectionModel().selectFirst();

    }

    private void showCities(String countryCode) {
        int i;

        for (Country country : countryData) {
            if (country.getCountryCode().equals(countryCode)) {
                currentCitiesData.clear();
                for (i = 0; i < country.getCities().size(); i++) {
                    currentCitiesData.add(country.getCities().get(i));
                }
            }
        }
        cityBox.itemsProperty().setValue(currentCitiesData);

    }


    private void showWeatherVoid(String cityID) {
        float degree = 0;
        float humidity = 0;
        float pressure = 0;
        float wind = 0;
        String description = "";
        String name = "";
        String mainDescription = "";
        String countryName = "";
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        DateFormat formatForDay = new SimpleDateFormat("EEEE");
        String currentDay;
        String completeDate;
        String results = "";

        try {
            results = WeatherClient.getInstance().getResults(cityID);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!results.equals("")) {
            JsonObject baseObject = Json.parse(results).asObject();
            JsonArray weatherArray = baseObject.get("weather").asArray();
            JsonObject mainObject = baseObject.get("main").asObject();

            mainDescription = weatherArray.get(0).asObject().getString("main", "Unknown");
            description = weatherArray.get(0).asObject().getString("description", "Unknown");

            description = description.substring(0, 1).toUpperCase() + description.substring(1);
            degree = mainObject.getFloat("temp", 0);
            pressure = mainObject.getFloat("pressure", 0);
            humidity = mainObject.getFloat("humidity", 0);
            wind = baseObject.get("wind").asObject().getFloat("speed", 0);
            name = getCityNamebyID(cityID);

            long timezone = baseObject.getLong("timezone", 0);
            long datetime = Instant.now().toEpochMilli() - 7200 * 1000;
            datetime += (timezone * 1000);

            Date date = new Date(datetime);
            currentDay = formatForDay.format(date);
            completeDate = currentDay + " " + formatter.format(date);

            descriptionLabel.setText(description);
            degreeLabel.setText(Float.toString(degree) + " °C");
            degreeLabel.setAlignment(Pos.BASELINE_RIGHT);
            pressureLabel.setText(Float.toString(pressure) + " hPa");
            humidityLabel.setText(Float.toString(humidity) + "%");
            cityLabel.setText(name);
            windLabel.setText(Float.toString(wind) + " km/h");
            dateLabel.setText(completeDate);

            try {
                countryName = CountryNames.getInstance().getCountryNamesbyCode(countryBox.getValue().getCountryCode());
            } catch (InvalidCountryException e) {
                e.printStackTrace();
            }

            Logger.getInstance().log(countryName, name, completeDate, description, Float.toString(degree),
                    Float.toString(pressure), Float.toString(humidity), Float.toString(wind), mainDescription);

            String imageFilename = getImageFilename(baseObject);
            try {
                Image image = new Image(new FileInputStream(imageFilename));
                imageView.setImage(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            descriptionLabel.setText("");
            degreeLabel.setText("");
            pressureLabel.setText("");
            humidityLabel.setText("");
            cityLabel.setText("");
            windLabel.setText("");
            dateLabel.setText("");
        }
    }

    private String getCityNamebyID(String cityID) {

        for (City city : currentCitiesData) {
            if (city.getCityID().equals(cityID)) {
                return city.getName();
            }
        }

        return currentCitiesData.get(0).getName();
    }

    private String getImageFilename(JsonObject baseObject) {
        StringBuilder imageFilename = new StringBuilder();
        JsonArray weatherArray = baseObject.get("weather").asArray();

        imageFilename.append("src/main/resources/ImageResources/");
        imageFilename.append(weatherArray.get(0).asObject().getString("icon", "03d"));
        imageFilename.append(".png");

        return imageFilename.toString();
    }

}
