package com.example.csp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// The AdminDashboardDisplayStrategy class is an implementation of the STRATEGY PATTERN and POLYMORPHISM.
// It provides a way for the application to handle the display of the admin dashboard in a flexible and interchangeable manner.
// By implementing the strategy pattern, the application can easily switch between different display strategies (student/admin dashboard) without affecting the rest of the code.
// Developers should use this class to handle the display of the admin dashboard in their code and can extend or customize the functionality as needed.
public class AdminDashboardDisplayStrategy implements DashboardDisplayStrategy {

    AddressInfo theAddress = new AddressInfo();
    private static List<Admin> ListOfAdmins = new ArrayList<Admin>();
    Admin loggedInUser = null;
    Course selectedCourse = new Course();
    private Course course = new Course();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void displayUserPortal() {
        // to display login or register for admin

        SceneController SC = new SceneController();
        try {
            SC.switchToAdminPortal(new ActionEvent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void displayUserLogin() {
        SceneController SC = new SceneController();
        try {
            SC.switchToAdminLogin(new ActionEvent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void displayUserRegister() {
        SceneController SC = new SceneController();
        try {
            SC.switchToAdminRegister(new ActionEvent());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void adminDashboard(User loggedInUser) {
        loggedInUser.displayUserDashboard(loggedInUser);
    }

    //adminInformation

    public void addCourse(User loggedInUser) {
        course.handleAddCourse(loggedInUser);
    }

    public void updateCourse(User loggedInUser) {
        course.handleUpdateCourse(loggedInUser);
    }

    public void removeCourse(User loggedInUser) {
        course.handleRemoveCourse(loggedInUser);
    }

    public void manageCourse(User loggedInUser) {
        course.handleCourseActions(loggedInUser);
    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
