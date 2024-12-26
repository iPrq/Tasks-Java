package main.taskApp.service;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;


public class UIlogic {
    public Pane addpane() {
        Pane taskPane = new Pane();
        taskPane.setStyle("-fx-background-color: #00000026;");
        taskPane.setMinSize(557,48);
        taskPane.setMaxSize(557,48);
        taskPane.setPrefSize(557,48);
        Label taskNamelbl = new Label("Task 1");
        taskNamelbl.setMaxSize(239,26);
        taskNamelbl.setLayoutX(14);
        taskNamelbl.setLayoutY(10);
        StackPane tagPane = tagpane(0);
        Label datelbl = new Label("25/12/2024");
        datelbl.setMaxSize(79,26);
        datelbl.setMinSize(79,26);
        datelbl.setPrefSize(79,26);
        datelbl.setLayoutX(370);
        datelbl.setLayoutY(10);

        Label timelbl = new Label("12:12");
        timelbl.setMaxSize(79,26);
        timelbl.setMinSize(79,26);
        timelbl.setPrefSize(79,26);
        timelbl.setLayoutX(465);
        timelbl.setLayoutY(10);

        taskPane.getChildren().add(taskNamelbl);
        taskPane.getChildren().add(tagPane);
        taskPane.getChildren().add(datelbl);
        taskPane.getChildren().add(timelbl);
        return taskPane;
    }

    public StackPane tagpane(int type) {
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
            case 0:
                typePane.setStyle("-fx-background-color: green; -fx-background-radius: 15;");
                typeNamelbl.setText("Default");
                break;
        }
        return typePane;
    }
}
