package com.example.ap_project_snakesandladders;


import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Token {
    @FXML
    private ImageView token;
    private boolean status = false;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private double x_coordinate;
    private double y_coordinate;

    public ImageView getToken() {
        return this.token;
    }

    public void setToken(ImageView token) {
        this.token = token;
    }

    public double getX_coordinate() {
        return this.x_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public double getY_coordinate() {
        return this.y_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }



    public Token(ImageView token, double x_coordinate, double y_coordinate) {
        this.token = token;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }
}
