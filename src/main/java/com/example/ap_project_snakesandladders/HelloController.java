package com.example.ap_project_snakesandladders;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    private double x=0;
    private double y=0;

    @FXML
    private Button bt;

    @FXML
    private ImageView greenDie;

    @FXML
    private ImageView redDie;


    @FXML
    private ImageView dice;

    @FXML
    private Button butt;

    Random rand = new Random();

    @FXML
    void roll_button(ActionEvent event) throws InterruptedException{
        int number = rand.nextInt(6)+1;
        String path = "src/main/resources/dice"+number+".png";
        File file = new File(path);
        dice.setImage(new Image(file.toURI().toString()));
        move(event,number);
    }

    @FXML
    void move(ActionEvent event,int num) {
        TranslateTransition translate=new TranslateTransition();
        translate.setNode(redDie);
        translate.setByX(num*40);
        //redDie.setTranslateX(x+=num*40);
        translate.play();
    }
}