module com.linesgui.lines {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.linesgui.lines to javafx.fxml;
    exports com.linesgui.lines;
}