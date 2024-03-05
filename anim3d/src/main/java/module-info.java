module com.example.anim3d {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.anim3d to javafx.fxml;
    exports com.example.anim3d;
}