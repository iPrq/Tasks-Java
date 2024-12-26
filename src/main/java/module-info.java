module main.javafxtemplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.javafxtemplate to javafx.fxml;
    exports main.javafxtemplate;
}