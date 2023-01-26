package com.example.csp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class StudInfoController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label label_studID, label_username, label_phoneNumber, label_emailAddress, label_address;
    @FXML
    private TextField TF_username, TF_phoneNumber, TF_emailAddress, TF_street, TF_city, TF_state, TF_postalCode, TF_country;
    private User loggedInUser;
    @FXML
    private Button save_edit, save_button, edit_button;

    public void studInfoController(User loggedInUser) {
        this.loggedInUser=loggedInUser;

        label_studID.setText(String.valueOf(((Student)loggedInUser).getStudentId()));
        label_username.setText(loggedInUser.getUsername());
        label_phoneNumber.setText(String.valueOf(loggedInUser.getPhoneNumber()));
        label_emailAddress.setText(loggedInUser.getEmailAddress());
        label_emailAddress.setText(String.valueOf(loggedInUser.getAddressInfo()));
    }

    public void studInfoEditController(User loggedInUser) {
        this.loggedInUser=loggedInUser;

        label_studID.setText(String.valueOf(((Student)loggedInUser).getStudentId()));

        loggedInUser.setUsername(TF_username.getText());
        loggedInUser.setPhoneNumber(Integer.parseInt(TF_phoneNumber.getText()));
        loggedInUser.setEmailAddress(TF_emailAddress.getText());

        AddressInfo addressInfo = new AddressInfo(TF_street.getText(), TF_city.getText(), TF_state.getText(), TF_postalCode.getText(), TF_country.getText());

        loggedInUser.setAddressInfo(addressInfo);
    }

    public void saveBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("stud_info.fxml"));
        Parent parent = loader.load();

        //access the controller and call a method
        StudInfoController controller = loader.getController();
        controller.studInfoController(loggedInUser);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(parent.getScene());
        window.show();
    }

    public void editBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("stud_edit_info.fxml"));
        Parent parent = loader.load();

        //access the controller and call a method
        StudInfoController controller = loader.getController();
        controller.studInfoEditController(loggedInUser);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(parent.getScene());
        window.show();
    }

    //scene controller
    public void switchToCourseInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("course_info.fxml"));
        Parent parent = loader.load();

        //access the controller and call a method
        StudentManageCourseController controller = loader.getController();
        controller.courseDisplay(loggedInUser);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(parent.getScene());
        window.show();
    }

//    public void switchToEditStudInfo(ActionEvent event) throws IOException {
//        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("edit_stud_info.fxml"));
//        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        this.scene = new Scene(root);
//        this.stage.setScene(this.scene);
//        this.stage.show();
//    }

    public void switchToFuturePlanning(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("future_planning.fxml"));
        Parent parent = loader.load();

        //access the controller and call a method
        FuturePlanningController controller = loader.getController();
        controller.futurePlanningDisplay(loggedInUser);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(parent.getScene());
        window.show();
    }

    public void switchToScholarshipFacilities(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("scholarship_facilities.fxml"));
        Parent parent = loader.load();

        //access the controller and call a method
        ScholarshipFacilitiesController controller = loader.getController();
        controller.scholarshipDisplay(loggedInUser);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(parent.getScene());
        window.show();
    }

    public void switchToStudentDashboard(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("stud_dashboard.fxml"));
        Parent parent = loader.load();

        //access the controller and call a method
        StudentDashboardController controller = loader.getController();
        controller.dashboardController(loggedInUser);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(parent.getScene());
        window.show();
    }

    public void switchToStudentInformation(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("stud_info.fxml"));
        Parent parent = loader.load();

        //access the controller and call a method
        StudInfoController controller = loader.getController();
        controller.studInfoController(loggedInUser);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(parent.getScene());
        window.show();

    }

    public void logout(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }


}
