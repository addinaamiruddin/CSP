package com.example.csp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDeleteCourseController implements Initializable {

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

    public AdminDeleteCourseController() {    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseIdColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseDurationColumn.setCellValueFactory(new PropertyValueFactory<>("courseDuration"));
        courseFeeColumn.setCellValueFactory(new PropertyValueFactory<>("feeStructure"));
        MOSColumn.setCellValueFactory(new PropertyValueFactory<>("mediumStudy"));
        facColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
    }

    @FXML
    void removeCourse() {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }
}
