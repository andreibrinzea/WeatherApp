package ro.mta.se.lab.Helpers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ro.mta.se.lab.CustomExceptions.DuplicateCityException;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.model.Country;

import java.io.*;
import java.util.ArrayList;

public class Parser {
    private final ObservableList<Country> initCountries;


    public String getInputFilename() {
        return inputFilename;
    }

    private final String inputFilename;

    public Parser(String inputFilename) {
        this.initCountries = FXCollections.observableArrayList();
        this.inputFilename = inputFilename;
    }

    public Parser(String inputFilename, ObservableList<Country> countries) {
        this.initCountries = countries;
        this.inputFilename = inputFilename;
    }

    public ObservableList<Country> getInitData() throws IOException {
        ArrayList<String> fileLines = readFromFile();

        int i;
        String cityID;
        String cityName;
        float latitude;
        float longitude;
        String countryCode;

        for (i = 0; i < fileLines.size(); i++) {
            cityID = fileLines.get(i).replaceAll("\\s+", " ").split(" ")[0];
            cityName = fileLines.get(i).replaceAll("\\s+", " ").split(" ")[1];
            latitude = Float.parseFloat(fileLines.get(i).replaceAll("\\s+", " ").split(" ")[2]);
            longitude = Float.parseFloat(fileLines.get(i).replaceAll("\\s+", " ").split(" ")[3]);
            countryCode = fileLines.get(i).replaceAll("\\s+", " ").split(" ")[4];

            try {
                addCityInCountriesList(cityID, cityName, latitude, longitude, countryCode);
            } catch (DuplicateCityException e) {
                e.printStackTrace();
            }
        }

        return initCountries;
    }

    public ObservableList<Country> getInitCountries() {
        return initCountries;
    }

    public ArrayList<String> readFromFile() throws IOException {
        String data = "";
        ArrayList<String> fileLines = new ArrayList<String>();

        FileInputStream fstream = new FileInputStream(inputFilename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
        String line;

        while ((line = reader.readLine()) != null) {
            fileLines.add(line);
        }

        fstream.close();
        reader.close();

        fileLines.remove(0);

        return fileLines;
    }


    public void addCityInCountriesList(String cityID, String cityName, Float latitude,
                                       Float longitude, String countryCode) throws DuplicateCityException {
        int i, j;

        for (i = 0; i < initCountries.size(); i++) {
            if (initCountries.get(i).getCountryCode().equals(countryCode)) {

                for (j = 0; j < initCountries.get(i).getCities().size(); j++) {
                    if (initCountries.get(i).getCities().get(j).getCityID().equals(cityID)) {
                        throw new DuplicateCityException("City already exists in country list!");
                    }
                }
                initCountries.get(i).addCity(cityID, cityName, latitude, longitude);
                return;
            }
        }

        ArrayList<City> cities = new ArrayList<City>();
        cities.add(new City(cityID, cityName, latitude, longitude));

        initCountries.add(new Country(cities, countryCode));

    }

}
