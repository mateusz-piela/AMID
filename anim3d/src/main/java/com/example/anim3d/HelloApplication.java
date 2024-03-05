package com.example.anim3d;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        Button start = new Button("START");
        start.setLayoutY(400);
        start.setLayoutX(80);

        Button stop = new Button("STOP");
        stop.setLayoutY(400);
        stop.setLayoutX(180);

        Button step = new Button("STEP");
        step.setLayoutY(400);
        step.setLayoutX(280);

        Box box = new Box();
        box.setDepth(200);
        box.setHeight(200);
        box.setWidth(200);
        box.setLayoutY(200);
        box.setLayoutX(200);

        Rotate tiltY = new Rotate(25, Rotate.X_AXIS);
        box.getTransforms().addAll(tiltY);

        Rotate tiltX = new Rotate(45, Rotate.Y_AXIS);
        box.getTransforms().addAll(tiltX);

        RotateTransition rotateY = new RotateTransition();
        rotateY.setNode(box);
        rotateY.setByAngle(360);
        rotateY.setCycleCount(Transition.INDEFINITE);
        rotateY.setDuration(Duration.millis(5000));
        rotateY.setAutoReverse(false);
        rotateY.setAxis(Rotate.Y_AXIS);
        rotateY.setInterpolator(Interpolator.LINEAR);

        start.setOnAction(event -> {
            rotateY.play();
        });
        stop.setOnAction(event -> {
            rotateY.stop();
        });
        step.setOnAction(event -> {
            rotateY.stop();
            box.setRotate(box.getRotate()+1);
        });

        Group root = new Group(box,start,stop,step);

        Scene scene = new Scene(root, 400, 500);
        stage.setResizable(false);
        stage.setTitle("anim3d");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}