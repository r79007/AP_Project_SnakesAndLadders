package com.example.ap_project_snakesandladders;
import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.print.attribute.standard.RequestingUserName;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class HelloController implements Initializable {

    @FXML
    private Button but3;

    @FXML
    private Label win_text;

    @FXML
    private Label lose_text;

    @FXML
    private Label text3;

    @FXML
    private static MediaPlayer mediaPlayer;


    private static ArrayList<Ladder> lads = new ArrayList<>();
    private static ArrayList<Snake> snakes = new ArrayList<>();

    public static ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public static ArrayList<Ladder> getLads() {
        return lads;
    }
    @FXML
    private AnchorPane main_screen;
    @FXML
    private Group win_scene_2;
    @FXML
    private Polyline line87_24_1;
    @FXML
    private Polyline line87_24_2;
    @FXML
    private Polyline line87_24_3;
    @FXML
    private Polyline line16_6_1;
    @FXML
    private Polyline line16_6_2;
    @FXML
    private Polyline line49_11_1;

    @FXML
    private Polyline line47_26_1;
    @FXML
    private Polyline line47_26_2;
    @FXML
    private Polyline line56_53_1;
    @FXML
    private Polyline line62_19_1;
    @FXML
    private Polyline line62_19_2;
    @FXML
    private Polyline line62_19_3;
    @FXML
    private Polyline line64_60_1;
    @FXML
    private Polyline line93_73_1;
    @FXML
    private Polyline line95_75_1;
    @FXML
    private Polyline line98_78_1;

    @FXML
    private Line path1_38;
    //HelloApplication.lads.get(0)
    @FXML
    private Line path4_14;
    @FXML
    private Line path9_31;
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
    @FXML
    private static Stage stage;

    private static int delay=-1;

    public static int getDelay() {
        return delay;
    }

    public static void setDelay(int delay) {
        HelloController.delay = delay;
    }

    private Token redToken = new Token(redDie,0,0,"Player1");
    private Token greenToken = new Token(greenDie,0,0,"Player2");
    private Player P1 = new Player("Player1",redToken);
    private Player P2 = new Player("Player2",greenToken);

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

    private double desx;
    private double desy;

    @FXML
    private ImageView rollingDice;



    @FXML
    private ImageView downArrow;

    @FXML
    private ImageView bottomBarLeft;

    @FXML
    private ImageView bottomBarRight;

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
//        Timeline timeline1 = new Timeline(
//                new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 1)),
//                new KeyFrame(Duration.seconds(15), e-> {
//
//                }, new KeyValue(progress.progressProperty(), 0))
//        );
        //timeline.stop();
        Thread th1=new Thread(new Runnable() {
            @Override
            public void run() {
                //rollingDice.setVisible(true);
                i2++;
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        playAudio("/diceRollA.mp3");
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
                //move() moved from here
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        try {

                            move();
                            playTimer(-1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //timeline1.play();
                        int dur;
                        if(delay!=-1){
                            dur=delay;
                        }else{
                            dur=100*number;
                        }
                        delay=-1;
                        //System.out.println(dur);
                    Timeline timeline9= new Timeline(new KeyFrame(Duration.millis(dur),event1 -> {
                        playTimer(1);
                        downArrow.setVisible(true);
                        if(bottomBarLeft.isVisible()==false){
                            System.out.println("In first");
                            //Token.setN(0);
                            bottomBarRight.setVisible(false);
                            bottomBarLeft.setVisible(true);
                        }
                        else{
                            System.out.println("In second");
                            //Token.setN(1);
                            bottomBarLeft.setVisible(false);
                            bottomBarRight.setVisible(true);
                        }
                    }));

                    timeline9.play();

                    }
                });
            }
        });


        th1.start();
        //th1.join(2000);
        th2.start();

    }



    void playTimer(int option){
        //downArrow.setVisible(true);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 1)),
                new KeyFrame(Duration.seconds(15), e-> {

                }, new KeyValue(progress.progressProperty(), 0))
        );
        if(option>0) {
            timeline.play();
        }else{
            timeline.pause();
        }
        //downArrow.setVisible(false);
    }

    public static void playAudio(String name) {
//        String path = getClass().getResource(name).getPath();
//        Media media = new Media(new File(path).toURI().toString());
//        mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//        mediaPlayer.play();
        System.out.println("In audio");
        URL resource = HelloController.class.getResource(name);
        mediaPlayer = new MediaPlayer(new Media(resource.toString()));
        //}
        //mediaPlayer.setCycleCount(1);
        mediaPlayer.play();
    }

    static void switchToScene1() throws IOException {
        //Parent root= FXMLLoader.load(getClass().getResource("win_scene.fxml"));
        //stage = (Stage)((Node)getSource()).getScene().getWindow();
//        if(main_screen != null){ main_screen.getPrefHeight()
//            TranslateTransition translate = new TranslateTransition(Duration.millis(1000),win_scene);
//            translate.setToY((651+200)/2);
//            translate.play();
//        }
            //main_screen.setOpacity(0.5);
            //win_scene_2.setVisible(true);

//        TranslateTransition translate = new TranslateTransition(Duration.millis(1000),win_scene);
//        translate.setToY((651+ ((Node)win_scene).getBoundsInLocal().getWidth())/2);
//        translate.play();

//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("win_scene.fxml"));
//        Scene scene = new Scene(root);

//        win_text.setText("Player 1");
//        lose_text.setText("Player 2");
        //scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();

//
//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("win_scene.fxml"));
//        Scene scene = new Scene(root);
//        //scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
//    boolean redstart = false;
//    boolean greenstart = false;

    boolean start = false;
    int i=0;
    public void move() throws InterruptedException {
        Token.move(redToken,greenToken,number,redDie,greenDie,win_scene_2,main_screen,win_text,lose_text,text3,P1,P2);
//        if(number == 1 && start == false){
//            start = true;
//            Token.move(redToken,greenToken,number,redDie,greenDie);
//        }
//        else{
//
//        }
//        Token.move(redToken,greenToken,87-number,redDie,greenDie);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        redToken.setX_coordinate(99);
//        redToken.setStatus(true);
        //progress.setStyle("-fx-background-color: darkslateblue;-fx-accent: rgba(0, 138, 230, 0.85);");
        Snake s1 = new Snake();
        s1.setF_pos(6);
        s1.setPos(16);
        s1.setLines(line16_6_1);
        s1.setLines(line16_6_2);
        snakes.add(s1);

        Snake s2 = new Snake();
        s2.setF_pos(26);
        s2.setPos(47);
        s2.setLines(line47_26_1);
        s2.setLines(line47_26_2);
        snakes.add(s2);

        Snake s3 = new Snake();
        s3.setF_pos(11);
        s3.setPos(49);
        s3.setLines(line49_11_1);
        snakes.add(s3);

        Snake s4 = new Snake();
        s4.setF_pos(53);
        s4.setPos(56);
        s4.setLines(line56_53_1);
        snakes.add(s4);

        Snake s5 = new Snake();
        s5.setF_pos(60);
        s5.setPos(64);
        s5.setLines(line64_60_1);
        snakes.add(s5);


        Snake s6 = new Snake();
        s6.setF_pos(24);
        s6.setPos(87);
        s6.setLines(line87_24_1);
        s6.setLines(line87_24_2);
        s6.setLines(line87_24_3);
        snakes.add(s6);

        Snake s7 = new Snake();
        s7.setF_pos(73);
        s7.setPos(93);
        s7.setLines(line93_73_1);
        snakes.add(s7);

        Snake s8 = new Snake();
        s8.setF_pos(75);
        s8.setPos(95);
        s8.setLines(line95_75_1);
        snakes.add(s8);

        Snake s9 = new Snake();
        s9.setF_pos(78);
        s9.setPos(98);
        s9.setLines(line98_78_1);
        snakes.add(s9);

        Snake s10 = new Snake();
        s10.setF_pos(19);
        s10.setPos(62);s10.setLines(line62_19_1);
        s10.setLines(line62_19_2);
        s10.setLines(line62_19_3);
        snakes.add(s10);


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
        downArrow.setVisible(true);

    }
}