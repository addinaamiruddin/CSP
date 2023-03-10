package com.example.csp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;


public class MainPortalController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    DashboardDisplayStrategy strategy = null;
    @FXML
    private Button student_btn;

    public void MainPortalController() {
    }

    public void clickStudentBtn(ActionEvent event) {
        strategy = new StudentDashboardDisplayStrategy();
        strategy.displayUserPortal(event);
    }

    public void clickAdminBtn(ActionEvent event) {
        strategy = new AdminDashboardDisplayStrategy();
        strategy.displayUserPortal(event);
    }

    public void switchToMainPortal2(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal_2.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void switchToMainPortal1(ActionEvent event) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("main_portal.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    public void toVideo(ActionEvent event) {

        //Create Stage
        Stage newWindow = new Stage();
        newWindow.setTitle("VIDEO BRIEFING");
        //Create view in Java
        Parent root = null;
        try {
            root = (Parent) FXMLLoader.load(this.getClass().getResource("view_video.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Set view in window
        newWindow.setScene(new Scene(root));
        //Launch
        newWindow.show();
    }
}