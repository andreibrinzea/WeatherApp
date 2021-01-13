package ro.mta.se.lab.Helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger logger_instance = null;

    private final FileWriter logFile;

    private Logger(FileWriter logFile) {
        this.logFile = logFile;
    }

    public static Logger getInstance() {
        return logger_instance;
    }

    public static Logger getInstance(FileWriter fw) {
        if (logger_instance == null) {
            logger_instance = new Logger(fw);
        }
        return logger_instance;
    }

    public void log(String country, String city, String completeDate, String description, String grade,
                    String pressure, String humidity, String wind, String mainWeather) {

        StringBuilder logMessage = new StringBuilder();

        logMessage.append(completeDate).append(": ");
        logMessage.append("Country: ").append(country).append("  City:").append(city).append(System.getProperty("line.separator"));
        logMessage.append("Main weather: ").append(description).append(System.getProperty("line.separator"));
        logMessage.append("Weather description: ").append(mainWeather).append(System.getProperty("line.separator"));
        logMessage.append("Degree: ").append(grade).append("°C").append(System.getProperty("line.separator"));
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
