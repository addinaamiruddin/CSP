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

public class StudentDashboardController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label label_welcome, label_id, label_username, label_phoneNum, label_address, label_email;
    private User loggedInUser;

    public void dashboardController(User loggedInUser) {
        this.loggedInUser = loggedInUser;

        label_welcome.setText("Hello, "+loggedInUser.displayUserInformation(loggedInUser)+"!");

        // at student info square
        label_id.setText(":  "+((Student)loggedInUser).getStudentId());
        label_username.setText(":  "+loggedInUser.getUsername());
        label_phoneNum.setText(":  "+loggedInUser.getPhoneNumber());
        label_address.setText(":  "+loggedInUser.getAddressInfo());
        label_email.setText(":  "+loggedInUser.getEmailAddress());
    }

    public void clickStudInfo(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_info.fxml"));
        try {
            this.root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StudInfoController SIC = loader.getController();
        SIC.studInfoController(loggedInUser);
    }

    public void clickAddCourseBtn(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_add_course.fxml"));
        try {
            this.root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StudentDashboardDisplayStrategy SDD = loader.getController();
        SDD.manageCourse(loggedInUser);
    }

    public void clickRemoveCourseBtn(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_add_course.fxml"));
        try {
            this.root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StudentDashboardDisplayStrategy SDD = loader.getController();
        SDD.manageCourse(loggedInUser);
    }

    public void clickViewCourseBtn(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_add_course.fxml"));
        try {
            this.root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StudentDashboardDisplayStrategy SDD = loader.getController();
        SDD.manageCourse(loggedInUser);
    }

    // scene controller
    public void switchToFeeStructure(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("stud_fee_structure.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
    public void switchToCourseInfo(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_add_course.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
    public void logout(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
