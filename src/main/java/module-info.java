module com.example.csp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.csp to javafx.fxml;
    exports com.example.csp;
}