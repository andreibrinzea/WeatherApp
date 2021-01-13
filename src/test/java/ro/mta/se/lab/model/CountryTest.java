package ro.mta.se.lab.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountryTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        ArrayList<City> city1 = new ArrayList<City>();
        city1.add(new City("2973393", "Tarascon", (float) 43.805828, (float) 4.6603));

        ArrayList<City> city2 = new ArrayList<City>();
        city2.add(new City("819827", "Razvilka", (float) 55.591667, (float) -37.740833));

        return Arrays.asList(new Object[][]{
                {city1, "FR", new Country(city1, "FR")},
                {city2, "RU", new Country(city2, "RU")}
        });
    }

    private final ArrayList<City> cities;
    private final String countryCode;
    private final Country country;

    public CountryTest(ArrayList<City> cities, String countryCode, Country country) {
        this.cities = cities;
        this.countryCode = countryCode;
        this.country = country;
    }

    @Test
    public void testForCheckCountryData() {

        assertEquals(countryCode, country.getCountryCode());
        assertEquals(cities.get(0).getCityID(), country.getCities().get(0).getCityID());
        assertEquals(cities.get(0).getName(), country.getCities().get(0).getName());
        assertEquals(Float.toString(cities.get(0).getLatitude()),
                Float.toString(country.getCities().get(0).getLatitude()));
        assertEquals(Float.toString(cities.get(0).getLongitude()),
                Float.toString(country.getCities().get(0).getLongitude()));
    }
}