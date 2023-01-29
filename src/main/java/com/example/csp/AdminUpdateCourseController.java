package com.example.csp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminUpdateCourseController implements Initializable {
    private User loggedInUser=null;
    @FXML
    Label label_faculty_name;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ChoiceBox<courseLevel> CB_MOS;
    @FXML
    private ChoiceBox<Faculty> CB_F;
    @FXML
    private ChoiceBox<String> CB_S;
    @FXML
    private ChoiceBox<String> CB_FS;
    @FXML
    private ChoiceBox<Course> CB_course;
    @FXML
    private TextField TF_courseID, TF_courseName, TF_feeStructure, TF_maxStud, TF_courseDuration;
    @FXML
    private TextArea TA_subjectTaught, TA_EO;

    private String[] status = {"AVAILABLE","UNAVAILABLE"};

    public void dashboardController(User loggedInUser) {
        this.loggedInUser=loggedInUser;
        label_faculty_name.setText(loggedInUser.displayUserInformation(loggedInUser));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CB_course.getItems().addAll(Course.getCourses());

        CB_FS.getItems().addAll(status);
        CB_S.getItems().addAll(status);
        CB_MOS.getItems().setAll(courseLevel.values());
        CB_F.getItems().setAll(Faculty.values());
    }

    public void update(ActionEvent event)
    {
        if (TF_courseID.getText().isEmpty())
            CB_course.getValue().setCourseId(CB_course.getValue().getCourseId());
        else
            CB_course.getValue().setCourseId(TF_courseID.getText());

        if (TF_courseName.getText().isEmpty())
            CB_course.getValue().setCourseName(CB_course.getValue().getCourseName());
        else
            CB_course.getValue().setCourseId(TF_courseName.getText());

        if (TF_feeStructure.getText().isEmpty())
            CB_course.getValue().setFeeStructure(CB_course.getValue().getFeeStructure());
        else
            CB_course.getValue().setCourseId(TF_feeStructure.getText());

        if (TF_maxStud.getText().isEmpty())
            CB_course.getValue().setMaximumStudent(CB_course.getValue().getMaximumStudent());
        else
            CB_course.getValue().setCourseId(TF_maxStud.getText());

        if (CB_MOS.equals(null))
            CB_course.getValue().setMediumStudy(CB_course.getValue().getMediumStudy());
        else
            CB_course.getValue().setMediumStudy(CB_MOS.getValue());

        if (CB_F.equals(null))
            CB_course.getValue().setFaculty(CB_F.getValue());
        else
            CB_course.getValue().setFaculty(CB_F.getValue());

        if (TF_courseDuration.getText().isEmpty())
            CB_course.getValue().setCourseDuration(CB_course.getValue().getCourseDuration());
        else
            CB_course.getValue().setCourseDuration(Integer.parseInt(TF_courseDuration.getText()));

        if (TA_subjectTaught.getText().isEmpty())
            CB_course.getValue().setSubjectTaught(CB_course.getValue().getSubjectTaught());
        else
            CB_course.getValue().setSubjectTaught(new String[]{TA_subjectTaught.getText()});

        if (TA_EO.getText().isEmpty())
            CB_course.getValue().setEmploymentOpportunities(CB_course.getValue().getEmploymentOpportunities());
        else
            CB_course.getValue().setEmploymentOpportunities(new String[]{TA_EO.getText()});

        if (CB_S.equals(null))
            CB_course.getValue().setScholarshipFacilities(Boolean.parseBoolean(CB_S.getValue()));
        else
            CB_course.getValue().setScholarshipFacilities(Boolean.parseBoolean(CB_S.getValue()));

        if (CB_FS.equals(null))
            CB_course.getValue().setScopeForFutherStudies(new String[]{CB_FS.getValue()});
        else
            CB_course.getValue().setScopeForFutherStudies(new String[]{CB_FS.getValue()});


        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("admin_view_course.fxml"));
        try {
            root = (Parent) loader.load();
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

    public AdminUpdateCourseController() {}

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
