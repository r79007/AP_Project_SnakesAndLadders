package com.example.ap_project_snakesandladders;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    public void switchToScene1() throws IOException {
        //Parent root= FXMLLoader.load(getClass().getResource("win_scene.fxml"));
        //stage = (Stage)((Node)getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("win_scene.fxml"));
        Scene scene = new Scene(root);
        //scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
