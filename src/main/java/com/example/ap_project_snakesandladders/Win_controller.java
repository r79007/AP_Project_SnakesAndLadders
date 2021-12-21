package com.example.ap_project_snakesandladders;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Win_controller {
    @FXML
    private TextField win_text;

    @FXML
    private TextField lose_text;

    @FXML
    private ProgressBar progress;

    @FXML
    private ImageView downArrow;

    void display(String win,String lose) {
        win_text.setText(win);
        lose_text.setText(lose);
    }

}