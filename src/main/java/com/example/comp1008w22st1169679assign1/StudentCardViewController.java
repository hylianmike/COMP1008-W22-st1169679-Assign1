package com.example.comp1008w22st1169679assign1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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

    private Student user;

    // flag to know when to create a new student object
    private static boolean flag = true;

    /**
     * method that sets the student object to the parameter
     * @param student
     */
    public void setStudent(Student student) { this.user = student; }

    /**
     * method that is used from the add activities controller to add it to the object
     * @param data = string to be added to the activities List
     */
    public void initData(String data){
        user.addActivity(data);
    }

    /**
     * When this method is called, it will change the scene
     */
    public void changeScene(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("add-activities-view.fxml"));
        Parent view = loader.load();
        Scene scene = new Scene(view);

        AddActivitiesViewController controller = loader.getController();
        controller.setStudent(user);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    /**
     *  overridden initialize method to run all the code in the controller
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // if the flag is on, create the new Student object and populate the activities list with 4 default values
        if (flag) {
            // instantiate a new student object with my information
            user = new Student("Michael", "Rosanelli", 1169679);
            // populate the student object's activities list
            user.addActivity("Video Games (Legend of Zelda, Pokemon, etc.)");
            user.addActivity("Anime/Manga (One Piece, Assassination Classroom, etc.)");
            user.addActivity("Art/Drawing (Pencils, Inking, Marker Colours, etc.)");
            user.addActivity("Hanging out with friends. Especially now that the pandemic's ending.");
            // set flag to false, so it never goes in this block again
            flag = false;
        }
        // otherwise, set it to the student variable from the activities view controller
        else
            user = AddActivitiesViewController.getStudent();

        // set the text of the labels based on the objects "get" methods
        firstNameLabel.setText(user.getFirstName());
        lastNameLabel.setText(user.getLastName());
        studentNumberLabel.setText(Integer.toString(user.getStudentNumber()));
        // set the image view based on the student object's "getImage()" method
        imageView.setImage(user.getImage());
        // set the ListView to the activities array
        activitiesList.setItems(FXCollections.observableList(user.getActivities()));

    }
}
