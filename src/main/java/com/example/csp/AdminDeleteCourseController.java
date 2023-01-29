package com.example.csp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
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
    private User loggedInUser;
    private Label label_faculty_name;
    private ObservableList<Course> courses;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public AdminDeleteCourseController() {    }

    public void dashboardController(User loggedInUser, ObservableList<Course> courses) {
        this.courses=courses;
        this.loggedInUser=loggedInUser;
        label_faculty_name.setText(loggedInUser.displayUserInformation(loggedInUser));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseIdColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseDurationColumn.setCellValueFactory(new PropertyValueFactory<>("courseDuration"));
        courseFeeColumn.setCellValueFactory(new PropertyValueFactory<>("feeStructure"));
        MOSColumn.setCellValueFactory(new PropertyValueFactory<>("mediumStudy"));
        facColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));

        // Add a new row to the table
        Course newRow1 = new Course("CS101", "Computer Science", new String[]{"Data Structure & Algorithm"}, 3, new String[]{"Software Engineer"}, new String[]{"AVAILABLE"}, true, 60000, 1200, com.example.csp.courseLevel.FOUNDATION, Faculty.CSE );
        ObservableList<Course> courses = tableView.getItems();

        courses.add(newRow1);
        courses.add(Course.getCourses().get(1));
//        courses.add()
        tableView.setItems(courses);
    }

    public ObservableList<Course> getOLCourses() {
        return courses;
    }

    @FXML
    void removeCourse() {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

    public void dashboardController(User loggedInUser) {
        this.courses=null;
        this.loggedInUser=loggedInUser;
        label_faculty_name.setText(loggedInUser.getUsername());
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
    public void logOut(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

}
