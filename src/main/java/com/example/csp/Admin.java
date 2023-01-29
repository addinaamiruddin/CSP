package com.example.csp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Admin is the subclass of user (INHERITANCE).
// It contains specific functionality and privileges related to managing the system.
public final class Admin extends User {
    private String adminId;
    private static Admin instance;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static List<Admin> listOfAdmins = new ArrayList<Admin>();

    // set it to private to ensure that only one instance of the Admin class is
    // created.
    private Admin(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
    }

    // SINGLETON PATTERN is used to ensure that there is only one admin object
    // being manipulated throughout the application, and to prevent multiple
    // instances of the admin object from being created.
    public static Admin getInstance(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo) {
        if (instance == null) {
            instance = new Admin(username, password, emailAddress, phoneNumber, addressInfo);
        }
        return instance;
    }

    public String getAdminId() {
        return adminId;
    }

    @Override
    void displayUserDashboard(User loggedInUser) {

        AdminDashboardDisplayStrategy adminDashboard = new AdminDashboardDisplayStrategy();

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("admin_dashboard.fxml"));
        try {
            this.root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        AdminDashboardController ADC = loader.getController();
//        ADC.dashboardController(loggedInUser);
    }

    @Override
    public String displayUserInformation(User loggedInUser) {
        AdminDashboardDisplayStrategy adminStrategy = new AdminDashboardDisplayStrategy();
        return getUsername();
    }

}



