package main.taskApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.taskApp.service.UIlogic;

import java.net.URL;
import java.util.ResourceBundle;

public class MainAppController  implements Initializable {

    private UIlogic uilogic;  //Do not Change
    public void setConstructors(UIlogic uilogic) {
        this.uilogic = uilogic;
    }

    @FXML
    private Pane titlePane;
    private double x,y;
    @FXML
    private VBox tasksVbox;
    @FXML
    private ScrollPane taskScrollpane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        taskScrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        taskScrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        tasksVbox.prefWidthProperty().bind(taskScrollpane.widthProperty());
    }

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
        tasksVbox.getChildren().add(uilogic.addpane());
    }
}