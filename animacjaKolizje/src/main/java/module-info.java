module com.example.animacjakolizje {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animacjakolizje to javafx.fxml;
    exports com.example.animacjakolizje;
}