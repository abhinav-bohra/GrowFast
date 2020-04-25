module Example {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql;
    requires java.desktop;
	
	opens application;
    opens Employee;
    opens HumanResource;
} 