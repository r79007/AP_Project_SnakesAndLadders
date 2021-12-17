package com.example.ap_project_snakesandladders;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Light;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    static ArrayList<Snake> snakes = new ArrayList<>();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        System.out.println("hello\n");
        //Token red = new Token();
    }

    public static void main(String[] args) {
//        Ladder l1 = new Ladder();
//        l1.setPos(1);
//        l1.setTranslate_X(2);
//        l1.setTranslate_y(3);
//        l1.setF_pos(38);
//        //l1.setPath(path1_38);
//        lads.add(l1);
//
//        Ladder l2 = new Ladder();
//        l2.setPos(4);
//        l2.setTranslate_X(3);
//        l2.setTranslate_y(1);
//        l2.setF_pos(14);
//        //l1.setPath(path4_14);
//        lads.add(l2);
//
//        Ladder l3 = new Ladder();
//        l3.setPos(9);
//        l3.setTranslate_X(1);
//        l3.setTranslate_y(3);
//        l3.setF_pos(31);
//        //l3.setPath(path9_31);
//        lads.add(l3);
//
//        Ladder l4 = new Ladder();
//        l4.setPos(21);
//        l4.setTranslate_X(1);
//        l4.setTranslate_y(2);
//        l4.setF_pos(42);
//        //l4.setPath(path21_42);
//        lads.add(l4);
//
//        Ladder l5 = new Ladder();
//        l5.setPos(28);
//        l5.setTranslate_X(-4);
//        l5.setTranslate_y(6);
//        l5.setF_pos(84);
//        //l5.setPath(path28_84);
//        lads.add(l5);
//
//        Ladder l6 = new Ladder();
//        l6.setPos(36);
//        l6.setTranslate_X(-1);
//        l6.setTranslate_y(1);
//        l6.setF_pos(44);
//        //l6.setPath(path36_44);
//        lads.add(l6);
//
//        Ladder l7 = new Ladder();
//        l7.setPos(51);
//        l7.setTranslate_X(-3);
//        l7.setTranslate_y(1);
//        l7.setF_pos(67);
//        //l7.setPath(path51_67);
//        lads.add(l7);
//
//        Ladder l8 = new Ladder();
//        l8.setPos(71);
//        l8.setTranslate_X(0);
//        l8.setTranslate_y(2);
//        l8.setF_pos(91);
//        //l8.setPath(path71_91);
//        lads.add(l8);
//
//        Ladder l9 = new Ladder();
//        l9.setPos(80);
//        l9.setTranslate_X(0);
//        l9.setTranslate_y(2);
//        l9.setF_pos(100);
//        //l9.setPath(path80_100);
//        lads.add(l9);

        Snake s1 = new Snake();
        s1.setF_pos(6);
        s1.setPos(16);
        s1.setTranslate_X(1);
        s1.setTranslate_y(-1);
        snakes.add(s1);

        Snake s2 = new Snake();
        s2.setF_pos(26);
        s2.setPos(47);
        s2.setTranslate_X(-1);
        s2.setTranslate_y(-2);
        snakes.add(s2);

        Snake s3 = new Snake();
        s3.setF_pos(11);
        s3.setPos(49);
        s3.setTranslate_X(1);
        s3.setTranslate_y(-3);
        snakes.add(s3);

        Snake s4 = new Snake();
        s4.setF_pos(53);
        s4.setPos(56);
        s4.setTranslate_X(3);
        s4.setTranslate_y(0);
        snakes.add(s4);

        Snake s5 = new Snake();
        s5.setF_pos(60);
        s5.setPos(64);
        s5.setTranslate_X(-3);
        s5.setTranslate_y(-1);
        snakes.add(s5);

        Snake s6 = new Snake();
        s5.setF_pos(24);
        s5.setPos(87);
        s5.setTranslate_X(-3);
        s5.setTranslate_y(-6);
        snakes.add(s6);

        Snake s7 = new Snake();
        s7.setF_pos(73);
        s7.setPos(93);
        s7.setTranslate_X(0);
        s7.setTranslate_y(-2);
        snakes.add(s7);

        Snake s8 = new Snake();
        s8.setF_pos(75);
        s8.setPos(95);
        s8.setTranslate_X(0);
        s8.setTranslate_y(-2);
        snakes.add(s8);

        Snake s9 = new Snake();
        s9.setF_pos(78);
        s9.setPos(98);
        s9.setTranslate_X(0);
        s9.setTranslate_y(-2);
        snakes.add(s9);

        launch();
    }
}

//TODO: make a parent class for ladder and snake classes.