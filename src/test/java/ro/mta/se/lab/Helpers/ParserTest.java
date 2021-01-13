package ro.mta.se.lab.Helpers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import ro.mta.se.lab.CustomExceptions.DuplicateCityException;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.model.Country;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ParserTest {
    Parser parserInstance;
    ObservableList<Country> countries;
    ArrayList<String> initDataFile;
    ArrayList<City> citiesForMock;

    @Before
    public void setUp() {
        parserInstance = mock(Parser.class);
        initDataFile = new ArrayList<String>();
        citiesForMock = new ArrayList<City>();

        citiesForMock.add(new City("2973393", "Tarascon", (float) 43.805828, (float) 4.6603));
        citiesForMock.add(new City("2986678", "Ploufragan", (float) 48.491409, (float) -2.7946));

        countries = FXCollections.observableArrayList();
        countries.add(new Country(citiesForMock, "FR"));
    }

    @Test
    public void getInitDataWithMock() {
        try {
            when(parserInstance.getInitData()).thenReturn(countries);

            Country mockCountry = Mockito.mock(Country.class);
            when(mockCountry.getCities()).thenReturn(citiesForMock);

            ObservableList<Country> mockCountries = parserInstance.getInitData();

            ArrayList<City> citiesReturned = mockCountries.get(0).getCities();
            for (int i = 0; i < citiesForMock.size(); i++) {
                assertEquals(citiesForMock.get(i).getCityID(), citiesReturned.get(i).getCityID());
                assertEquals(citiesForMock.get(i).getName(), citiesReturned.get(i).getName());
                assertEquals(Float.toString(citiesForMock.get(i).getLatitude()), Float.toString(citiesReturned.get(i).getLatitude()));
                assertEquals(Float.toString(citiesForMock.get(i).getLongitude()), Float.toString(citiesReturned.get(i).getLongitude()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addNewCityInList() {
        try {
            when(parserInstance.getInitData()).thenReturn(countries);
            Country mockCountry = Mockito.mock(Country.class);
            when(mockCountry.getCities()).thenReturn(citiesForMock);

            ObservableList<Country> mockCountries = parserInstance.getInitData();

            City cityForAdd = Mockito.mock(City.class);
            when(cityForAdd.getCityID()).thenReturn("819827");
            when(cityForAdd.getName()).thenReturn("Razvilka");
            when(cityForAdd.getLatitude()).thenReturn((float) (55.591667));
            when(cityForAdd.getLatitude()).thenReturn((float) (37.740833));
            when(mockCountry.getCountryCode()).thenReturn("RU");

            Parser newParser = new Parser("", mockCountries);
            newParser.addCityInCountriesList(cityForAdd.getCityID(), cityForAdd.getName(), cityForAdd.getLatitude(),
                    cityForAdd.getLongitude(), mockCountry.getCountryCode());

            ObservableList<Country> newMockCountries = newParser.getInitCountries();

            assertEquals(cityForAdd.getCityID(), newMockCountries.get(1).getCities().get(0).getCityID());
            assertEquals(cityForAdd.getName(), newMockCountries.get(1).getCities().get(0).getName());
            assertEquals(Float.toString(cityForAdd.getLatitude()),
                    Float.toString(newMockCountries.get(1).getCities().get(0).getLatitude()));
            assertEquals(Float.toString(cityForAdd.getLongitude()),
                    Float.toString(newMockCountries.get(1).getCities().get(0).getLongitude()));

        } catch (IOException | DuplicateCityException e) {
            e.printStackTrace();
        }
    }

    @Rule
    public ExpectedException duplicateCityException = ExpectedException.none();

    @Test
    public void checkDuplicateCityException() throws DuplicateCityException {
        try {
            duplicateCityException.expect(DuplicateCityException.class);
            duplicateCityException.expectMessage("City already exists in country list!");

            when(parserInstance.getInitData()).thenReturn(countries);
            Country mockCountry = Mockito.mock(Country.class);
            when(mockCountry.getCities()).thenReturn(citiesForMock);

            ObservableList<Country> mockCountries = parserInstance.getInitData();

            Parser newParser = new Parser("", mockCountries);
            newParser.addCityInCountriesList("2973393", "Tarascon", (float) 43.805828, (float) 4.6603, "FR");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @After
    public void clearData() {
        parserInstance = null;
        initDataFile = null;
        countries = null;
        citiesForMock = null;
    }

}