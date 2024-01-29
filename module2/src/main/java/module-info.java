module edu.au.cpsc.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.au.cpsc.demo to javafx.fxml;
    exports edu.au.cpsc.demo;
}