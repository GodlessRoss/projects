package view.stages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Aliases;

public class MainSt extends view.stages.MyStage {

	private static final Aliases alias = Aliases.MAIN;	
	
	private Scene scene;
	
	private HBox box;
	private VBox chatsBx;
	private VBox contactsBx;
	
	private Label infoLb;

	private Button okBtn;
	private Button cancelBtn;
	private Button regBtn;

	private TextField logEdit;
	private TextField passEdit;
	
	{
		setTitle("Чаты");
		setWidth(450);
		setHeight(500);
//		Scene temp = createScene();
//		setScene(temp);
	}
	
	@Override
	protected void initializeComponents() {
//		box = new VBox(10);
		
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
