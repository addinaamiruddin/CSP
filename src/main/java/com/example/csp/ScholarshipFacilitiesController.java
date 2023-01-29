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
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ScholarshipFacilitiesController implements Initializable {
    @FXML
    private TableView<Scholarship> table;
    @FXML
    private TableColumn<Scholarship, String> indexColumn;
    private TableColumn<Scholarship, String> nameColumn;
    private TableColumn<Scholarship, String> statusColumn;
    @FXML
    private TableColumn<Scholarship, String> typesColumn;
    @FXML
    private TableColumn<Scholarship, String> levelColumn;
    ObservableList<Scholarship> list = FXCollections.observableArrayList(new Scholarship[]{new Scholarship("1", "Close", "MMU President's Scholarship", "Scholarship", "UG")});

    public ScholarshipFacilitiesController() {
    }

    public void initialize(URL location, ResourceBundle resources) {
//        this.index.setCellValueFactory(new PropertyValueFactory("index"));
//        this.name.setCellValueFactory(new PropertyValueFactory("status"));
//        this.index.setCellValueFactory(new PropertyValueFactory("name"));
//        this.index.setCellValueFactory(new PropertyValueFactory("types"));
//        this.index.setCellValueFactory(new PropertyValueFactory("level"));
//        this.table.setItems(this.list);

        Reader in = new FileReader("scholarships_list.csv");
        CSVParser parser = new CSVParser(in, CSVFormat.EXCEL.withHeader());
        ObservableList<Scholarship> data = FXCollections.observableArrayList(parser.getRecords());

        // Set the columns of the TableView
        for (String header : parser.getHeaderMap().keySet()) {
            TableColumn<Scholarship, String> column = new TableColumn<>(header);
            indexColumn.setCellValueFactory(new PropertyValueFactory<>(header));
            statusColumn.setCellValueFactory(new PropertyValueFactory<>(header));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>(header));
            typesColumn.setCellValueFactory(new PropertyValueFactory<>(header));
            levelColumn.setCellValueFactory(new PropertyValueFactory<>(header));

            table.getColumns().add(column);
        }

        // Set the items of the TableView to the data
        table.setItems(data);
    }

    public void scholarshipDisplay(User loggedInUser) {
    }
}
