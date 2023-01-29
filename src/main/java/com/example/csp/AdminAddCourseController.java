package com.example.csp;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

// use for admin_add_course.fxml
public class AdminAddCourseController implements Initializable {
    @FXML
    Label label_faculty_name;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private SceneController SC;
    private TableView<Course> tableView;
    private TableColumn<Course, String> courseIdColumn;
    private TableColumn<Course, String> courseNameColumn;
    private TableColumn<Course, String[]> subjectTaughtColumn;
    private TableColumn<Course, Integer> courseDurationColumn;
    private TableColumn<Course, String[]> employmentOpportunitiesColumn;
    private TableColumn<Course, String[]> scopeForFurtherStudiesColumn;
    private TableColumn<Course, Boolean> scholarshipFacilitiesColumn;
    private TableColumn<Course, Integer> feeStructureColumn;
    private TableColumn<Course, Integer> maximumStudentColumn;
    private TableColumn<Course, MediumStudy> mediumStudyColumn;
    private TableColumn<Course, Faculty> facultyColumn;
    @FXML
    private TextField courseIdInput, courseNameInput, subjectTaughtInput, courseDurationInput, employmentOpportunitiesInput, scopeInput, feeStructureInput, maxStudInput;
    @FXML
    private ChoiceBox<courseLevel> MOSinput;
    @FXML
    private ChoiceBox<Faculty> facInput;
    @FXML
    private ChoiceBox<String> scholarshipFacInput, mediumStudyInput;

    private String[] status = {"AVAILABLE","UNAVAILABLE"};
    private User loggedInUser=null;

    public static String[] getMOS(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    public AdminAddCourseController() {
    }

    public void dashboardController(User loggedInUser) {
        this.loggedInUser=loggedInUser;
        label_faculty_name.setText(loggedInUser.displayUserInformation(loggedInUser));
    }

    // in view_course
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scholarshipFacInput.getItems().addAll(status);
        MOSinput.getItems().setAll(courseLevel.values());
        facInput.getItems().setAll(Faculty.values());
    }

    // in add_course
    @FXML
    void submit(ActionEvent event) {
        Course newCourse = new Course(courseIdInput.getText(),
                courseNameInput.getText(),
                new String[]{subjectTaughtInput.getText()},
                Integer.parseInt(courseDurationInput.getText()),
                new String[]{employmentOpportunitiesInput.getText()},
                new String[]{scopeInput.getText()},
                Boolean.parseBoolean(scholarshipFacInput.getValue()),
                Integer.parseInt(feeStructureInput.getText()),
                Integer.parseInt(maxStudInput.getText()), MOSinput.getValue(), facInput.getValue());

        ObservableList<Course> courses = null;
        Course.addCourse(newCourse);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("admin_delete_course.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AdminDeleteCourseController controller = loader.getController();
        controller.dashboardController(loggedInUser, courses);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    // in delete_course
    void removeCourse(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

    public void displayName(User loggedInUser) {
        this.label_faculty_name.setText(loggedInUser.getUsername());
    }

    public void logOut(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
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
        AdminDeleteCourseController controller = loader.getController();
        controller.dashboardController(loggedInUser);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToDashboard(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("admin_dashboard.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
