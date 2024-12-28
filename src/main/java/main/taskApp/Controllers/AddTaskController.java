package main.taskApp.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.taskApp.database.Task;
import main.taskApp.database.TasksRepository;
import main.taskApp.service.UIlogic;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTaskController implements Initializable {
    Stage stage;
    static UIlogic uIlogic;
    public static void setUIlogic(UIlogic uilogic) {
        uIlogic = uilogic;
    }
    public void getStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private TextField dateField;

    @FXML
    private ComboBox<String> tagCombobox;

    @FXML
    private TextField taskNamefield;

    @FXML
    private TextField timeField;

    @FXML
    void addtask() {
        String taskName = taskNamefield.getText();
        String date = dateField.getText();
        String time = timeField.getText();
        String tag = tagCombobox.getValue();
        uIlogic.addpane(new Task(taskName, tag, date, time));
        TasksRepository.adddata(new Task(taskName, tag, date, time));
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tagCombobox.getItems().addAll("Work", "Personal", "Shopping", "Entertainment", "Medical", "Others","Default");
    }

}
