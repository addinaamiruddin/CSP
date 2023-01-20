//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.csp;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StudDashboardController {
    @FXML
    Label labelName;
    @FXML
    Label labelID;
    @FXML
    Label labelPhoneNum;
    @FXML
    Label labelHomeAddress;
    @FXML
    Label label_course;
    @FXML
    Label label_specialization;
    @FXML
    Label label_duration;
    @FXML
    Label label_MOS;
    @FXML
    Label label_faculty;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private User loggedInUser;


    public StudDashboardController(User loggedInUser) {
        this.loggedInUser = loggedInUser;
        this.labelName.setText("Hello, " + loggedInUser.getUsername() + "!");
    }

    public void studentDashboard(User loggedInUser) {
        this.labelName.setText(":  " + loggedInUser.getUsername());
        this.labelPhoneNum.setText(":  " + loggedInUser.getPhoneNumber());
        this.labelHomeAddress.setText(":  " + loggedInUser.getAddressInfo());
        Label var10000 = this.label_course;

        if (loggedInUser instanceof Student)
        {
            String var10001 =  ((Student)loggedInUser).getLOS();
            var10000.setText(":  " + var10001 + " of " + ((Student)loggedInUser).getCourse());
            this.label_specialization.setText(":  " + ((Student)loggedInUser).getSpecialization());
            this.label_MOS.setText(":  " + ((Student)loggedInUser).getMediumStudy());
            this.label_duration.setText(":  " + ((Student)loggedInUser).getDuration() + " Years");
        } else if (loggedInUser instanceof Admin)
        {
            // loggedInUser as Admin
        }

    }

    public void switchToFeeStructure(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_fee_structure.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToCourseInfo(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_course_info.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void logOut(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
