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
    static List<Student> listOfStudents = new ArrayList<Student>();


    private User loggedInUser;

    public StudRegisterController() {
    }

    public void OnRegisterClick(ActionEvent event) throws IOException {

        //personal
        String username = this.input_username.getText();
        String password = this.input_password.getText();
        String emailAddress = this.input_email_address.getText();
        int phoneNumber = Integer.parseInt(this.input_phone_number.getText());

        //address
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

        theAddress = new AddressInfo(street, city, state, postalCode, country);
        MediumStudy medium = MediumStudy.valueOf("UNDERGRADUATE");

        Student registeredStudent = Student.getInstance(username, password,
                emailAddress, phoneNumber, theAddress, medium,
                "Computer Science");

        listOfStudents.add(registeredStudent);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_dashboard.fxml"));
        this.root = loader.load();
        StudentDashboardDisplayStrategy SDD = loader.getController();
        SDD.studentDashboard(registeredStudent);
    }

    private void adminDashboardController(Student newStudent) {
    }

    public void back(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("stud_login.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
