package com.example.animacjakolizje;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    private double dx = 2;
    private double dy = 2;
    private static final int x = 800;
    private static final int y = 600;
    private static final int radius = 10;
    private static final int minX = radius;
    private static final int minY = radius;
    private static final int maxX = x-radius;
    private static final int maxY = y-radius;

    @Override
    public void start(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root, x, y);
        scene.setFill(Color.BLACK);
        stage.setTitle("Animacja Kolizje | Mateusz Piela | Klasa 4TD");
        stage.setScene(scene);
        stage.show();

        int randomX = minX + (int) (Math.random() * ((maxX - minX) + 1));
        int randomY = minY + (int) (Math.random() * ((maxY - minY) + 1));

        Circle circle = new Circle();
        circle.setRadius(radius);
        circle.setTranslateX(randomX);
        circle.setTranslateY(randomY);
        circle.setFill(Color.LIMEGREEN);
        root.getChildren().addAll(circle);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {

            circle.setTranslateX(circle.getTranslateX() + dx);
            circle.setTranslateY(circle.getTranslateY() + dy);

            if (circle.getTranslateX() <= minX || circle.getTranslateX() >= maxX) {
                dx = -dx;
            }
            if (circle.getTranslateY() <= minY || circle.getTranslateY() >= maxY) {
                dy = -dy;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }
}