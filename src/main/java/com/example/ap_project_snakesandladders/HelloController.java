package com.example.ap_project_snakesandladders;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

import javax.print.attribute.standard.RequestingUserName;
import java.awt.*;
// get the mouse's position



import java.io.File;
import java.io.ObjectInputFilter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;



public class HelloController implements Initializable {

    int n = 1;

    @FXML
    private ImageView greenDie;

    @FXML
    private ImageView redDie;

    private Token redToken = new Token(redDie,0,0);
    private Token greenToken = new Token(greenDie,0,0);

//    HelloController() {
//        Token red = new Token(redDie,169.377,458);
//        Token green = new Token(greenDie,169.5,419.5);
//    }

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

    //private double x=0;
    //private double y=0;
    private int number;

    @FXML
    private Button bt;

    @FXML
    private Text status;


    @FXML
    private ImageView dice;

    @FXML
    private Button butt;



    private Player p1;
    private Player p2;

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
        number = rand.nextInt(6)+1;
        String path = "src/main/resources/dice"+number+".png";
        File file = new File(path);
        dice.setImage(new Image(file.toURI().toString()));
        //initialize(null,null);
        temp();
        //move(event,number);
    }

//    @FXML
//    void move(ActionEvent event,int num) {
//        TranslateTransition translate=new TranslateTransition();
//        translate.setNode(redDie);
//        translate.setByX(num*46.4);
//        //redDie.setTranslateX(x+=num*40);
//        translate.play();
//        //x = (x + (47 * num));
//
//        //redDie.setTranslateX();
//        //redDie.setX(x);
//        //redDie.setY(474.17);
//    }

    void playTimer(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 0)),
                new KeyFrame(Duration.seconds(15), e-> {
                    // do anything you need here on completion...
                    //System.out.println("15 sec over");
                }, new KeyValue(progress.progressProperty(), 1))
        );
        //timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void temp() throws InterruptedException {
        //TranslateTransition translate = new TranslateTransition();
        if(n == 1 && redToken.getStatus() == false){
            redToken.setStatus(true);
            n=0;
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(redDie);
            translate.setDuration(Duration.millis(1000));
            translate.setByX((49)*(number-1)+26+49);
            //translate.setByY(10);
            translate.setByY(13);
            redToken.setX_coordinate(number);
            System.out.println((int) redToken.getX_coordinate());
//            trans.setNode((redDie));
//            trans.setDuration(Duration.millis(1000));
//            trans.setByX(24.288+49);
//            trans.setByY(10);
//            trans.setByX(24.228);
//            trans.setByY(23);

//            redDie.setX(24.288+49);
//            redDie.setY(10);
            //trans.play();
            translate.play();
        }
        else if(n == 0 && greenToken.getStatus() == false){
            greenToken.setStatus(true);
            n=1;

            TranslateTransition translate = new TranslateTransition();
            translate.setNode(greenDie);
            translate.setDuration(Duration.millis(1000));
            translate.setByX((49)*(number-1)+26+49);
            //translate.setByY(-15);
            translate.setByY(-13);
            greenToken.setX_coordinate(number);
            System.out.println((int) greenToken.getX_coordinate());

//            trans.setNode((redDie));
//            trans.setDuration(Duration.millis(1000));
//            trans.setByX(24.288+49);
//            trans.setByY(10);
//            trans.setByX(24.228);
//            trans.setByY(23);

//            redDie.setX(24.288+49);
//            redDie.setY(10);
            //trans.play();
            translate.play();
            //translate.play();
        }
        else if(n == 1) {
            n = 0;
//            TranslateTransition translate = new TranslateTransition();
//            translate.setNode(redDie);
//            translate.setDuration(Duration.millis(100));
            int num = number;
            System.out.println("Red");
//            int x=0;
//            int y=0;
            Loop<Token> thread=new Loop<>(redToken,number,redDie);
            thread.start();

//            TranslateTransition translate = new TranslateTransition();
//                translate.setNode(redDie);
//                translate.setDuration(Duration.millis(100));
//                translate.setByX(49*x);
//                translate.setByY(-51.99*y);
//                translate.play();
        }
        else if(n == 0){
            n=1;
//            TranslateTransition translate = new TranslateTransition();
//            translate.setNode(greenDie);
//            translate.setDuration(Duration.millis(1000));
            //translate.setByX((49)*number);
            //translate.play();
            //TranslateTransition translate = new TranslateTransition();
            int num = number;
            System.out.println("green");
//            int x=0;
//            int y=0;

            Loop<Token> thread=new Loop<>(greenToken,number,greenDie);
            thread.start();
//                        TranslateTransition translate = new TranslateTransition();
//                        translate.setNode(greenDie);
//                        translate.setDuration(Duration.millis(1000));
//                        translate.setByX(49*x);
//                        translate.setByY(-51.99*y);
//                        translate.play();

        }
    }

    class Loop<T extends Token> extends Thread{

        T token;
        int num;
        ImageView imgv;

        public Loop(T token, int num, ImageView imgv){
            this.token=token;
            this.num=num;
            this.imgv=imgv;
        }

        @Override
        public void run() {
//(((int) this.token.getX_coordinate() % 10 )% 2 == 0) &&

            while(num>0){
                if ((int) this.token.getX_coordinate() % 10 != 0) {
                    if(this.token.getX_coordinate()%20<10) {
                        Moves<T> th = new Moves<>(this.token, 1, 1, imgv);
                        System.out.println(this.token.getX_coordinate());
                        th.setCoordinate(1);
                        th.setDir(1);  //for now +ve
                        th.start();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        Moves<T> th = new Moves<>(this.token, 1, 1, imgv);
                        System.out.println(this.token.getX_coordinate());
                        th.setCoordinate(1);
                        th.setDir(-1);  //for now +ve
                        th.start();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
                else{
                    Moves<T> th=new Moves<>(this.token,1,1, imgv);
                    System.out.println(this.token.getX_coordinate());
                    th.setCoordinate(0);
                    th.setDir(1);   //for now +ve
                    th.start();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num--;
            }
        }
    }

    class Moves<T extends Token> extends Thread{
        private T token;
        private int dir;
        private int coordinate;
        private ImageView imgv;

        public void setDir(int dir) {
            this.dir = dir;
        }

        public void setCoordinate(int coordinate){
            this.coordinate=coordinate;
        }

        public Moves(T token, int dir, int coordinate, ImageView imgv){
            this.token=token;
            this.dir=dir;
            this.coordinate=coordinate;
            this.imgv=imgv;
        }

        @Override
        public void run() {
            TranslateTransition translate = new TranslateTransition();
            if(coordinate==1){  //X move
                if(this.dir>0) {
                    translate.setNode(imgv);  //should be this.token.getToken();
                    translate.setDuration(Duration.millis(100));
                    translate.setByX(49);
                    //System.out.println("hi");
                    translate.play();
                    //token.setX_coordinate(token.getX_coordinate() + 1);
                }else{
                    translate.setNode(imgv);  //should be this.token.getToken();
                    translate.setDuration(Duration.millis(100));
                    translate.setByX(-49);
                    //System.out.println("hi");
                    translate.play();
                }
                token.setX_coordinate(token.getX_coordinate() + 1);
            }else{
                if(this.dir>0) {
                    translate.setNode(imgv);
                    translate.setDuration(Duration.millis(100));
                    //translate.setByY(-51.99);
                    translate.setByY(-49.5);
                    translate.play();

                }else{
                    translate.setNode(imgv);
                    translate.setDuration(Duration.millis(100));
                    //translate.setByY(51.99);
                    translate.setByY(50);
                    translate.play();
                }
                token.setX_coordinate(token.getX_coordinate() + 1);
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        TranslateTransition translate = new TranslateTransition();
//        if(n == 1 && red.getStatus() == false){
//            red.setStatus(true);
//            n=0;
//            TranslateTransition trans = new TranslateTransition();
//            translate.setNode(redDie);
//            translate.setDuration(Duration.millis(1000));
//            translate.setByX((49)*number);
//
//            trans.setNode((redDie));
//            trans.setDuration(Duration.millis(1000));
//            trans.setByX(24.228);
//            trans.setByY(23);
//
//            trans.play();
//            translate.play();
//        }
//        else if(n == 0 && green.getStatus() == false){
//            green.setStatus(true);
//            n=1;
//
//            TranslateTransition trans = new TranslateTransition();
//            trans.setNode(greenDie);
//            trans.setDuration(Duration.millis(1000));
//            trans.setByX(24);
//            trans.setByY(-20);
//            trans.play();
//
//            translate.setNode(greenDie);
//            translate.setDuration(Duration.millis(1000));
//            translate.setByX((49)*number);
//            translate.play();
//        }
//        else if(n == 1){
//            n=0;
//            translate.setNode(redDie);
//            translate.setDuration(Duration.millis(1000));
//            translate.setByX((49)*number);
//            translate.play();
//        }
//        else if(n == 0){
//            n=1;
//            translate.setNode(greenDie);
//            translate.setDuration(Duration.millis(1000));
//            translate.setByX((49)*number);
//            translate.play();
//        }
//        translate.setDuration(Duration.millis(1000));
//        translate.setByX((49)*number);
//        translate.play();
    }
}