package de.hsrm.mi.swt.spass;

import java.util.HashMap;
import java.util.Map;

import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;
import de.hsrm.mi.swt.spass.gui.StudienplanViewController;
import de.hsrm.mi.swt.spass.gui.ViewController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    public enum Scenes{
        PLAN_SCENE, DETAIL_SCENE, MENU_SCENE
    };

    private Studienplaner studienplaner;

    private Stage stage;
    private Scene scene;
    private BorderPane root;
    private Map<Scenes, Pane> scenes;

    public static void main(String[] args){
        launch();
    }

    @Override
    public void init() throws Exception{
        scenes = new HashMap<>();
        root = new BorderPane();
        root.getStyleClass().add("root");
        scene = new Scene(root);

        studienplaner = new Studienplaner();

        ViewController viewController;
        viewController = new StudienplanViewController(this);
        
        scenes.put(Scenes.PLAN_SCENE, viewController.getRootView());

        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

    }

    @Override
    public void start(Stage stage) {

        this.stage = stage;
		stage.setTitle("Studienplaner");
		stage.setScene(scene);

		switchScene(Scenes.PLAN_SCENE);

		stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
			@Override
			public void handle(WindowEvent event) {
				exit();
			}
		});
		stage.show();
	}

	public void switchScene(Scenes toScene) {
		Scene scene = stage.getScene();

		if (scenes.containsKey(toScene)) {
			Platform.runLater(new Runnable() {
				public void run() {
					scene.setRoot(scenes.get(toScene));
				}
			});
			
		}
	}

	public Scene getScene() {
		return scene;
	}

	public void exit() {
		try {
			//this.studienplaner.save();
			Platform.exit();
			System.exit(0);

		} catch (Exception e) {
			System.out.println("App konnte nicht fachgerecht beendet werden.");
		}
	}

	public Stage getStage() {
		return stage;
	}

    public Studienplaner getStudienplaner(){
        return studienplaner;
    }

    
}
