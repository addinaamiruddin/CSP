package com.example.csp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminViewCourseController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private User loggedInUser=null;

    @FXML
    Label label_faculty_name, label_courseName, label_courseId, label_feeStructure, label_maxStud, label_medStudy, label_fac, label_courseDuration, label_subjTaught, label_EO, label_scholarship, label_furtherStudies;

    public void AdminViewCourseController(User loggedInUser, Course selectedCourse) {
        this.loggedInUser=loggedInUser;
        label_faculty_name.setText(loggedInUser.displayUserInformation(loggedInUser));

    }

    public void logOut(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
