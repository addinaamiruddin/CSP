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
    @FXML
    private ChoiceBox<courseLevel> MOSinput;
    @FXML
    private ChoiceBox<Faculty> CB_facInput;
    @FXML
    private TableView<Course> tableView;
    @FXML
    private TableColumn<Course, String> courseIdColumn;
    @FXML
    private TableColumn<Course, String> courseNameColumn;
    @FXML
    private TableColumn<Course, Integer> courseDurationColumn;
    @FXML
    private TableColumn<Course, Integer> courseFeeColumn;
    @FXML
    private TableColumn<Course, MediumStudy> MOSColumn;
    @FXML
    private TableColumn<Course, Faculty> facColumn;
    private User loggedInUser;
    private ObservableList<Course> courses;
    @FXML
    private TextField courseIdInput, courseNameInput, subjectTaughtInput, courseDurationInput, employmentOpportunitiesInput, scopeInput, feeStructureInput, maxStudInput, facInput;

    @FXML
    private ChoiceBox<String> scholarshipFacInput, mediumStudyInput;
//    private static List<Course> courses = Course.getAllCourses();
    private String[] status = {"AVAILABLE","UNAVAILABLE"};

    public AdminManageCourseController() {
    }

    public void dashboardController(User loggedInUser) {
        this.loggedInUser=loggedInUser;
        label_faculty_name.setText(loggedInUser.displayUserInformation(loggedInUser));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // for admin_add_course.fxml
        scholarshipFacInput.getItems().addAll(status);
        MOSinput.getItems().setAll(courseLevel.values());
        CB_facInput.getItems().setAll(Faculty.values());

        // for admin_delete_course.fxml
//        courseIdColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
//        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
//        courseDurationColumn.setCellValueFactory(new PropertyValueFactory<>("courseDuration"));
//        courseFeeColumn.setCellValueFactory(new PropertyValueFactory<>("feeStructure"));
//        MOSColumn.setCellValueFactory(new PropertyValueFactory<>("mediumStudy"));
//        facColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
//
//        Course newRow1 = new Course("CS101", "Computer Science", new String[]{"Data Structure & Algorithm"}, 3, new String[]{"Software Engineer"}, new String[]{"AVAILABLE"}, true, 60000, 1200, com.example.csp.courseLevel.FOUNDATION, Faculty.CSE );
//
//        this.courses.add(newRow1);
//        tableView.setItems(this.courses);
    }

    // for add_course.fxml
    @FXML
    void submit(ActionEvent event) {
        Course newCourse = new Course(courseIdInput.getText(),
                courseNameInput.getText(),
                new String[]{subjectTaughtInput.getText()},
                Integer.parseInt(courseDurationInput.getText()),
                new String[]{employmentOpportunitiesInput.getText()},
                new String[]{scopeInput.getText()},
                Boolean.parseBoolean(scholarshipFacInput.getValue()),
                Integer.parseInt(feeStructureInput.getText()),
                Integer.parseInt(maxStudInput.getText()), MOSinput.getValue(), CB_facInput.getValue());

        ObservableList<Course> courses = null;
//        courses.add(newCourse);
        Course.addCourse(newCourse);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("admin_delete_course.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AdminManageCourseController controller = loader.getController();
        controller.dashboardController(loggedInUser);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    // for delete_course.fxml
    @FXML
    void removeCourse(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

    // scene controllers
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
        AdminUpdateCourseController controller = loader.getController();
        controller.dashboardController(loggedInUser);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
