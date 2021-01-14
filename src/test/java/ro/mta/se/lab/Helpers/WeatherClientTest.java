package ro.mta.se.lab.Helpers;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import static org.junit.Assert.*;

/**
 * Test class for {@link WeatherClient} class
 *
 * @author Andrei Brinzea
 */

public class WeatherClientTest {
    /**
     * Members of <b>WeatherClientTest</b> class
     * <i>client: </i> instance of {@link WeatherClient} class
     * <i>apiKey: </i> api key value
     * <i>invalidCityID: </i> invalid city ID
     * <i>validCityID: </i> valid city ID
     */

    public static WeatherClient client = null;
    private static String apiKey = null;
    String invalidCityID = null;
    String validCityID = null;

    /**
     * Function used to set specific values before tests
     */
    @BeforeClass
    public static void setUp() {
        client = WeatherClient.getInstance();
        apiKey = "e434ef29d319e8fb8c77d99dea69187e";
    }

    /**
     * Function used to set <i>invalidCityID</i> and
     * <i>validCityID</i> before every test
     */
    @Before
    public void setCityIDs() {
        invalidCityID = "invalid";
        validCityID = "2973393";
    }

    @Rule
    public ExpectedException WeatherClientException = ExpectedException.none();

    /**
     * Test functions used to check results for an invalid city ID
     * @throws IOException if file operations will failed
     */
    @Test
    public void getResultsIfCityIDisInvalid() throws IOException {
        WeatherClientException.expect(IOException.class);
        client.getResults(invalidCityID);
    }

    /**
     * Test function used to check for an valid city ID
     * @throws IOException if file operations will failed
     */
    @Test
    public void getResultsIfCityIsValid() throws IOException {
        String responseData = null;
        responseData = client.getResults(validCityID);

        assertNotNull(responseData);

        JsonObject baseObject = Json.parse(responseData).asObject();
        JsonArray weatherArray = baseObject.get("weather").asArray();
        JsonObject mainObject = baseObject.get("main").asObject();

        int cityID = 0;
        String mainDescription = null;
        String description = null;
        float degree = 0;
        float pressure = 0;
        float humidity = 0;
        float wind = 0;

        cityID = baseObject.getInt("id", 0);
        mainDescription = weatherArray.get(0).asObject().getString("main", null);
        description = weatherArray.get(0).asObject().getString("description", null);

        degree = mainObject.getFloat("temp", 0);
        pressure = mainObject.getFloat("pressure", 0);
        humidity = mainObject.getFloat("humidity", 0);
        wind = baseObject.get("wind").asObject().getFloat("speed", 0);

        //Check if values from response are valid
        assertEquals(validCityID, Integer.toString(cityID));
        assertNotNull(mainDescription);
        assertNotNull(description);
        assertNotEquals(0, degree);
        assertNotEquals(0, pressure);
        assertNotEquals(0, humidity);
        assertNotEquals(0, wind);

    }

    /**
     * Test functions to check instance of {@link WeatherClient}
     * class
     */
    @Test
    public void getInstance() {
        assertNotNull(client);
        assertSame(client, WeatherClient.getInstance());
        assertEquals(apiKey, client.getApiKey());
    }

    /**
     * Clear data after tests
     */
    @AfterClass
    public static void clearData() {
        client = null;
        apiKey = null;
    }

    /**
     * Clear data after every test
     */
    @After
    public void clearCityIDs() {
        invalidCityID = null;
        validCityID = null;
    }

}