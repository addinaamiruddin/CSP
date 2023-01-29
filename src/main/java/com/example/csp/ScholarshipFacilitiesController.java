//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.csp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ScholarshipFacilitiesController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Scholarship> table;
    @FXML
    private TableColumn<Scholarship, String> nameColumn;
    @FXML
    private TableColumn<Scholarship, String> statusColumn;
    @FXML
    private TableColumn<Scholarship, String> typesColumn;
    @FXML
    private TableColumn<Scholarship, String> levelColumn;
    ObservableList<Scholarship> sch = FXCollections.observableArrayList();
    private User loggedInUser;

    public ScholarshipFacilitiesController() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        // Set the columns of the TableView
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typesColumn.setCellValueFactory(new PropertyValueFactory<>("types"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));

        // Add a new row to the table
        Scholarship newRow1 = new Scholarship("Closed", "MMU President's Scholarship", "Scholarship", "Undergraduate");
        sch.add(newRow1);
        Scholarship newRow2 = new Scholarship("Closed","MMU Merit Scholarship","Scholarship","Undergraduate");
        sch.add(newRow2);
        Scholarship newRow3 = new Scholarship("Closed","MMU Talent Scholarship","Discount","Postgraduate");
        sch.add(newRow3);
        Scholarship newRow4 = new Scholarship("Closed","PROGRAM IJAZAH DALAM NEGARA (PIDN) 2022", "Loan","Undergraduate");
        sch.add(newRow4);

        table.setItems(sch);
    }

    //scene controller
    public void switchToAddCourse(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("stud_add_course.fxml"));
        Parent parent = loader.load();

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(parent.getScene());
        window.show();
    }

    public void switchToCourseInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_add_course.fxml"));
        try {
            root = loader.load();
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
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_scholarship_facilities.fxml"));
        try {
            root = loader.load();
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
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StudentDashboardController SDC = loader.getController();
        SDC.dashboardController(loggedInUser);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToStudentInformation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stud_info.fxml"));
        try {
            root = loader.load();
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

    public void scholarshipDisplay(User loggedInUser) {
        this.loggedInUser=loggedInUser;
    }
}
