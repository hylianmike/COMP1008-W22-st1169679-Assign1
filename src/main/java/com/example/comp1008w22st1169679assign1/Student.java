package com.example.comp1008w22st1169679assign1;

import javafx.scene.image.Image;

public class Student {

    private String firstName;
    private String lastName;
    private int studentNumber;
    private Image image;

    /**
     * constructor for a student object
     * @param firstName first name of the student
     * @param lastName last name of the student
     * @param studentNumber the student number
     */

    public Student(String firstName, String lastName, int studentNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        String file = String.format("img/%s-%s.png", firstName.toLowerCase(), lastName.toLowerCase());
        image = new Image(getClass().getResource(file).toExternalForm());
    }

    /**
     * @return the first name parameter of the object
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * Validates to see if the parameter actually has content in it
     */

    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        if (!firstName.equals(""))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("You need to actually input a name");

    }

    /**
     * @return the last name parameter of the object
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * Validates to see if the parameter actually has content in it
     */

    public void setLastName(String lastName) {
        lastName = lastName.trim();
        if (!lastName.equals(""))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("You need to actually input a name");
    }

    /**
     * @return the student number parameter of the object
     */

    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * Validates to make sure the number has 7 digits
     */

    public void setStudentNumber(int studentNumber) {
        if (studentNumber >= 1000000 && studentNumber <= 9999999)
            this.studentNumber = studentNumber;
        else
            throw new IllegalArgumentException("Input a 7 digit number");
    }

    /**
     * @return the image parameter of the object
     */

    public Image getImage() {
        return image;
    }

    /**
     * @return a string version of the object "'first name' 'last name': #'student number'
     */

    @Override
    public String toString(){
        return (firstName + " " + lastName + ": #" + studentNumber);
    }
}