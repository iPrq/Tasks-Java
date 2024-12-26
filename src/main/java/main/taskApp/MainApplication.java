package main.taskApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.taskApp.service.UIlogic;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("TasksAppGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Tasks");
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("MainAppStyle.css")).toExternalForm());
        MainAppController controller = fxmlLoader.getController();
        controller.setConstructors(new UIlogic());
        stage.setScene(scene);
        stage.show();
        controller.init(stage);
    }

    public static void run() {
        launch();
    }
}