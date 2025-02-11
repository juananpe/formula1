module eus.ehu.formula1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens eus.ehu.domain to org.hibernate.orm.core;
    opens eus.ehu.presentation to javafx.fxml;
    exports eus.ehu.presentation;
}