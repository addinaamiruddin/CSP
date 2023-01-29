package com.example.csp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.csp.StudRegisterController.listOfStudents;

public class StudLoginController {
    @FXML
    private TextField input_username;
    @FXML
    private TextField input_password;
    User loggedInUser = null;

    @FXML
    private Label labelWarning;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void onLoginClick (ActionEvent event) {
        String inpUser = this.input_username.getText();
        String inpPass = this.input_password.getText();

        for (Student student : Student.listOfStudents) {
            System.out.println("helloUsername: " + student.getUsername() + ", Password: " + student.getPassword());
        }



        // check if student is exist
//        for (Student student : Student.listOfStudents) {
//            if (student.getUsername().equals(inpUser)) {
//                if (student.getPassword().equals(inpPass)) {
//                    loggedInUser = student;
//                    StudentDashboardController SDC = loader.getController();
//                    SDC.dashboardController(loggedInUser);
//                    System.out.println("TTUsername: " + student.getUsername() + ", Password: " + student.getPassword());
//                }
//            } else {
//                labelWarning.setText("Invalid username/password combination");
//            }
//        }
        AddressInfo sampleAddress = new AddressInfo("Street", "City", "State", "25300", "Country");

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_dashboard.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (authenticate(inpUser, inpPass)) {
            Student loggedInUser = Student.getInstance("John Doe", "testing", "emailAddress@gmail.com", 123, sampleAddress);
            StudentDashboardController SDC = loader.getController();
            SDC.dashboardController(loggedInUser);
        } else {
            labelWarning.setText("Invalid username or password");
        }

        if (loggedInUser == null) {
            labelWarning.setText("Invalid username/password combination");
        }

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();

    }

    private boolean authenticate(String username, String password) {
        // Placeholder for actual authentication logic
        return "student".equals(username) && "testing".equals(password);
    }

    //scene controller
    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
    public void displayUserRegister(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(this.getClass().getResource("stud_register.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

}
