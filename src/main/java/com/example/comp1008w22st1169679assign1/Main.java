package com.example.comp1008w22st1169679assign1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


// main class that extends the application class
public class Main extends Application {

    // override the start method
    @Override
    public void start(Stage stage) throws IOException {
        // make a new fxml loader object, and link it to the student-card-view.fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("student-card-view.fxml"));
        // make a new scene with the fxml loader
        Scene scene = new Scene(fxmlLoader.load());
        // set the title to the scene
        stage.setTitle("Student Card");
        // set the stage parameter to the scene, and show it
        stage.setScene(scene);
        stage.show();
    }

    // main method that runs the launch() method
    public static void main(String[] args) {
        launch();
    }
}