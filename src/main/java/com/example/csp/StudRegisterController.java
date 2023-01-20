//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.csp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudRegisterController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField input_username;
    @FXML
    private TextField input_email_address;
    @FXML
    private TextField input_phone_number;
    @FXML
    private TextField input_password;
    @FXML
    private TextField input_street;
    @FXML
    private TextField input_city;
    @FXML
    private TextField input_state;
    @FXML
    private TextField input_postalCode;
    @FXML
    private TextField input_country;
    @FXML
    private ChoiceBox<String> input_LOS;
    @FXML
    private ChoiceBox<String> input_course;
    @FXML
    private ChoiceBox<String> input_faculty;
    @FXML
    private ChoiceBox<String> input_MOD;
    private ChoiceBox<String> input_specialization;

    private String[] specialization = new String[] {"Software Engineering", "Data Science"};
    private String[] LOS = new String[]{"Foundation", "Diploma", "Bachelor's Degree", "Masters"};
    private String[] course = new String[]{"Computer Science", "Civil Engineering", "Electrical Computer Engineering", "Electrical Engineering", "Mechanical Engineering"};
    private String[] faculty = new String[]{"Faculty of Engineering", "Faculty of Computer Science"};
    private String[] MOD = new String[]{"Online", "Virtual", "Hybrid"};
    private String myMOD;
    private String myFaculty;
    private String myCourse;
    private String myLOS;
    private String mySpecialization;
    private int myDuration;
    List<Student> listOfUsers = new ArrayList();

    public StudRegisterController() {
    }

    public void OnRegisterClick(ActionEvent event) throws IOException {
        String username = this.input_username.getText();
        String emailAddress = this.input_email_address.getText();
        int phoneNumber = Integer.parseInt(this.input_phone_number.getText());
        String password = this.input_password.getText();
        AddressInfo theAddress = new AddressInfo();
        String street = this.input_street.getText();
        theAddress.setStreet(street);
        String city = this.input_city.getText();
        theAddress.setCity(city);
        String state = this.input_state.getText();
        theAddress.setState(state);
        String postalCode = this.input_postalCode.getText();
        theAddress.setPostalCode(postalCode);
        String country = this.input_country.getText();
        theAddress.setCountry(country);
        Student newStudent = new Student(username, password, emailAddress, phoneNumber, theAddress, this.myMOD, this.myFaculty, this.myLOS, this.myCourse, this.mySpecialization, this.myDuration);
        this.listOfUsers.add(newStudent);

        if (username.contains("Faculty")) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("admin_dashboard.fxml"));
            this.root = (Parent)loader.load();
            AdminDashboardController adminDashboardController = loader.getController();
            adminDashboardController(newStudent); // come back to this
//            StudDashboardController SD = new StudDashboardController(loggedInUser);

        } else {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_dashboard.fxml"));
            this.root = (Parent)loader.load();
            StudDashboardController studDashboardController = loader.getController();
            studDashboardController.studentDashboard(newStudent);
        }

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(this.root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        this.input_LOS.getItems().addAll(this.LOS);
        this.input_LOS.setOnAction(this::getLOS);
        this.input_course.getItems().addAll(this.course);
        this.input_course.setOnAction(this::getCourse);
        this.input_faculty.getItems().addAll(this.faculty);
        this.input_faculty.setOnAction(this::getFaculty);
        this.input_MOD.getItems().addAll(this.MOD);
        this.input_MOD.setOnAction(this::getMOD);
        this.input_specialization.getItems().addAll(this.specialization);
        this.input_specialization.setOnAction(this::getSpecialization);
    }

    private void getMOD(ActionEvent event) {
        String myMOD = (String)this.input_MOD.getValue();
        this.myMOD = myMOD;
    }

    private void getFaculty(ActionEvent event) {
        String myFaculty = (String)this.input_faculty.getValue();
        this.myFaculty = myFaculty;
    }

    private void getCourse(ActionEvent event) {
        String myCourse = (String)this.input_course.getValue();
        if (myCourse.equals("Computer Science")) {
            this.myDuration = 3;
        } else {
            this.myDuration = 4;
        }

        this.myCourse = myCourse;
    }

    public void getLOS(ActionEvent event) {
        String myLOS = (String)this.input_LOS.getValue();
        this.myLOS = myLOS;
    }

    public void getSpecialization(ActionEvent event) {
        String mySpecialization = (String)this.input_specialization.getValue();
        this.mySpecialization = mySpecialization;
    }

    public void back(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
