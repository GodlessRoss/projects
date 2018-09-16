package view.stages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Aliases;

public class LoggSt extends view.stages.MyStage {

	private static final Aliases alias = Aliases.LOGGER;

	private Scene scene;

	private VBox box;

	private Label infoLb;

	private Button okBtn;
	private Button cancelBtn;
	private Button regBtn;

	private TextField logEdit;
	private TextField passEdit;

	{
		setTitle("Вход в систему");
		setWidth(300);
		setHeight(500);
		createScenes();
		setScene(scene);
	}

	@Override
	protected void initializeComponents() {
		box = new VBox(30);

		okBtn = new Button("Войти");
		cancelBtn = new Button("Отмена");
		regBtn = new Button("Зарегистрироваться");

		logEdit = new TextField();
		passEdit = new TextField();

		infoLb = new Label();
	}

	@Override
	protected void createScenes() {
		initializeComponents();
		box.getChildren().addAll(logEdit, passEdit, okBtn, cancelBtn, regBtn, infoLb);
		scene = new Scene(box);
	}

}
