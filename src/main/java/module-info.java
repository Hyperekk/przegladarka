module com.bartt.przegladarka {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.bartt.przegladarka to javafx.fxml;
    exports com.bartt.przegladarka;
}