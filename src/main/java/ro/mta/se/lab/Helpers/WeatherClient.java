package ro.mta.se.lab.Helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Class used to make request and save data from server
 *
 * @author Andrei Brinzea
 */
public class WeatherClient {
    /**
     * Members of <b>WeatherClient</b> class
     * <i>weatherClient_instance</i> instance of class because is a
     * singleton class
     * <i>apiKey</i> key used for weather API
     */

    private static WeatherClient weatherClient_instance = null;
    private final String apiKey;

    /**
     * <b>WeatherClient</b> class constructor
     * Set value of api key
     */
    private WeatherClient() {
        apiKey = "e434ef29d319e8fb8c77d99dea69187e";
    }

    /**
     * Function used to return instance of class
     * @return instance of class
     */
    public static WeatherClient getInstance() {
        if (weatherClient_instance == null) {
            weatherClient_instance = new WeatherClient();
        }
        return weatherClient_instance;
    }

    /**
     * Function used to return api key value
     * @return api key value
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Function used to return response from server
     * after request
     * @param cityID ID of city
     * @return response received from server
     * @throws IOException if city ID is invalid
     */
    public String getResults(String cityID) throws IOException {
        String requestURL = "http://api.openweathermap.org/data/2.5/weather?id=" +
                cityID + "&appid=" + apiKey + "&units=metric";

        String responseData = "";
        StringBuilder result = new StringBuilder();
        String line;

        URL url = new URL(requestURL);
        URLConnection conn = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();

        responseData = result.toString();

        return responseData;
    }


}
