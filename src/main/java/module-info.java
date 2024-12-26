module main.taskApp {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.taskApp to javafx.fxml;
    exports main.taskApp;
    exports main.taskApp.service;
}