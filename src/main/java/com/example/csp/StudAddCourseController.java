package com.example.csp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudAddCourseController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private TableView<Course> tableView;
    private TableColumn<Course, Integer> indexColumn;
    private TableColumn<Course, Float> feeColumn;
    private TableColumn<Course, String> courseColumn;
    private ChoiceBox<String> choiceBox_course;

    public StudAddCourseController() {}

    public void switchToCourseInfo(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("stud_add_course.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToEditCourseInfo(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_edit_course_info.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToEditStudInfo(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("edit_stud_info.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToFeeStructure(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_fee_structure.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToFuturePlanning(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_future_planning.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToScholarshipFacilities(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_stud_scholarship_facilities.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
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

    public void switchToStudentInformation(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("student_information.fxml"));
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

    // initialize values in tableview
    public void initialize(URL url, ResourceBundle resourceBundle) {
        indexColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("index"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("course"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<Course, Float>("fee"));
    }

    // add course into tableview
    void confirm(ActionEvent event) {
        Course course = new Course(choiceBox_course.getValue());
        ObservableList<Course> courses = tableView.getItems();
        courses.add(course);
        tableView.setItems(courses);
    }

    void removeCourse(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }
}
