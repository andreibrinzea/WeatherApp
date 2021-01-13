package ro.mta.se.lab.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

/**
 * Test class for {@link City} class
 * and contains parameterized tests
 *
 * @author Andrei Brinzea
 */

@RunWith(Parameterized.class)
public class CityTest {

    /**
     * Function used to create and return specific object for
     * parameterized tests
     * @return an array list with specific objects used in
     * testings process
     */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"2973393", "Tarascon", (float) 43.805828, (float) 4.6603,
                        new City("2973393", "Tarascon", (float) 43.805828, (float) 4.6603)},
                {"2986678", "Ploufragan", (float) 48.491409, (float) -2.7946,
                        new City("2986678", "Ploufragan", (float) 48.491409, (float) -2.7946)},
                {"819827", "Razvilka", (float) 55.591667, (float) -37.740833,
                        new City("819827", "Razvilka", (float) 55.591667, (float) -37.740833)}
        });
    }

    /**
     * Members of <b>CityTest</b> class
     * <i>cityID: </i> ID of city
     * <i>name: </i> name of city
     * <i>latitude: </i> latitude of city
     * <i>longitude: </i> longitude of city
     * <i>city: </i> instance of {@link City} class
     */
    private final String cityID;
    private final String name;
    private final float latitude;
    private final float longitude;
    private final City city;

    /**
     * <b>CityTest</b> constructor used for parameterized tests
     * @param cityID ID of city
     * @param name name of city
     * @param latitude latitude of city
     * @param longitude longitude of city
     * @param city instance of {@link City} class
     */
    public CityTest(String cityID, String name, float latitude, float longitude, City city) {
        this.cityID = cityID;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
    }

    /**
     * Test functions used to check all data from City object
     */
    @Test
    public void testForCheckAllData() {

        assertEquals(cityID, city.getCityID());
        assertEquals(name, city.getName());
        assertEquals(Float.toString(latitude), Float.toString(city.getLatitude()));
        assertEquals(Float.toString(longitude), Float.toString(city.getLongitude()));
    }

    /**
     * Test function used to check {@link City#getCityID()} method
     */
    @Test
    public void getCityIDTest() {
        assertEquals(cityID, city.getCityID());
    }

    /**
     * Test function used to check {@link City#getName()} method
     */
    @Test
    public void getNameTest() {
        assertEquals(name, city.getName());
    }

    /**
     * Test function used to check {@link City#getLatitude()} method
     */
    @Test
    public void getLatitudeTest() {
        assertEquals(Float.toString(latitude), Float.toString(city.getLatitude()));
    }

    /**
     * Test functions used to check {@link City#getLongitude()}
     */
    @Test
    public void getLongitudeTest() {
        assertEquals(Float.toString(longitude), Float.toString(city.getLongitude()));
    }
}