package ro.mta.se.lab.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CityTest {

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

    private final String cityID;
    private final String name;
    private final float latitude;
    private final float longitude;
    private final City city;

    public CityTest(String cityID, String name, float latitude, float longitude, City city) {
        this.cityID = cityID;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
    }

    @Test
    public void testForCheckAllData() {

        assertEquals(cityID, city.getCityID());
        assertEquals(name, city.getName());
        assertEquals(Float.toString(latitude), Float.toString(city.getLatitude()));
        assertEquals(Float.toString(longitude), Float.toString(city.getLongitude()));
    }

    @Test
    public void getCityIDTest() {
        assertEquals(cityID, city.getCityID());
    }

    @Test
    public void getNameTest() {
        assertEquals(name, city.getName());
    }

    @Test
    public void getLatitudeTest() {
        assertEquals(Float.toString(latitude), Float.toString(city.getLatitude()));
    }

    @Test
    public void getLongitudeTest() {
        assertEquals(Float.toString(longitude), Float.toString(city.getLongitude()));
    }
}