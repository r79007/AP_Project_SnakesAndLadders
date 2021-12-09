package com.example.hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Circle mc;
    private double x;
    private double y;

    public void up(ActionEvent e){
        //System.out.println("UP");
        mc.setCenterY(y-=2);
    }

    public void down(ActionEvent e){
        //System.out.println("DOWN");
        mc.setCenterY(y+=2);
    }
    public void right(ActionEvent e){
        //System.out.println("RIGHT");
        mc.setCenterX(x+=2);
    }

    public void left(ActionEvent e){
        //System.out.println("LEFT");
        mc.setCenterX(x-=2);
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private void Switchtoscene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void Switchtoscene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene2.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}