package com.example.ap_project_snakesandladders;


import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class Token {
    @FXML
    private ImageView token;
    private boolean status = false;
    private static int n = 1;
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private int x_coordinate;
    private int y_coordinate;

    public ImageView getToken() {
        return this.token;
    }

    public void setToken(ImageView token) {
        this.token = token;
    }

    public int getX_coordinate() {
        return this.x_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public int getY_coordinate() {
        return this.y_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }



    public Token(ImageView token, int x_coordinate, int y_coordinate) {
        this.token = token;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }
    static int i1=0;
    static int i2=0;
    public static void move(Token t1, Token t2, int number, ImageView red, ImageView green, Group wImage, AnchorPane mImage) throws InterruptedException{
        if(n == 1 && t1.getStatus() == false && number==1){
            t1.setStatus(true);
            //n=0;
            if(i1==0) {
                TranslateTransition translate = new TranslateTransition();
                translate.setNode(red);
                translate.setDuration(Duration.millis(1000));
                translate.setByX((49) * (number - 1) + 26 + 49);
                translate.setByY(13);
                t1.setX_coordinate(number);
                translate.play();
                i1++;
            }

            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000),event -> {

                if(i1==1){
                    for(Ladder i : HelloController.getLads()){
                        //System.out.println(t1.x_coordinate);

                        if(i.getPos() == t1.getX_coordinate()){
                            //System.out.println(i.getPos());
                            t1.setX_coordinate(i.getF_pos());

                            red.setX(red.getLayoutX());
                            red.setY(red.getLayoutY());
                            red.setLayoutX(0);
                            red.setLayoutY(0);
                            PathTransition pt = new PathTransition();
                            pt.setNode(red);
                            pt.setPath(i.getPath());
                            pt.setDuration(Duration.millis(1000));
                            pt.play();
                            break;
                        }
                    }
                }
            }));
            timeline.setCycleCount(2);
            timeline.play();
//            Thread th1=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    TranslateTransition translate = new TranslateTransition();
//                    translate.setNode(red);
//                    translate.setDuration(Duration.millis(1000));
//                    translate.setByX((49) * (1 - 1) + 26 + 49);
//                    translate.setByY(13);
//                    t1.setX_coordinate(1);
//                    //System.out.println((int) t1.getX_coordinate());
//                    translate.play();
//                    Thread th2=new Thread(new Runnable() {
//                        @Override public void run() {
//                            try {
//                                Thread.sleep(1000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            for(Ladder i : HelloController.getLads()){
//                                System.out.println(t1.x_coordinate);
//
//                                if(i.getPos() == t1.getX_coordinate()){
//                                    System.out.println(t1.getX_coordinate());
//
//
//                                            red.setX(red.getLayoutX());
//                                            red.setY(red.getLayoutY());
//                                            red.setLayoutX(0);
//                                            red.setLayoutY(0);
//                                            PathTransition pt = new PathTransition();
//                                            pt.setNode(red);
//                                            pt.setPath(path1);
//                                            pt.setDuration(Duration.millis(1000));
//                                            pt.play();
//                                        }
//
//
//                                    break;
//                                }
//                            }
//
//                    });
//                }});
//
//            th1.start();

//            for(Ladder i : HelloController.getLads()){
//                System.out.println(t1.x_coordinate);
//
//                if(i.getPos() == t1.getX_coordinate()){
//                    System.out.println(t1.getX_coordinate());
//                    Thread th2=new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                Thread.sleep(1000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            red.setX(red.getLayoutX());
//                            red.setY(red.getLayoutY());
//                            red.setLayoutX(0);
//                            red.setLayoutY(0);
//                            PathTransition pt = new PathTransition();
//                            pt.setNode(red);
//                            pt.setPath(path1);
//                            pt.setDuration(Duration.millis(1000));
//                            pt.play();
//                        }
//                    });
//                    th2.start();
//                    break;
//                }
//            }
        }
        else if(n == 0 && t2.getStatus() == false && number==1){
//            t2.setStatus(true);
//            n=1;
//            TranslateTransition translate = new TranslateTransition();
//            translate.setNode(green);
//            translate.setDuration(Duration.millis(1000));
//            translate.setByX((49)*(number-1)+26+49);
//            translate.setByY(-13);
//            t2.setX_coordinate(number);
//            System.out.println((int) t2.getX_coordinate());
//            translate.play();

            t2.setStatus(true);
            //n=1;
            if(i2==0){
                TranslateTransition translate = new TranslateTransition();
                translate.setNode(green);
                translate.setDuration(Duration.millis(1000));
                translate.setByX((49) * (number - 1) + 26 + 49);
                translate.setByY(-13);
                t2.setX_coordinate(number);
                translate.play();
                i2++;
            }

            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000),event -> {
                if(i2==1){
                    for(Ladder i : HelloController.getLads()){
                        //System.out.println(t2.x_coordinate);

                        if(i.getPos() == t2.getX_coordinate()){
                            //System.out.println(i.getPos());
                            t2.setX_coordinate(i.getF_pos());

                            green.setX(green.getLayoutX());
                            green.setY(green.getLayoutY());
                            green.setLayoutX(0);
                            green.setLayoutY(0);
                            PathTransition pt = new PathTransition();
                            pt.setNode(green);
                            pt.setPath(i.getPath());
                            pt.setDuration(Duration.millis(1000));
                            pt.play();
                            break;
                        }
                    }
                }
            }));
            timeline.setCycleCount(2);
            timeline.play();


        }
        else if(n == 1 && t1.getStatus() == true) {
            //n = 0;
            int num = number;
            System.out.println("Red");
            if(num<=100-t1.getX_coordinate()) {
                Loop<Token> thread = new Loop<>(t1, num, red,mImage,wImage);
                thread.start();
            }

        }
        else if(n == 0 && t2.getStatus() == true){
           // n=1;
            int num = number;
            System.out.println("green");
            if(num<=100-t2.getX_coordinate()) {
                Loop<Token> thread=new Loop<>(t2,num,green,mImage,wImage);
                thread.start();
            }
        }

        if(n==1){
            n=0;
        }
        else{
            n=1;
        }
    }

    static int k=0;
    static class Loop<T extends Token> extends Thread {
        T token;
        int num;
        ImageView imgv;
        AnchorPane mImage;
        Group wImage;

        public Loop(T token, int num, ImageView imgv,AnchorPane mImage,Group wImage) {
            this.token = token;
            this.num = num;
            this.imgv = imgv;
            this.mImage = mImage;
            this.wImage = wImage;
        }

        @Override
        public void run() {

            while (num > 0) {
                if ((int) this.token.getX_coordinate() % 10 != 0) {
                    if (this.token.getX_coordinate() % 20 < 10) {
                        Moves<T> th = new Moves<>(this.token, 1, 1, imgv);
                        //System.out.println(this.token.getX_coordinate());
                        th.setCoordinate(1);
                        th.setDir(1);
                        th.start();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Moves<T> th = new Moves<>(this.token, 1, 1, imgv);
                        //System.out.println(this.token.getX_coordinate());
                        th.setCoordinate(1);
                        th.setDir(-1);
                        th.start();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Moves<T> th = new Moves<>(this.token, 1, 1, imgv);
                    //System.out.println(this.token.getX_coordinate());
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

            //ArrayList<Snake> snakes = HelloController.getSnakes();
            for(Snake i : HelloController.getSnakes()){
                System.out.println(i.getPos());
                if(i.getPos() == this.token.getX_coordinate()){
                    System.out.println(i.getPos());
                    this.token.setX_coordinate(i.getF_pos());
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000),event ->{
                        Polyline l = i.getLines().get(k);
                        imgv.setX(imgv.getLayoutX());
                        imgv.setY(imgv.getLayoutY());
                        imgv.setLayoutX(0);
                        imgv.setLayoutY(0);
                        PathTransition pt = new PathTransition();
                        pt.setNode(imgv);
                        pt.setPath(l);
                        pt.setDuration(Duration.millis(1000));
                        pt.play();
                        k++;
                    }));
                    timeline.setCycleCount(i.getLines().size());
                    timeline.play();
                    k=0;
                    break;
                }
            }


            for (Ladder i : HelloController.getLads()) {
                System.out.println(this.token.getX_coordinate());

                if (i.getPos() == this.token.getX_coordinate()) {
                    System.out.println(i.getPos());
                    this.token.setX_coordinate(i.getF_pos());

                    imgv.setX(imgv.getLayoutX());
                    imgv.setY(imgv.getLayoutY());
                    imgv.setLayoutX(0);
                    imgv.setLayoutY(0);
                    PathTransition pt = new PathTransition();
                    pt.setNode(imgv);
                    pt.setPath(i.getPath());
                    pt.setDuration(Duration.millis(1000));
                    pt.play();
                    break;
                }
            }
            if(token.getX_coordinate()==100) {
                Timeline tm=new Timeline(new KeyFrame(Duration.millis(1000),event -> {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
//                            BoxBlur bb = new BoxBlur();
//                            mImage.setEffect(bb);
                            wImage.setVisible(true);
                            //if (token.getX_coordinate() == 100) {
                            //SceneController scnt=new SceneController();
                            //HelloController hct = new HelloController();
//                            try {
//                                HelloController.switchToScene1();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            //}
                        }
                    });
                }));

                tm.play();

            }


        }
    }
    static class Moves<T extends Token> extends Thread{
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
}
