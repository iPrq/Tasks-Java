package main.taskApp.service;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import main.taskApp.database.Task;
import main.taskApp.database.TasksRepository;


public class UIlogic {
    private final TasksRepository tasksRepository;
    Pane taskPane;

    public UIlogic(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public void addpane(Task task) {
        taskPane = new Pane();
        taskPane.setStyle("-fx-background-color: #00000026;");
        taskPane.setMinSize(564,48);
        taskPane.setMaxSize(564,48);
        taskPane.setPrefSize(564,48);

        Label taskNamelbl = new Label(task.taskname);
        taskNamelbl.setMaxSize(230,26);
        taskNamelbl.setMinSize(230,26);
        taskNamelbl.setPrefSize(230,26);
        taskNamelbl.setLayoutX(14);
        taskNamelbl.setLayoutY(10);
        StackPane tagPane = tagpane(task.type);

        Label datelbl = new Label(task.date);
        datelbl.setMaxSize(79,26);
        datelbl.setMinSize(79,26);
        datelbl.setPrefSize(79,26);
        datelbl.setLayoutX(370);
        datelbl.setLayoutY(10);

        Label timelbl = new Label(task.time);
        timelbl.setMaxSize(79,26);
        timelbl.setMinSize(79,26);
        timelbl.setPrefSize(79,26);
        timelbl.setLayoutX(465);
        timelbl.setLayoutY(10);
        taskPane.getChildren().add(taskNamelbl);
        taskPane.getChildren().add(tagPane);
        taskPane.getChildren().add(datelbl);
        taskPane.getChildren().add(timelbl);
    }

    public Pane getTaskPane() {
        return taskPane;
    }

    public StackPane tagpane(String type) {
        Label typeNamelbl = new Label();
        StackPane typePane = new StackPane();
        typePane.setMinSize(72,26);
        typePane.setPrefSize(72,26);
        typePane.setMaxSize(72,26);
        typePane.setLayoutX(265);
        typePane.setLayoutY(10);
        typePane.getChildren().add(typeNamelbl);
        typeNamelbl.setTextAlignment(TextAlignment.CENTER);
        typeNamelbl.setAlignment(Pos.CENTER);

        switch (type) {
            case "default":
                typePane.setStyle("-fx-background-color: green; -fx-background-radius: 15;");
                typeNamelbl.setText("Default");
                break;
        }
        return typePane;
    }
}
