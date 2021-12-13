package com.example.ap_project_snakesandladders;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.awt.*;
// get the mouse's position



import java.io.File;
import java.io.ObjectInputFilter;
import java.util.Random;

public class HelloController{
    @FXML
    private Label welcomeText;

    @FXML
    private Label locval;
    @FXML
    private ProgressBar progress;


    @FXML
    void findloc(MouseEvent event) {
        ask2move(event,locval);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    public double desx;
    public double desy;

    public void ask2move(MouseEvent event, Label locval){
        locval.setText("Move to X:"+String.valueOf(event.getSceneX())+"Y:"+String.valueOf(event.getSceneY()));
        desx=event.getSceneX();
        desy=event.getSceneY();
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
    private Text status;


    @FXML
    private ImageView dice;

    @FXML
    private Button butt;

    Random rand = new Random();



//    void ask2Move2(ActionEvent event) throws InterruptedException {
//        playTimer();
//        makeAmove(event);
//    }
//
//    void makeAmove(ActionEvent event) throws InterruptedException {
//
//        roll_button(event);
//    }
    @FXML
    void roll_button(ActionEvent event) throws InterruptedException{
        playTimer();
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
        translate.setByX(num*46.4);
        //redDie.setTranslateX(x+=num*40);
        translate.play();
        //x = (x + (47 * num));

        //redDie.setTranslateX();
        //redDie.setX(x);
        //redDie.setY(474.17);
    }

    void playTimer(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 0)),
                new KeyFrame(Duration.seconds(15), e-> {
                    // do anything you need here on completion...
                    System.out.println("15 sec over");
                }, new KeyValue(progress.progressProperty(), 1))
        );
        //timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }






}