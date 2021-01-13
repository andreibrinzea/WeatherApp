package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ro.mta.se.lab.Helpers.Logger;
import ro.mta.se.lab.Helpers.Parser;
import ro.mta.se.lab.controller.WeatherController;

import java.io.FileWriter;
import java.io.IOException;


public class Main extends Application {
    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("src/main/resources/log.txt", true);
            Logger logger = Logger.getInstance(fw);

            launch(args);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();
        Parser parserFile = new Parser("src/main/resources/input.txt");

        try {
            loader.setLocation(this.getClass().getResource("/view/WeatherView.fxml"));
            loader.setController(new WeatherController(parserFile.getInitData()));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.getIcons().add(new Image("file:ImageResources/iconApp.png"));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
