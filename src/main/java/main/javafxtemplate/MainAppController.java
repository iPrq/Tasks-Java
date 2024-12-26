package main.javafxtemplate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainAppController {

    @FXML
    private Pane titlePane;
    private double x,y;
    @FXML
    private VBox tasksVbox;

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

    @FXML
    private void newtask() {
        Pane taskPane = new Pane();
        taskPane.setStyle("-fx-background-color: #00000026;");
        taskPane.setMinSize(537,49);
        taskPane.setMaxSize(537,49);
        tasksVbox.getChildren().add(taskPane);
    }

}