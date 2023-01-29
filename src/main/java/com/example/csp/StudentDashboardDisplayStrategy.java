package com.example.csp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// The StudentDashboardDisplayStrategy class is an implementation of the STRATEGY PATTERN.
// It provides a way for the application to handle the display of the student dashboard in a flexible and interchangeable manner.
// By implementing the strategy pattern, the application can easily switch between different display strategies (student/admin dashboard) affecting the rest of the code.
// Developers should use this class to handle the display of the student dashboard in their code and can extend or customize the functionality as needed.
public class StudentDashboardDisplayStrategy implements DashboardDisplayStrategy {

    AddressInfo theAddress = new AddressInfo();
    private static List<Student> listOfStudents = new ArrayList<Student>();
    Student loggedInUser = null;
    Scanner input = new Scanner(System.in);
    Course selectedCourse = new Course();
    private Course course = new Course();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void displayUserPortal(ActionEvent event) {
        // to display login or register for admin
        try {
            switchToStudentPortal(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToStudentPortal(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_login_register.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void displayUserLogin(ActionEvent event) {
        try {
            switchToStudentLogin(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToStudentLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("stud_login.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    // open stud_register.fxml
    public void displayUserRegister(ActionEvent event) {
        try {
            switchToStudentRegister(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToStudentRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("stud_register.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void studentDashboard(User loggedInUser) {
        loggedInUser.displayUserDashboard(loggedInUser);
    }

    //displayAcademicCredentials
    //userInformation

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

//    public void displayRegisteredCourse(User loggedInUser) {
//        if (loggedInUser instanceof Student) {
//            ((Student) loggedInUser).printRegisteredCourses(loggedInUser);
//        } else if (loggedInUser instanceof Admin) {
//            // ((Admin) loggedInUser).printAllCourse();
//        }
//    }


    // scene controller
    public void switchToFeeStructure(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_fee_structure.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToCourseInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_add_course.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StudentManageCourseController controller = loader.getController();
        controller.courseDisplay(loggedInUser);
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