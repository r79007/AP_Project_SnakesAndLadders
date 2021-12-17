package com.example.ap_project_snakesandladders;


import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

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
    public static void move(Token t1, Token t2, int number, ImageView red, ImageView green) throws InterruptedException{
        if(n == 1 && t1.getStatus() == false){
            t1.setStatus(true);
            n=0;

            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000),event -> {
                if(i1==0){
                    TranslateTransition translate = new TranslateTransition();
                    translate.setNode(red);
                    translate.setDuration(Duration.millis(1000));
                    translate.setByX((49) * (number - 1) + 26 + 49);
                    translate.setByY(13);
                    t1.setX_coordinate(number);
                    translate.play();
                    i1++;
                }else{
                    for(Ladder i : HelloController.getLads()){
                        System.out.println(t1.x_coordinate);

                        if(i.getPos() == t1.getX_coordinate()){
                            System.out.println(i.getPos());
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
        else if(n == 0 && t2.getStatus() == false){
            t2.setStatus(true);
            n=1;
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(green);
            translate.setDuration(Duration.millis(1000));
            translate.setByX((49)*(number-1)+26+49);
            translate.setByY(-13);
            t2.setX_coordinate(number);
            System.out.println((int) t2.getX_coordinate());
            translate.play();
        }
        else if(n == 1) {
            n = 0;
            int num = number;
            System.out.println("Red");

            Loop<Token> thread=new Loop<>(t1,number,red);
            thread.start();

        }
        else if(n == 0){
            n=1;
            int num = number;
            System.out.println("green");            
            Loop<Token> thread=new Loop<>(t2,number,green);
            thread.start();        }
    }

    static class Loop<T extends Token> extends Thread {
        T token;
        int num;
        ImageView imgv;

        public Loop(T token, int num, ImageView imgv) {
            this.token = token;
            this.num = num;
            this.imgv = imgv;
        }

        @Override
        public void run() {

            while (num > 0) {
                if ((int) this.token.getX_coordinate() % 10 != 0) {
                    if (this.token.getX_coordinate() % 20 < 10) {
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
                    } else {
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
                } else {
                    Moves<T> th = new Moves<>(this.token, 1, 1, imgv);
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
