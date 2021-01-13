package ro.mta.se.lab.Helpers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ro.mta.se.lab.CustomExceptions.DuplicateCityException;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.model.Country;

import java.io.*;
import java.util.ArrayList;

/**
 * Class used to save date from input file
 *
 * @author Andrei Brinzea
 */
public class Parser {
    /**
     * Members of class <b>Parser</b>
     * <i>initCountries: </i> list where store countries
     * and specific cities values from input file
     * <i>inputFilename: </i> input filename
     */
    private final ObservableList<Country> initCountries;
    private final String inputFilename;

    /**
     * Function used to return input filename
     * @return input filename
     */
    public String getInputFilename() {
        return inputFilename;
    }

    /**
     * <b>Parser</b> class constructor
     * @param inputFilename name of input file
     */
    public Parser(String inputFilename) {
        this.initCountries = FXCollections.observableArrayList();
        this.inputFilename = inputFilename;
    }

    /**
     * <b>Parser</b> class constructor
     * @param inputFilename name of input file
     * @param countries list of countries
     */
    public Parser(String inputFilename, ObservableList<Country> countries) {
        this.initCountries = countries;
        this.inputFilename = inputFilename;
    }

    /**
     * Function used to return list of countries and specific
     * values for cities read from input file
     * @return list of countries
     * @throws IOException  if reading from input filename is invalid
     */
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

    /**
     * Function getter used to return list of countries
     * @return list of countries
     */
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

    /**
     * Function used to add a specific city in country list
     * @param cityID ID of city
     * @param cityName name of city
     * @param latitude latitude of city
     * @param longitude longitude of city
     * @param countryCode country code where city will be added
     * @throws DuplicateCityException if city has been already added
     */
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
