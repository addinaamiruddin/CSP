package com.example.csp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

// use for admin_delete_course.fxml
// use for admin_view_course.fxml
public class AdminManageCourseController implements Initializable {
    @FXML
    Label label_faculty_name, label_courseName, label_courseId, label_feeStructure, label_maxStud, label_medStudy, label_fac, label_courseDuration, label_subjTaught, label_EO, label_scholarship, label_furtherStudies;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private SceneController SC;
    @FXML
    private TableView<Course> tableView;
    @FXML
    private TableColumn<Course, String> courseIdColumn;
    @FXML
    private TableColumn<Course, String> courseNameColumn;
    private TableColumn<Course, String[]> subjectTaughtColumn;
    @FXML
    private TableColumn<Course, Integer> courseDurationColumn;
    private TableColumn<Course, String[]> employmentOpportunitiesColumn;
    private TableColumn<Course, String[]> scopeForFurtherStudiesColumn;
    private TableColumn<Course, Boolean> scholarshipFacilitiesColumn;
    @FXML
    private TableColumn<Course, Integer> feeStructureColumn;
    @FXML
    private TableColumn<Course, Integer> maximumStudentColumn;
    @FXML
    private TableColumn<Course, MediumStudy> mediumStudyColumn;
    @FXML
    private TableColumn<Course, Faculty> facultyColumn;
    @FXML
    private TextField courseIdInput, courseNameInput, subjectTaughtInput, courseDurationInput, employmentOpportunitiesInput, scopeInput, feeStructureInput, maxStudInput, facInput;

    @FXML
    private ChoiceBox<String> scholarshipFacInput, mediumStudyInput;
    private static List<Course> courses = Course.getAllCourses();
    private String[] status = {"AVAILABLE","UNAVAILABLE"};
    private User loggedInUser=null;

    public AdminManageCourseController() {
    }

    public void dashboardController(User loggedInUser) {
        this.loggedInUser=loggedInUser;
        label_faculty_name.setText(loggedInUser.displayUserInformation(loggedInUser));
    }

    // in view_course
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseIdColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("courseId"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        courseDurationColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("courseDuration"));
        feeStructureColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("feeStructure"));
        maximumStudentColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("maximumStudent"));
        mediumStudyColumn.setCellValueFactory(new PropertyValueFactory<Course, MediumStudy>("mediumStudy"));
        facultyColumn.setCellValueFactory(new PropertyValueFactory<Course, Faculty>("faculty"));
    }

    // in delete_course
    void removeCourse(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

    public void displayName(String username) {
        this.label_faculty_name.setText(username);
    }

    public void logOut(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToAddCourse(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("admin_add_course.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToDeleteCourse(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("admin_view_course.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToUpdateCourse(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("admin_update_course.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToViewCourse(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("admin_delete_course.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToDashboard(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("admin_dashboard.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
