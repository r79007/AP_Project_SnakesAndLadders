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
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private static ArrayList<Ladder> lads = new ArrayList<>();

    public static ArrayList<Ladder> getLads() {
        return lads;
    }

    @FXML
    public Line path1_38;
    //HelloApplication.lads.get(0)
    @FXML
    public Line path4_14;
    @FXML
    public Line path9_31;
    @FXML
    private Line path21_42;
    @FXML
    private Line path28_84;
    @FXML
    private Line path36_44;
    @FXML
    private Line path51_67;
    @FXML
    private Line path80_100;
    @FXML
    private Line path71_91;

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
    private ImageView rollingDice;

    @FXML
    private ImageView downArrow;

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
    }    private int number;
    @FXML
    private Button bt;
    @FXML
    private Text status;

    @FXML
    private ImageView dice;
    @FXML
    private Button butt;    private Player p1;
    private Player p2;
    Random rand = new Random();
    static int i2=0;
    @FXML
    void roll_button(ActionEvent event) throws InterruptedException{
        downArrow.setVisible(false);
        //playTimer(-1);
        Timeline timeline1 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 0)),
                new KeyFrame(Duration.seconds(15), e-> {

                }, new KeyValue(progress.progressProperty(), 1))
        );
        //timeline.stop();
        Thread th1=new Thread(new Runnable() {
            @Override
            public void run() {
                //rollingDice.setVisible(true);
                i2++;
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        //timeline1.stop();
                        rollingDice.setVisible(true);
                        dice.setVisible(false);
                        //downArrow.setVisible(true);
                    }
                });
                Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(1),event1 -> {
//                    if(i2==0) {
//                        rollingDice.setVisible(true);
//                        i2++;
                    if(i2==1){
                        rollingDice.setVisible(false);
                        Platform.runLater(new Runnable() {
                            @Override public void run() {
                                //timeline1.stop();
                                dice.setVisible(true);
                                //downArrow.setVisible(true);
                            }
                        });
                        i2=0;
                    }

                }));
                timeline.setCycleCount(1);
                timeline.play();

            }
        });
//        Thread th3=new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//
//            }
//        });
        Thread th2=new Thread(new Runnable() {
            @Override
            public void run() {
                //rollingDice.setVisible(false);
                number = rand.nextInt(6)+1;
                String path = "src/main/resources/dice"+number+".png";
                File file = new File(path);

                dice.setImage(new Image(file.toURI().toString()));

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    move();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        timeline1.play();
                        downArrow.setVisible(true);
                    }
                });
            }
        });


        th1.start();
        //th1.join(2000);
        th2.start();

    }

    void playTimer(int option){
        downArrow.setVisible(true);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 0)),
                new KeyFrame(Duration.seconds(15), e-> {

                }, new KeyValue(progress.progressProperty(), 1))
        );
        if(option>0) {
            timeline.play();
        }else{
            timeline.stop();
        }
        //downArrow.setVisible(false);
    }
    int i=0;
    public void move() throws InterruptedException {
        Token.move(redToken,greenToken,number,redDie,greenDie);
    }
//        if(n == 1 && redToken.getStatus() == false){
//            redToken.setStatus(true);
//            n=0;
//            Thread th1=new Thread(new Runnable() {
//                @Override public void run() {
//                    TranslateTransition translate = new TranslateTransition();
//                    translate.setNode(redDie);
//                    translate.setDuration(Duration.millis(1000));
//                    translate.setByX((49) * (1 - 1) + 26 + 49);
//                    translate.setByY(13);
//                    redToken.setX_coordinate(1);
//                    System.out.println((int) redToken.getX_coordinate());
//                    translate.play();
//                }});
//                Thread th2=new Thread(new Runnable() {
//                    @Override public void run() {
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        redDie.setX(redDie.getLayoutX());
//                        redDie.setY(redDie.getLayoutY());
//                        redDie.setLayoutX(0);
//                        redDie.setLayoutY(0);
//                        PathTransition pt = new PathTransition();
//                        pt.setNode(redDie);
//                        pt.setPath(path1);
//                        pt.setDuration(Duration.millis(1000));
//                        pt.play();
//                    }
//                });
//                th1.start();
//                th2.start();
//        }
//        else if(n == 0 && greenToken.getStatus() == false){
//            greenToken.setStatus(true);
//            n=1;
//            TranslateTransition translate = new TranslateTransition();
//            translate.setNode(greenDie);
//            translate.setDuration(Duration.millis(1000));
//            translate.setByX((49)*(number-1)+26+49);
//            translate.setByY(-13);
//            greenToken.setX_coordinate(number);
//            System.out.println((int) greenToken.getX_coordinate());
//            translate.play();
//        }
//        else if(n == 1) {
//            n = 0;            int num = number;
//            System.out.println("Red");
//
//            Loop<Token> thread=new Loop<>(redToken,number,redDie);
//            thread.start();
//
//        }
//        else if(n == 0){
//            n=1;
//            int num = number;
//            System.out.println("green");            Loop<Token> thread=new Loop<>(greenToken,number,greenDie);
//            thread.start();        }
//    }
//    class Loop<T extends Token> extends Thread{
//        T token;
//        int num;
//        ImageView imgv;
//        public Loop(T token, int num, ImageView imgv){
//            this.token=token;
//            this.num=num;
//            this.imgv=imgv;
//        }
//        @Override
//        public void run() {
//
//            while(num>0){
//                if ((int) this.token.getX_coordinate() % 10 != 0) {
//                    if(this.token.getX_coordinate()%20<10) {
//                        Moves<T> th = new Moves<>(this.token, 1, 1, imgv);
//                        System.out.println(this.token.getX_coordinate());
//                        th.setCoordinate(1);
//                        th.setDir(1);
//                        th.start();
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }else{
//                        Moves<T> th = new Moves<>(this.token, 1, 1, imgv);
//                        System.out.println(this.token.getX_coordinate());
//                        th.setCoordinate(1);
//                        th.setDir(-1);
//                        th.start();
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                else{
//                    Moves<T> th=new Moves<>(this.token,1,1, imgv);
//                    System.out.println(this.token.getX_coordinate());
//                    th.setCoordinate(0);
//                    th.setDir(1);
//                    th.start();
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                num--;
//            }
//
//        }
//    }
//    class LadderTransition<T extends Token> extends Thread{
//        private T token;
//        private ImageView imgv;
//        private Shape path;
//        public LadderTransition(T token, ImageView imgv, Shape path) {
//            this.token=token;
//            this.imgv=imgv;
//            this.path=path;
//        }
//        @Override
//        public void run(){
//        imgv.setX(redDie.getLayoutX());
//        imgv.setY(redDie.getLayoutY());
//        imgv.setLayoutX(0);
//        imgv.setLayoutY(0);
//        PathTransition pt = new PathTransition();
//        pt.setNode(imgv);
//        pt.setPath((javafx.scene.shape.Shape) this.path);
//        pt.setDuration(Duration.millis(3000));
//        pt.play();
//
//        }
//    }
//    class Moves<T extends Token> extends Thread{
//        private T token;
//        private int dir;
//        private int coordinate;
//        private ImageView imgv;
//        public void setDir(int dir) {
//            this.dir = dir;
//        }
//        public void setCoordinate(int coordinate){
//            this.coordinate=coordinate;
//        }
//        public Moves(T token, int dir, int coordinate, ImageView imgv){
//            this.token=token;
//            this.dir=dir;
//            this.coordinate=coordinate;
//            this.imgv=imgv;
//        }
//        @Override
//        public void run() {
//            TranslateTransition translate = new TranslateTransition();
//            if(coordinate==1){
//                if(this.dir>0) {
//                    translate.setNode(imgv);
//                    translate.setDuration(Duration.millis(100));
//                    translate.setByX(49);
//                    translate.play();
//                }else{
//                    translate.setNode(imgv);
//                    translate.setDuration(Duration.millis(100));
//                    translate.setByX(-49);
//                    translate.play();
//                }
//                token.setX_coordinate(token.getX_coordinate() + 1);
//            }else{
//                if(this.dir>0) {
//                    translate.setNode(imgv);
//                    translate.setDuration(Duration.millis(100));
//                    translate.setByY(-49.5);
//                    translate.play();
//                }else{
//                    translate.setNode(imgv);
//                    translate.setDuration(Duration.millis(100));
//                    translate.setByY(50);
//                    translate.play();
//                }
//                token.setX_coordinate(token.getX_coordinate() + 1);
//            }
//        }
//    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ladder l1 = new Ladder();
        l1.setPos(1);
        l1.setTranslate_X(2);
        l1.setTranslate_y(3);
        l1.setF_pos(38);
        l1.setPath(path1_38);
        lads.add(l1);

        Ladder l2 = new Ladder();
        l2.setPos(4);
        l2.setTranslate_X(3);
        l2.setTranslate_y(1);
        l2.setF_pos(14);
        l2.setPath(path4_14);
        lads.add(l2);

        Ladder l3 = new Ladder();
        l3.setPos(9);
        l3.setTranslate_X(1);
        l3.setTranslate_y(3);
        l3.setF_pos(31);
        l3.setPath(path9_31);
        lads.add(l3);

        Ladder l4 = new Ladder();
        l4.setPos(21);
        l4.setTranslate_X(1);
        l4.setTranslate_y(2);
        l4.setF_pos(42);
        l4.setPath(path21_42);
        lads.add(l4);

        Ladder l5 = new Ladder();
        l5.setPos(28);
        l5.setTranslate_X(-4);
        l5.setTranslate_y(6);
        l5.setF_pos(84);
        l5.setPath(path28_84);
        lads.add(l5);

        Ladder l6 = new Ladder();
        l6.setPos(36);
        l6.setTranslate_X(-1);
        l6.setTranslate_y(1);
        l6.setF_pos(44);
        l6.setPath(path36_44);
        lads.add(l6);

        Ladder l7 = new Ladder();
        l7.setPos(51);
        l7.setTranslate_X(-3);
        l7.setTranslate_y(1);
        l7.setF_pos(67);
        l7.setPath(path51_67);
        lads.add(l7);

        Ladder l8 = new Ladder();
        l8.setPos(71);
        l8.setTranslate_X(0);
        l8.setTranslate_y(2);
        l8.setF_pos(91);
        l8.setPath(path71_91);
        lads.add(l8);

        Ladder l9 = new Ladder();
        l9.setPos(80);
        l9.setTranslate_X(0);
        l9.setTranslate_y(2);
        l9.setF_pos(100);
        l9.setPath(path80_100);
        lads.add(l9);

        playTimer(1);
    }
}