package com.example.csp;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField input_username;
    @FXML
    private TextField input_password;
    private Stage stage;
    private Scene scene;
    private Parent root;
    User loggedInUser = null;
    List<User> listOfUsers = new ArrayList<>();
    private Label labelWarning;
    public LoginController() {
    }

    public void onLoginClick(ActionEvent event) throws IOException {
        String inpUser = this.input_username.getText();
        String inpPass = this.input_password.getText();

        // check if student is exist
        for (Student user : listOfStudents) {
            if (user.getUsername().equals(inpUser)) {
                if (user.getPassword().equals(inpPass)) {
                    loggedInUser = user;
                    studentDashboard(loggedInUser);
                    break;
                }
            } else {
                System.out.println("Invalid username/password combination\n");
                break;
            }
        }

        if (loggedInUser == null) {
            labelWarning.setText("Invalid username/password combination");
        }

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_dashboard.fxml"));
        this.root = (Parent)loader.load();
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }


    public void onRegisterClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_register.fxml"));
        this.root = (Parent)loader.load();
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToRegister(ActionEvent event) throws IOException {
        this.root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_register.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToStudentDashboard(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_dashboard.fxml"));
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
