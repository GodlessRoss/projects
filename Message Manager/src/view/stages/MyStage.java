package view.stages;

import java.util.List;

import javafx.scene.Scene;
import model.Aliases;

public abstract class MyStage extends javafx.stage.Stage {

	protected static Aliases alias;
	protected static List<Scene> listScene;

	public static Aliases getAlias() {
		if (alias != null) {
			return alias;
		} else {
			return Aliases.MAIN;
		}
	}

	abstract protected void initializeComponents();
	abstract protected void createScenes();
}
