package com.example.ap_project_snakesandladders;


import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Token {
    @FXML
    private ImageView token;

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
}
