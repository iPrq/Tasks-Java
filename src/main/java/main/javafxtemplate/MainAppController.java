package main.javafxtemplate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainAppController {

    @FXML
    private Pane titlePane;
    private double x,y;


    public void init(Stage stage) {
        titlePane.setOnMousePressed(MouseEvent -> {
            x = MouseEvent.getSceneX();
            y = MouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(MouseEvent -> {
            stage.setX(MouseEvent.getScreenX() - x);
            stage.setY(MouseEvent.getScreenY() - y);
        });
    }

}