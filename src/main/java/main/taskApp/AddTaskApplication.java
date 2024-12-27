package main.taskApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.taskApp.Controllers.AddTaskController;

import java.io.IOException;

public class AddTaskApplication {
    public static void addTaskStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AddTaskApplication.class.getResource("AddTaskGUI.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Add Task");
        stage.setScene(scene);
        AddTaskController controller = fxmlLoader.getController();
        controller.getStage(stage);
        stage.showAndWait();
    }
}
