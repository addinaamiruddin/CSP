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

public class AdminLoginController {
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

        for (Admin admin : Admin.listOfAdmins) {
            System.out.println("helloUsername: " + admin.getUsername() + ", Password: " + admin.getPassword());
        }

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("admin_dashboard.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        // check if admin is exist
//        for (User user : listOfAdmins) {
//            if (user.getUsername().equals(inpUser)) {
//                if (user.getPassword().equals(inpPass)) {
//                    loggedInUser = user;
//                    AdminDashboardDisplayStrategy ADDS = loader.getController();
//                    ADDS.adminDashboard(loggedInUser);
//                }
//            } else {
//                labelWarning.setText("Invalid username/password combination");
//            }
//        }
//
//        if (loggedInUser == null) {
//            labelWarning.setText("Invalid username/password combination");
//        }
        AddressInfo sampleAddress = new AddressInfo("Street", "City", "State", "25300", "Country");

//        if (authenticate(inpUser, inpPass)) {
//            Admin loggedInUser = Admin.getInstance("admin", "testing", "emailAddress", 123, sampleAddress);
//            AdminDashboardController ADC = loader.getController();
//            ADC.dashboardController(loggedInUser);
//        } else {
//            labelWarning.setText("Invalid username or password");
//        }
//
//        if (loggedInUser == null) {
//            labelWarning.setText("Invalid username/password combination");
//        }
        Admin loggedInUser = Admin.getInstance("admin", "testing", "emailAddress", 123, sampleAddress);
        AdminDashboard_Controller ADC = loader.getController();
        ADC.dashboardController(loggedInUser);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    private boolean authenticate(String username, String password) {
        // Placeholder for actual authentication logic
        return "admin".equals(username) && "testing".equals(password);
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
            root = FXMLLoader.load(this.getClass().getResource("admin_register.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();

    }

}
