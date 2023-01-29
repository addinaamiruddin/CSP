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
    private Course selectedCourse=null;

    @FXML
    Label label_faculty_name, label_courseName, label_courseId, label_feeStructure, label_maxStud, label_medStudy, label_fac, label_courseDuration, label_subjTaught, label_EO, label_scholarship, label_furtherStudies;

    public void dashboardController(User loggedInUser, Course selectedCourse) {
        this.selectedCourse=selectedCourse;
        this.loggedInUser=loggedInUser;
        label_faculty_name.setText(loggedInUser.displayUserInformation(loggedInUser));
    }

    public void dashboardController(User loggedInUser) {
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

    public void switchToAddCourse(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("admin_add_course.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AdminAddCourseController controller = loader.getController();
        controller.dashboardController(loggedInUser);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToDeleteCourse(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("admin_delete_course.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AdminDeleteCourseController controller = loader.getController();
        controller.dashboardController(loggedInUser);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToViewCourse(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("admin_view_course.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AdminViewCourseController controller = loader.getController();
        controller.dashboardController(loggedInUser);

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToUpdateCourse(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("admin_update_course.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AdminDeleteCourseController controller = loader.getController();
        controller.dashboardController(loggedInUser);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }


}
