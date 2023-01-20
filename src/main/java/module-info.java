module com.example.csp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csp to javafx.fxml;
    exports com.example.csp;
}