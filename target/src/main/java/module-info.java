module javafxbase {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens javafxbase to javafx.fxml;
    exports modelo;
    exports javafxbase;
}
