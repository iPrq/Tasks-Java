module main.taskApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens main.taskApp to javafx.fxml;
    exports main.taskApp;
    exports main.taskApp.service;
    exports main.taskApp.database;
    exports main.taskApp.Controllers;
    opens main.taskApp.Controllers to javafx.fxml;
}