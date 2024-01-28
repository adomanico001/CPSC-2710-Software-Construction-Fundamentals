package edu.au.cpsc.module3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AirportApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

public class Airport {
    public String ident;
    public String type;
    public String name;
    public Integer elevationFt;
    public String continent;
    public String country;
    public String region;
    public String municipality;
    public String gpsCode;
    public String iataCode;
    public String localCode;
    public Integer coordinates;
}