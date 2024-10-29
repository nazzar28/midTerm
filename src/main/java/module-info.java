module org.example.midterm {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.midterm to javafx.fxml;
    exports org.example.midterm;
}
