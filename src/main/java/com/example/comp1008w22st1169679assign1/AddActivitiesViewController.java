package com.example.comp1008w22st1169679assign1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddActivitiesViewController implements Initializable {

    @FXML
    private Button goBackButton;

    @FXML
    private TextArea textBox;

    @FXML
    private Label topLabel;

    // private static Student variable
    private static Student student;

    /**
     * method that sets the student variable
     * @param student set the static private instance variable to this parameter
     */
    public void setStudent(Student student) {
        AddActivitiesViewController.student = student;
    }

    /**
     * method that returns the student variable (needed for passing info between scenes)
     * @return
     */
    public static Student getStudent() {
        return student;
    }

    /**
     * When this method is called, it will change the scene
     */
    public void changeScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("student-card-view.fxml"));
        Scene scene = new Scene(loader.load());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    /**
     * When this method is called, it will change the scene
     */
    public void changeScenePlusAddActivity(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("student-card-view.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);

        StudentCardViewController controller = loader.getController();
        controller.initData(textBox.getText());
        controller.setStudent(student);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
