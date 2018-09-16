package view;

import javafx.application.Application;
import javafx.stage.Stage;
import view.stages.LoggSt;
import view.stages.MainSt;

public class Runnable extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		view.stages.MyStage st = new LoggSt();
		st.show();
	}

}
