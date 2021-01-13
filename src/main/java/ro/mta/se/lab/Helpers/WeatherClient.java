package ro.mta.se.lab.Helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WeatherClient {

    private static WeatherClient weatherClient_instance = null;

    private final String apiKey;

    private WeatherClient() {
        apiKey = "e434ef29d319e8fb8c77d99dea69187e";
    }

    public static WeatherClient getInstance() {
        if (weatherClient_instance == null) {
            weatherClient_instance = new WeatherClient();
        }
        return weatherClient_instance;
    }

    public String getApiKey() {
        return apiKey;
    }

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
