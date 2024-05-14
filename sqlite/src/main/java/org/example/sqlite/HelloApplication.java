package org.example.sqlite;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class HelloApplication extends Application {
    public Connection connection = null;
    public void dbConnect(){
        try {
            String url = "jdbc:mysql://localhost:3306/4dt5_abd_firma";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tableCreationMenu(){

        Stage stage = new Stage();
        VBox v = new VBox();
        v.setSpacing(20);
        v.setAlignment(Pos.CENTER);

        Scene scene = new Scene(v, 800, 600);
        stage.setTitle("SQLite - Create Table");
        stage.setScene(scene);
        stage.show();

        Label tfLabel = new Label("Table name:");
        TextField tf = new TextField();
        tf.setMaxWidth(100);
        String tableName = tf.getText();

        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);

        v.getChildren().addAll(tfLabel, tf);

        HBox structure = new HBox();
        structure.setAlignment(Pos.CENTER);
        structure.setSpacing(10);

        VBox vName = new VBox();
        vName.setAlignment(Pos.CENTER);
        vName.setSpacing(10);
        Label labelName = new Label("Name:");
        TextField colName1 = new TextField();
        TextField colName2 = new TextField();
        TextField colName3 = new TextField();
        TextField colName4 = new TextField();
        vName.getChildren().addAll(labelName, colName1, colName2, colName3, colName4);

        VBox vType = new VBox();
        vType.setAlignment(Pos.CENTER);
        vType.setSpacing(10);
        Label labelType = new Label("Type:");
        ChoiceBox<String> type1 = new ChoiceBox<>(FXCollections.observableArrayList("INT", "VARCHAR(255)", "TEXT", "CHAR", "DATE", "FLOAT", "DOUBLE", "BOOLEAN"));
        ChoiceBox<String> type2 = new ChoiceBox<>(FXCollections.observableArrayList("INT", "VARCHAR(255)", "TEXT", "CHAR", "DATE", "FLOAT", "DOUBLE", "BOOLEAN"));
        ChoiceBox<String> type3 = new ChoiceBox<>(FXCollections.observableArrayList("INT", "VARCHAR(255)", "TEXT", "CHAR", "DATE", "FLOAT", "DOUBLE", "BOOLEAN"));
        ChoiceBox<String> type4 = new ChoiceBox<>(FXCollections.observableArrayList("INT", "VARCHAR(255)", "TEXT", "CHAR", "DATE", "FLOAT", "DOUBLE", "BOOLEAN"));
        vType.getChildren().addAll(labelType, type1, type2, type3, type4);

        VBox vAI = new VBox();
        vAI.setAlignment(Pos.CENTER);
        vAI.setSpacing(10);
        Label labelAI = new Label("Auto Increment:");
        CheckBox ai1 = new CheckBox();
        CheckBox ai2 = new CheckBox();
        CheckBox ai3 = new CheckBox();
        CheckBox ai4 = new CheckBox();
        vAI.getChildren().addAll(labelAI, ai1, ai2, ai3, ai4);

        structure.getChildren().addAll(vName, vType, vAI);

        v.getChildren().addAll(structure);

        Label pIndex = new Label("Primary Key?");
        TextField pKey = new TextField();
        pKey.setMaxWidth(100);

        v.getChildren().addAll(pIndex, pKey);

        Button createTableBtn = new Button("Create");
        createTableBtn.setOnAction(event -> {

            try {
                dbConnect();

                StringBuilder q = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
                q.append(tf.getText()).append(" (");
                q.append("`").append(colName1.getText()).append("` ").append(type1.getValue());
                if(ai1.isSelected()){
                    q.append(" AUTO_INCREMENT");
                }
                q.append(", ");
                q.append("`").append(colName2.getText()).append("` ").append(type2.getValue());
                if(ai2.isSelected()){
                    q.append(" AUTO_INCREMENT");
                }
                q.append(", ");
                q.append("`").append(colName3.getText()).append("` ").append(type3.getValue());
                if(ai3.isSelected()){
                    q.append(" AUTO_INCREMENT");
                }
                q.append(", ");
                q.append("`").append(colName4.getText()).append("` ").append(type4.getValue());
                if(ai4.isSelected()){
                    q.append(" AUTO_INCREMENT");
                }
                if(!pKey.getText().isEmpty()){
                    q.append(", PRIMARY KEY (`").append(pKey.getText()).append("`));");
                }else{
                    q.append(");");
                }

                PreparedStatement st = connection.prepareStatement(q.toString());
                st.executeUpdate();
                System.out.println("Created table");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction(event -> {
            stage.close();
        });

        hBox.getChildren().addAll(createTableBtn, exitBtn);
        v.getChildren().add(hBox);
    }

    public void insertMenu(){

        Stage stage = new Stage();
        VBox v = new VBox();
        v.setSpacing(20);
        v.setAlignment(Pos.CENTER);

        Scene scene = new Scene(v, 800, 600);
        stage.setTitle("SQLite - Insert");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage){

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("SQLite - Menu");
        stage.setScene(scene);
        stage.show();

        Label label = new Label("Menu:");
        ChoiceBox<String> cb = new ChoiceBox<>(FXCollections.observableArrayList("Create Table", "Add Records", "Search", "Exit"));
        Button btn = new Button("Submit");
        root.getChildren().addAll(label, cb, btn);

        btn.setOnAction(event -> {
            switch (cb.getValue()){
                case "Create Table":
                    tableCreationMenu();
                    break;

                case "Add Records":
                    insertMenu();
                    break;

                case "Search":

                case "Exit":
                    System.exit(0);

                default:
                    break;
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}