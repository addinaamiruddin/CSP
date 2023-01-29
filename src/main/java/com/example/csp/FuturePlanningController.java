package com.example.csp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FuturePlanningController implements Initializable {
    @FXML
    private Label label_future_career, label_fs, label_fe;
    @FXML
    private ChoiceBox<String> choicebox_course;
    @FXML
    private ChoiceBox<courseLevel> choicebox_further_studies;
    String C;
    String MS;
    private final String[] courses = {"Computer Science","Civil Engineering","Mechanical Engineering", "Electrical and Computer Engineering", "Electrical Engineering"};

    public FuturePlanningController() {
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        choicebox_course.getItems().addAll(courses);
        choicebox_further_studies.getItems().setAll(courseLevel.values());
        this.choicebox_further_studies.setOnAction(this::getFutureStudies);
        this.MS= String.valueOf(this.choicebox_further_studies.getValue());
    }

    public void CB_course(ActionEvent event)
    {
        this.choicebox_course.setOnAction(this::getFutureCareer);
        this.C=this.choicebox_course.getValue();
    }

    public void CB_MOS(ActionEvent event) {
        this.choicebox_further_studies.setOnAction(this::getFutureCareer);
    }

    private void getFutureStudies(ActionEvent event) {
        String FS = switch (MS) {
            case "FOUNDATION" -> "Diploma in " + this.choicebox_course.getValue() +
                    "\nDegree in " + this.choicebox_course.getValue() +
                    "\nMasters in " + this.choicebox_course.getValue() +
                    "\nPHD in" + this.choicebox_course.getValue();
            case "DIPLOMA" -> "Degree in " + this.choicebox_course.getValue() +
                    "\nMasters in " + this.choicebox_course.getValue() +
                    "\nPHD in" + this.choicebox_course.getValue();
            case "UNDERGRADUATE" -> "Masters in " + this.choicebox_course.getValue() +
                    "\nPHD in" + this.choicebox_course.getValue();
            case "POSTGRADUATE" -> "PHD in" + this.choicebox_course.getValue();
            case "PHD" -> "VIEW FUTURE EMPLOYMENT SECTION";
            default -> "UNAVAILABLE";
        };
        this.label_fs.setText(FS);
    }


    public void getFutureCareer(ActionEvent event) {
        String FE = switch (this.choicebox_course.getValue()) {
            case "Computer Science" -> "Software Developer\n" +
                    "Data Scientist\n" +
                    "Artificial Intelligence\n" +
                    "Cybersecurity Analyst\n" +
                    "Network/Systems Administrator\n" +
                    "Web Developer/Designer\n" +
                    "Cloud Engineer\n" +
                    "Business Intelligence Analyst\n" +
                    "Game Developer\n" +
                    "Robotics Engineer";
            case "Civil Engineering" -> "Civil Engineer\n" +
                    "Project Manager\n" +
                    "Structural Engineer\n" +
                    "Construction Manager\n" +
                    "Environmental Engineer\n" +
                    "Transportation Engineer\n" +
                    "Geotechnical Engineer\n" +
                    "Coastal Engineer\n" +
                    "Materials Engineer\n" +
                    "Quality Control Engineer";
            case "Mechanical Engineering" -> "Mechanical Engineer\n" +
                    "Design Engineer\n" +
                    "Manufacturing Engineer\n" +
                    "Quality Engineer\n" +
                    "Project Engineer\n" +
                    "Product Engineer\n" +
                    "Research and Development Engineer\n" +
                    "Thermal Engineer\n" +
                    "Robotics Engineer\n" +
                    "Control Systems Engineer";
            case "Electrical and Computer Engineering" -> "Electrical Engineer\n" +
                    "Computer Engineer\n" +
                    "Control Systems Engineer\n" +
                    "Robotics Engineer\n" +
                    "Automation Engineer\n" +
                    "Power Systems Engineer\n" +
                    "Telecommunications Engineer\n" +
                    "Electronics Engineer\n" +
                    "Computer Systems Engineer\n" +
                    "Network Engineer";
            case "Electrical Engineering" -> "Electrical Engineer\n" +
                    "Power Systems Engineer\n" +
                    "Control Systems Engineer\n" +
                    "Automation Engineer\n" +
                    "Renewable Energy Engineer\n" +
                    "Robotics Engineer\n" +
                    "Internet of Things (IoT) Engineer\n" +
                    "Digital Signal Processing Engineer\n" +
                    "Communications Engineer\n" +
                    "Electrical Project Manager";
            default -> "UNAVAILABLE";
        };
        this.label_fe.setText(FE);
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToCourseInfo(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("stud_add_course.fxml"));
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

    public void futurePlanningDisplay(User loggedInUser) {
    }


}
