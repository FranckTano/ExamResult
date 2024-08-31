module com.example.consultationresultats {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.consultationresultats to javafx.fxml;
    exports com.example.consultationresultats;
}
