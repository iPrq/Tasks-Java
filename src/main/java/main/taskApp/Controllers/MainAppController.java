package main.taskApp.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.taskApp.AddTaskApplication;
import main.taskApp.database.TasksRepository;
import main.taskApp.service.UIlogic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainAppController  implements Initializable {

    private UIlogic uilogic;//Do not Change
    private TasksRepository tasksRepository;//Do not Change

    public void setConstructors(UIlogic uilogic, TasksRepository tasksRepository) {
        this.uilogic = uilogic;
        this.tasksRepository = tasksRepository;
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
        tasksVbox.setSpacing(2);
    }

    public void init(Stage stage) {
        tasksRepository.createdatabase();
        if (tasksRepository.returndata() != null) {

        }
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
        try {
            AddTaskController.setUIlogic(uilogic);
            AddTaskApplication.addTaskStage();
            tasksVbox.getChildren().add(uilogic.getTaskPane());

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}