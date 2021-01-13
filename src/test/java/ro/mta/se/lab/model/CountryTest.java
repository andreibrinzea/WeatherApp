package ro.mta.se.lab.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Country} class
 * and contains parameterized tests
 *
 * @author Andrei Brinzea
 */

@RunWith(Parameterized.class)
public class CountryTest {

    /**
     * Function used to create and return specific object for
     * parameterized tests
     * @return an array list with specific objects used in
     * testings process
     */
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


    /**
     * Members of <b>CountryTest</b> class
     * <i>cities: </i> array list with cities
     * <i>countryCode: </i> country code
     * <i>country: </i> instance of class {@link Country}
      */
    private final ArrayList<City> cities;
    private final String countryCode;
    private final Country country;

    /**
     * <b>CountryTest</b> constructor class
     * @param cities array list with cities
     * @param countryCode country code
     * @param country instance of class {@link Country}
     */
    public CountryTest(ArrayList<City> cities, String countryCode, Country country) {
        this.cities = cities;
        this.countryCode = countryCode;
        this.country = country;
    }

    /**
     * Test functions used to check all country data
     */
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