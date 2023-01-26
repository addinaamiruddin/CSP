package com.example.csp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPortalController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    DashboardDisplayStrategy strategy = null;

    public void MainPortalController() {
    }

    public void clickStudentBtn(ActionEvent event) {
        strategy = new StudentDashboardDisplayStrategy();
        strategy.displayUserPortal();

    }

    public void clickAdminBtn(ActionEvent event) {
        strategy = new AdminDashboardDisplayStrategy();
        strategy.displayUserPortal();

    }


}
