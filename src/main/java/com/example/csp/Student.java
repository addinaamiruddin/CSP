//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.csp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum MediumStudy {
    FOUNDATION,
    DIPLOMA,
    UNDERGRADUATE,
    POSTGRADUATE,
    PHD;
}

// Student is the subclass of user (INHERITANCE).
// It contains specific properties and methods and ability to add and remove
// courses from their program of study.
public final class Student extends User {
    private int studentId;
    private MediumStudy mediumStudy;
    private String faculty;
    private List<Course> courses;
    private static Student instance; // create instance of student
    private Label label_studInfo;
    private Stage stage;
    private Scene scene;
    private Parent root;


    // set it to private to ensure that only one instance of the Student class is
    // created.
    private Student(String username, String password, String emailAddress, int phoneNumber, AddressInfo addressInfo, MediumStudy mediumStudy, String faculty) {
        super(username, password, emailAddress, phoneNumber, addressInfo);
        Random rand = new Random();
        this.studentId = rand.nextInt((1000000000 - 100000000) + 1) + 100000000;
        this.mediumStudy = mediumStudy;
        this.faculty = faculty;
        this.courses = new ArrayList<>();
    }

    // SINGLETON PATTERN is used to ensure that there is only one student object
    // being manipulated throughout the application, and to prevent multiple
    // instances of the student object from being created.
    public static Student getInstance(String username, String password, String emailAddress, int phoneNumber, AddressInfo theAddress, MediumStudy mediumStudy, String major) {
        if (instance == null) {
            instance = new Student(username, password, emailAddress, phoneNumber, theAddress, mediumStudy, major);
        }
        return instance;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        Random rand = new Random();
        studentId = rand.nextInt((1000000000 - 100000000) + 1) + 100000000;
        this.studentId = studentId;
    }

    public MediumStudy getMediumStudy() {
        return mediumStudy;
    }

    public void setMediumStudy(MediumStudy mediumStudy) {
        this.mediumStudy = mediumStudy;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    // printRegisteredCourses(User)

    // call stud_dashboard.fxml
    @Override
    void displayUserDashboard(User loggedInUser) {

        StudentDashboardDisplayStrategy studDashboard = new StudentDashboardDisplayStrategy();

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_dashboard.fxml"));
        try {
            this.root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StudentDashboardController SDC = loader.getController();
        SDC.dashboardController(loggedInUser);
    }

    @Override
    public String displayUserInformation(User loggedInUser) {
        StudentDashboardDisplayStrategy studentStrategy = new StudentDashboardDisplayStrategy();
        return getUsername();
    }
}

