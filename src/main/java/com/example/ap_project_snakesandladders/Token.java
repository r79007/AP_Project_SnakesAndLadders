package com.example.ap_project_snakesandladders;


import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class Token {
    @FXML
    private ImageView token;
    private boolean status = false;
    private static int n = 1;

    public static void setN(int n) {
        Token.n = n;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private int x_coordinate;
    private int y_coordinate;

    private String p;

    public String getP() {
        return p;
    }

//    public void setP(Player p) {
//        this.p = p;
//    }

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



    public Token(ImageView token, int x_coordinate, int y_coordinate,String p) {
        this.token = token;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.p = p;
    }
    private static int i1=0;
    private static int i2=0;
    public static void move(Token t1, Token t2, int number, ImageView red, ImageView green, Group wImage, AnchorPane mImage, Label win_text, Label lose_text,Label text3,Player P1,Player P2) throws InterruptedException{
        if(n == 1 && t1.getStatus() == false && number==1){
            t1.setStatus(true);
            //n=0;
            if(i1==0) {
                TranslateTransition translate = new TranslateTransition();
                translate.setNode(red);
                translate.setDuration(Duration.millis(1000));
                HelloController.setDelay(2000);
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
                            HelloController.playAudio("/ladder3.mp3");

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
            timeline.setCycleCount(1);
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
                HelloController.setDelay(2000);
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

                            HelloController.playAudio("/ladder3.mp3");
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
            timeline.setCycleCount(1);
            timeline.play();


        }
        else if(n == 1 && t1.getStatus() == true) {
            //n = 0;
            int num = number;
            System.out.println("Red");
            if(num<=100-t1.getX_coordinate()) {
                Loop<Token> thread = new Loop<>(t1, num, red,mImage,wImage,win_text,lose_text,text3,P1,P2);
                thread.start();
            }

        }
        else if(n == 0 && t2.getStatus() == true){
           // n=1;
            int num = number;
            System.out.println("green");
            if(num<=100-t2.getX_coordinate()) {
                Loop<Token> thread=new Loop<>(t2,num,green,mImage,wImage,win_text,lose_text,text3,P1,P2);
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

    private static int k=0;
    static class Loop<T extends Token> extends Thread {
        private T token;
        private int num;
        private ImageView imgv;
        private AnchorPane mImage;
        private Group wImage;
        private Label win_text;
        private Label lose_text;
        private Label text3;
        private Player P1;
        private Player P2;

        public Loop(T token, int num, ImageView imgv,AnchorPane mImage,Group wImage,Label win_text,Label lose_text,Label text3,Player P1,Player P2) {
            this.token = token;
            this.num = num;
            this.imgv = imgv;
            this.mImage = mImage;
            this.wImage = wImage;
            this.win_text= win_text;
            this.lose_text = lose_text;
            this.text3 = text3;
            this.P1 = P1;
            this.P2 = P2;
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
                            Thread.sleep(300);
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
                            Thread.sleep(300);
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
                        Thread.sleep(300);
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
                    HelloController.playAudio("/snake2.mp3");
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            HelloController.setDelay(i.getLines().size()*1000+1000);
//                        }});
                    //System.out.println("Snake delay set");
                    //HelloController.setDelay(i.getLines().size()*1000+1000);
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
                    HelloController.playAudio("/ladder3.mp3");
//                    Platform.runLater(new Runnable() {
//                        @Override
//                        public void run() {
//                            HelloController.setDelay(1000);
//                        }});
                    //System.out.println("Ladder delay set");
                    //System.out.println(i.getPos());
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
            if(P1.getToken().getX_coordinate()==100) {
                Timeline tm=new Timeline(new KeyFrame(Duration.millis(1000),event -> {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
//                            BoxBlur bb = new BoxBlur();
//                            mImage.setEffect(bb);
                            HelloController.playAudio("/winningA1.mp3");
//                            if((token.getP()).equals("Player1")){
                                text3.setText("Player 1 WINS");
                                win_text.setText("Player 1");
                                win_text.setAlignment(Pos.CENTER);
                                lose_text.setText("Player 2");
                                lose_text.setAlignment(Pos.CENTER);
//                            }
//                            else{
//                                text3.setText("Player2 WINS");
//                                win_text.setText("Player2");
//                                win_text.setAlignment(Pos.CENTER);
//                                lose_text.setText("Player1");
//                                lose_text.setAlignment(Pos.CENTER);
//                            }
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
            else if(P2.getToken().getX_coordinate()==100) {
                Timeline tm=new Timeline(new KeyFrame(Duration.millis(1000),event -> {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
//                            BoxBlur bb = new BoxBlur();
//                            mImage.setEffect(bb);
                            HelloController.playAudio("/winningA1.mp3");
//                            if((token.getP()).equals("Player1")){
//                                text3.setText("Player1 WINS");
//                                win_text.setText("Player1");
//                                win_text.setAlignment(Pos.CENTER);
//                                lose_text.setText("Player2");
//                                lose_text.setAlignment(Pos.CENTER);
//                            }
//                            else{
                                text3.setText("Player 2 WINS");
                                win_text.setText("Player 2");
                                win_text.setAlignment(Pos.CENTER);
                                lose_text.setText("Player 1");
                                lose_text.setAlignment(Pos.CENTER);
//                            }
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
            TranslateTransition translateyup = new TranslateTransition();
            TranslateTransition translateydown = new TranslateTransition();
            SequentialTransition s;
//            ParallelTransition p = new ParallelTransition();
            if(coordinate==1){
                if(this.dir>0) {
                    translateyup.setNode(imgv);
                    translateyup.setDuration(Duration.millis(50));
                    translateyup.setByY(-10);
//                    translatey.setAutoReverse(true);
//                    translatey.setCycleCount(1);

                    translateydown.setNode(imgv);
                    translateydown.setDuration(Duration.millis(50));
                    translateydown.setByY(10);
//                    translatey.setAutoReverse(true);
//                    translatey.setCycleCount(1);
                    s = new SequentialTransition(translateyup, translateydown);
                    translate.setNode(imgv);
                    translate.setDuration(Duration.millis(100));
                    translate.setByX(49);

//                    ParallelTransition p = new ParallelTransition(translate,translatey);
//                    p.play();
                    translate.play();
                    s.play();

//                    translate.setByX(49/2);
//                    translate.setByY(4);
//                    translate.play();
                }else{
                    translate.setNode(imgv);
                    translate.setDuration(Duration.millis(100));
                    translate.setByX(-49);
//                    translate.play();
                    translateyup.setNode(imgv);
                    translateyup.setDuration(Duration.millis(50));
                    translateyup.setByY(-10);

                    translateydown.setNode(imgv);
                    translateydown.setDuration(Duration.millis(50));
                    translateydown.setByY(10);
                    s = new SequentialTransition(translateyup, translateydown);
                    translate.play();
                    s.play();

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
