//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.csp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ScholarshipFacilitiesController implements Initializable {
    @FXML
    private TableView<Scholarship> table;
    @FXML
    private TableColumn<Scholarship, String> index;
    private TableColumn<Scholarship, String> name;
    @FXML
    private TableColumn<Scholarship, String> types;
    @FXML
    private TableColumn<Scholarship, String> level;
    ObservableList<Scholarship> list = FXCollections.observableArrayList(new Scholarship[]{new Scholarship("1", "Close", "MMU President's Scholarship", "Scholarship", "UG")});

    public ScholarshipFacilitiesController() {
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.index.setCellValueFactory(new PropertyValueFactory("index"));
        this.name.setCellValueFactory(new PropertyValueFactory("status"));
        this.index.setCellValueFactory(new PropertyValueFactory("name"));
        this.index.setCellValueFactory(new PropertyValueFactory("types"));
        this.index.setCellValueFactory(new PropertyValueFactory("level"));
        this.table.setItems(this.list);
    }

    public void scholarshipDisplay(User loggedInUser) {
    }
}
