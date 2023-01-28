package com.example.csp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class StudentManageCourseController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Course> tableView;
    @FXML
    private TableColumn<Course, courseLevel> MOSColumn;
    @FXML
    private TableColumn<Course, String> courseColumn;
    @FXML
    private TableColumn<Course, Integer> priceColumn;
    @FXML
    private ChoiceBox<String> coursesInput;
    @FXML
    private ChoiceBox<courseLevel> MOSinput;
    private final String[] courses = {"Computer Science","Civil Engineering","Mechanical Engineering"};
//    private final String[] MOS = {"Foundation","Degree","Diploma"};
//    private MediumStudy MOS = {MediumStudy.values()};


    private User loggedInUser;
    private int price;

    public StudentManageCourseController() {}

    public void switchToAddCourse(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("stud_add_course.fxml"));
        Parent parent = loader.load();

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(parent.getScene());
        window.show();
    }

    public void switchToUpdateCourse(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("stud_update_course.fxml"));
        Parent parent = loader.load();

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(parent.getScene());
        window.show();
    }


    //scene controller
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
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_edit_info.fxml"));
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
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_scholarship_facilities.fxml"));
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
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_info.fxml"));
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
        // USE LOGIC IN CHOICEBOX
//        List<Course> availableCourses = Course.getAllCourses();
//        List<Course> studentCourses = ((Student) loggedInUser).getCourses();
//
//        int i = 1;
//        for (Course course : availableCourses) {
//            System.out.println("(" + i + ") " + course.getCourseName());
//            i++;
//        }
//
//        boolean isRegistered = false;
//        for (Course c : studentCourses) {
//            if (c.getCourseName().equalsIgnoreCase(selectedCourse.getCourseName())) {
//                isRegistered = true;
//                break;
//            }
//        }
//
//        if (!isRegistered) {
//            ((Student) loggedInUser).addCourses(selectedCourse);
//            System.out.println("\nYou have been registered to " +
//                    selectedCourse.getCourseName());
//        } else {
//            System.out.println("\nYou are already registered for " +
//                    selectedCourse.getCourseName());
//        }
        coursesInput.getItems().addAll(courses);
        MOSinput.getItems().setAll(courseLevel.values());

        courseColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        MOSColumn.setCellValueFactory(new PropertyValueFactory<>("mediumStudy"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("feeStructure"));

    }

    // add course into tableview
    @FXML
    void confirm() {
        if (MOSinput.getValue()==courseLevel.FOUNDATION) {
            price = 10000;
        } else if (MOSinput.getValue()==courseLevel.DIPLOMA) {
            price = 20000;
        } else if (MOSinput.getValue()==courseLevel.UNDERGRADUATE) {
            price = 60000;
        } else if (MOSinput.getValue()==courseLevel.POSTGRADUATE) {
            price = 25000;
        } else if (MOSinput.getValue()==courseLevel.PHD) {
            price = 25000;
        } 
        
        Course course = new Course(coursesInput.getValue(), MOSinput.getValue(), price);
        ObservableList<Course> courses = tableView.getItems();
        courses.add(course);
        tableView.setItems(courses);
    }

    @FXML
    void removeCourse() {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

    public void courseDisplay(User loggedInUser) {
        this.loggedInUser=loggedInUser;
    }


}
