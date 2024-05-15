module org.example.sqlite {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.sqlite to javafx.fxml;
    exports org.example.sqlite;
}