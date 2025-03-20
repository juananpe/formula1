module eus.ehu.formula1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires com.h2database;
    requires javafx.graphics;

    opens eus.ehu.domain to org.hibernate.orm.core, javafx.base;
    opens eus.ehu.presentation to javafx.fxml;
    exports eus.ehu.presentation;
}