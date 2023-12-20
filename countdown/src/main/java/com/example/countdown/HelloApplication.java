package com.example.countdown;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

public class HelloApplication extends Application {
    private Label label;
    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Mateusz Piela - 4TD");
        label = new Label();
        label.setLayoutX(100);
        label.setLayoutY(50);
        Scene scene = new Scene(label, 300, 300);
        stage.setScene(scene);
        stage.show();

        Timeline timeline = new Timeline(
            new KeyFrame(javafx.util.Duration.seconds(1), e -> {

                LocalDateTime teraz = LocalDateTime.now();
                LocalDateTime koniec = LocalDateTime.of(teraz.getYear(), 12, 31, 23, 59, 59);
                Duration duration = Duration.between(teraz, koniec);

                if (duration.getSeconds() < 0) {

                    label.setText("Nowy rok!");

                } else {

                    long d = duration.toDays();
                    long g = duration.toHours() % 24;
                    long m = duration.toMinutes() % 60;
                    long s = duration.getSeconds() % 60;

                    String wynik = String.format("%02d days %02d:%02d:%02d", d, g, m, s);
                    label.setText(wynik);
                }
            })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }
}