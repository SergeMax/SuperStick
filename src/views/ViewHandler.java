package views;


import controllers.ControllerGame;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.w3c.dom.html.HTMLScriptElement;

public class ViewHandler extends Application {
    private Scene scene;
    private Group root;
   // private ViewMenuPrincipal viewMenuPrincipal;
    private ViewGame viewGame;
    //private ControllerMenuPrincipal controllerMenuPrincipal;
    private ControllerGame controllerGame;
    private BorderPane rootGame;


    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Group();
       // rootGame = new BorderPane();

        scene = new Scene(root, 8500, 1400);


     //  scene.getStylesheets().add("../assets/css/styles.css");

        showGame();
        /** ON EDITE LA SCENE */
        primaryStage.setTitle("Super Stick");
        //primaryStage.setFullScreenExitHint("");
       primaryStage.setFullScreen(true);
        //primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);

        //primaryStage.setResizable(false);
        primaryStage.show();





    }


    public void showMainMenu() {
      //  viewMenuPrincipal = new ViewMenuPrincipal(root);
        //viewMenuPrincipal.clearAndInitRoot();
        //controllerMenuPrincipal = new ControllerMenuPrincipal(this);
    }

    public void showGame() {
        scene.setRoot(root);
        viewGame = new ViewGame(root);
        controllerGame = new ControllerGame(this);

       // viewJeu.clearAndInitRoot();
    }



    public ViewGame getViewGame() {
        return viewGame;
    }

    public void setEventHandlerGame(ControllerGame controllerGame) {
        viewGame.setEvents(controllerGame);
    }
}
