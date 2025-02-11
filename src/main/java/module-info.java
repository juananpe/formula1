module eus.ehu.formula1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires eus.ehu.presentation;

    opens eus.ehu.presentation to javafx.fxml;
    exports eus.ehu.presentation;
}