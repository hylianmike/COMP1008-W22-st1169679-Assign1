package com.example.comp1008w22st1169679assign1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Student me = new Student("Michael", "Rosanelli", 1169679);
        firstNameLabel.setText(me.getFirstName());
        lastNameLabel.setText(me.getLastName());
        studentNumberLabel.setText(Integer.toString(me.getStudentNumber()));
        imageView.setImage(me.getImage());
        me.addActivity("Video Games (Legend of Zelda, Pokemon, etc.)");
        me.addActivity("Anime/Manga (One Piece, Assassination Classroom, etc.)");
        activitiesList.setItems(FXCollections.observableList(me.getActivities()));
    }
}
