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
        label_emailAddress.setText(String.valueOf(loggedInUser.getSampleAddress()));
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

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_info.fxml"));
        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StudInfoController controller = loader.getController();
        controller.studInfoController(loggedInUser);

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void editBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_edit_info.fxml"));
        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StudInfoController controller = loader.getController();
        controller.studInfoEditController(loggedInUser);

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    //scene controller
    public void switchToCourseInfo(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_add_course.fxml"));
        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StudentManageCourseController controller = loader.getController();
        controller.courseDisplay(loggedInUser);

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToFuturePlanning(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_future_planning.fxml"));
        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FuturePlanningController controller = loader.getController();
        controller.futurePlanningDisplay(loggedInUser);

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToScholarshipFacilities(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_scholarship_facilities.fxml"));
        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ScholarshipFacilitiesController controller = loader.getController();
        controller.scholarshipDisplay(loggedInUser);

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToStudentDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_dashboard.fxml"));
        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StudentDashboardController controller = loader.getController();
        controller.dashboardController(loggedInUser);

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToStudentInformation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_info.fxml"));
        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StudInfoController controller = loader.getController();
        controller.studInfoController(loggedInUser);

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


}
