package ro.mta.se.lab.Helpers;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class used to log data displayed in
 * interface to a specific log file
 *
 * @author Andrei Brinzea
 */
public class Logger {
    /**
     * Members of <b>Logger</b> class
     * <i>logger_instance: </i> instance of class because this
     * is a singleton class
     * <i>logFile: </i> file for log data
     */

    private static Logger logger_instance = null;

    private final FileWriter logFile;

    /**
     * <b>Logger</b> class constructor
     * @param logFile file for log
     */
    private Logger(FileWriter logFile) {
        this.logFile = logFile;
    }

    /**
     * Function used to return class instance
     * @return instance of class
     */
    public static Logger getInstance() {
        return logger_instance;
    }

    /**
     * Function that return instance of class and
     * create specific instance of class if it's null
     * @param fw file writer for log file
     * @return instance of class
     */
    public static Logger getInstance(FileWriter fw) {
        if (logger_instance == null) {
            logger_instance = new Logger(fw);
        }
        return logger_instance;
    }

    /**
     * Function used to save data in log file
     * @param country country name
     * @param city city name
     * @param completeDate date when data was received from server
     * @param description description of weather
     * @param grade number of degrees (Celsius)
     * @param pressure pressure value
     * @param humidity humidity value
     * @param wind wind
     * @param mainWeather main weather description
     */
    public void log(String country, String city, String completeDate, String description, String grade,
                    String pressure, String humidity, String wind, String mainWeather) {

        StringBuilder logMessage = new StringBuilder();

        logMessage.append(completeDate).append(": ");
        logMessage.append("Country: ").append(country).append("  City:").append(city).append(System.getProperty("line.separator"));
        logMessage.append("Main weather: ").append(description).append(System.getProperty("line.separator"));
        logMessage.append("Weather description: ").append(mainWeather).append(System.getProperty("line.separator"));
        logMessage.append("Degrees: ").append(grade).append("°C").append(System.getProperty("line.separator"));
        logMessage.append("Pressure: ").append(pressure).append(" hPa").append(System.getProperty("line.separator"));
        logMessage.append("Humidity: ").append(humidity).append("%").append(System.getProperty("line.separator"));
        logMessage.append("Wind: ").append(wind).append("km/h").append(System.getProperty("line.separator"));
        logMessage.append(System.getProperty("line.separator"));

        try {
            logFile.write(logMessage.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
