package com.example.comp1008w22st1169679assign1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentCardViewController implements Initializable {

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label studentNumberLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<String> activitiesList;

    /**
     * When this method is called, it will change the scene
     */
    public void changeScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("add-activities-view.fxml"));
        Scene scene = new Scene(loader.load());

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    /**
     *  overridden initialize method to run all the code in the controller
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // instantiate a new student object with my information
        Student me = new Student("Michael", "Rosanelli", 1169679);
        // set the text of the labels based on the objects "get" methods
        firstNameLabel.setText(me.getFirstName());
        lastNameLabel.setText(me.getLastName());
        studentNumberLabel.setText(Integer.toString(me.getStudentNumber()));
        // set the image view based on the student object's "getImage()" method
        imageView.setImage(me.getImage());
        // populate the student object's activities list
        me.addActivity("Video Games (Legend of Zelda, Pokemon, etc.)");
        me.addActivity("Anime/Manga (One Piece, Assassination Classroom, etc.)");
        me.addActivity("Art/Drawing (Pencils, Inking, Marker Colours, etc.)");
        me.addActivity("Hanging out with friends. Especially now that the pandemic's ending.");
        // set the ListView to the activities array
        activitiesList.setItems(FXCollections.observableList(me.getActivities()));
    }
}
