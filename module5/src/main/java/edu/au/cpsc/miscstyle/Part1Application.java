/*
 * A program that launches four airport-themed buttons.
 * Module 5 Part1 file
 *
 * @author Addie Domanico - CPSC2710 - AO1
 * @version 02/12/2024
 */


package edu.au.cpsc.miscstyle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Part1Application extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Part1Application.class.getResource("part1.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Part 1");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
