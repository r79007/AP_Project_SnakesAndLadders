package com.example.ap_project_snakesandladders;

import javafx.animation.*;
import javafx.application.Platform;
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
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.shape.Line;

import javax.print.attribute.standard.RequestingUserName;
import java.awt.*;




import java.io.File;
import java.io.ObjectInputFilter;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import static com.example.ap_project_snakesandladders.HelloApplication.lads;


public class HelloController implements Initializable {

    int n = 1;
    @FXML
    private Line path1;

    @FXML
    private ImageView greenDie;

    @FXML
    private ImageView redDie;

    private Token redToken = new Token(redDie,0,0);
    private Token greenToken = new Token(greenDie,0,0);






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



    @FXML
    void roll_button(ActionEvent event) throws InterruptedException{
        playTimer();
        number = rand.nextInt(6)+1;
        String path = "src/main/resources/dice"+number+".png";
        File file = new File(path);
        dice.setImage(new Image(file.toURI().toString()));

        move();

    }















    void playTimer(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 0)),
                new KeyFrame(Duration.seconds(15), e-> {


                }, new KeyValue(progress.progressProperty(), 1))
        );

        timeline.play();
    }
    int i=0;
    public void move() throws InterruptedException {

        if(n == 1 && redToken.getStatus() == false){
            redToken.setStatus(true);
            n=0;
            Thread th1=new Thread(new Runnable() {
                @Override public void run() {
                    TranslateTransition translate = new TranslateTransition();
                    translate.setNode(redDie);
                    translate.setDuration(Duration.millis(1000));
                    translate.setByX((49) * (1 - 1) + 26 + 49);

                    translate.setByY(13);

                    redToken.setX_coordinate(1);
                    System.out.println((int) redToken.getX_coordinate());
                    translate.play();
                }});
                Thread th2=new Thread(new Runnable() {
                    @Override public void run() {

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        redDie.setX(redDie.getLayoutX());
                        redDie.setY(redDie.getLayoutY());
                        redDie.setLayoutX(0);
                        redDie.setLayoutY(0);
                        PathTransition pt = new PathTransition();
                        pt.setNode(redDie);
                        pt.setPath(path1);
                        pt.setDuration(Duration.millis(1000));
                        pt.play();

                    }
                });

                th1.start();

                th2.start();

































































        }
        else if(n == 0 && greenToken.getStatus() == false){
            greenToken.setStatus(true);
            n=1;

            TranslateTransition translate = new TranslateTransition();
            translate.setNode(greenDie);
            translate.setDuration(Duration.millis(1000));
            translate.setByX((49)*(number-1)+26+49);

            translate.setByY(-13);
            greenToken.setX_coordinate(number);
            System.out.println((int) greenToken.getX_coordinate());
























            translate.play();

        }
        else if(n == 1) {
            n = 0;



            int num = number;
            System.out.println("Red");


            Loop<Token> thread=new Loop<>(redToken,number,redDie);
            thread.start();







        }
        else if(n == 0){
            n=1;






            int num = number;
            System.out.println("green");



            Loop<Token> thread=new Loop<>(greenToken,number,greenDie);
            thread.start();







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


            while(num>0){
                if ((int) this.token.getX_coordinate() % 10 != 0) {
                    if(this.token.getX_coordinate()%20<10) {

                        Moves<T> th = new Moves<>(this.token, 1, 1, imgv);
                        System.out.println(this.token.getX_coordinate());
                        th.setCoordinate(1);
                        th.setDir(1);
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
                        th.setDir(-1);
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
                    th.setDir(1);
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

    class LadderTransition<T extends Token> extends Thread{
        private T token;
        private ImageView imgv;
        private Shape path;

        public LadderTransition(T token, ImageView imgv, Shape path) {
            this.token=token;
            this.imgv=imgv;
            this.path=path;
        }

        @Override
        public void run(){

        imgv.setX(redDie.getLayoutX());
        imgv.setY(redDie.getLayoutY());
        imgv.setLayoutX(0);
        imgv.setLayoutY(0);
        PathTransition pt = new PathTransition();
        pt.setNode(imgv);
        pt.setPath((javafx.scene.shape.Shape) this.path);
        pt.setDuration(Duration.millis(3000));
        pt.play();


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
            if(coordinate==1){
                if(this.dir>0) {
                    translate.setNode(imgv);
                    translate.setDuration(Duration.millis(100));
                    translate.setByX(49);

                    translate.play();

                }else{
                    translate.setNode(imgv);
                    translate.setDuration(Duration.millis(100));
                    translate.setByX(-49);

                    translate.play();
                }
                token.setX_coordinate(token.getX_coordinate() + 1);
            }else{
                if(this.dir>0) {
                    translate.setNode(imgv);
                    translate.setDuration(Duration.millis(100));

                    translate.setByY(-49.5);
                    translate.play();

                }else{
                    translate.setNode(imgv);
                    translate.setDuration(Duration.millis(100));

                    translate.setByY(50);
                    translate.play();
                }
                token.setX_coordinate(token.getX_coordinate() + 1);
            }
        }
    }




























    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {









    }
}