package com.example.comp1008w22st1169679assign1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Student me = new Student("Michael", "Rosanelli", 1169679);
        firstNameLabel.setText(me.getFirstName());
        lastNameLabel.setText(me.getLastName());
        studentNumberLabel.setText(Integer.toString(me.getStudentNumber()));
        imageView.setImage(me.getImage());
    }
}
