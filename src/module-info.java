module ZelineProjectServices {
		requires javafx.controls;	
		requires javafx.fxml;
		requires java.sql;
		requires java.desktop;
		requires javafx.graphics;
		opens application to javafx.graphics, javafx.fxml;
		opens Page1 to javafx.graphics, javafx.fxml;
		opens Page2 to javafx.graphics,javafx.fxml;
		opens Page3 to javafx.graphics,javafx.fxml;
		opens Page4 to javafx.graphics,javafx.fxml;
		opens Page5 to javafx.graphics,javafx.fxml;
		opens Page6 to javafx.graphics,javafx.fxml;
		opens Page7 to javafx.graphics,javafx.fxml;
		opens Page8 to javafx.graphics,javafx.fxml;
		opens Page9 to javafx.graphics,javafx.fxml;
		opens Pagez10 to javafx.graphics,javafx.fxml;

}
