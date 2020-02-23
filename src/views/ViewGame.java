package views;

import anim.Anim;
import controllers.ControllerGame;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;
import models.Enemy.Drone;
import models.StickMan;

public class ViewGame {


    private Group root;
    private HBox boxBackground;
    private int compteurDefilement =0;
    private Timeline timelineDefilementRight = new Timeline();
    private Timeline timelineDefilementLeft = new Timeline();
    private StickMan stickMan;
    private ImageView imgStick;
    private Drone drone1;
    private Anim anim = new Anim();
    private Group boxGroupPaysageEnemy;
    private Drone drone2;
    private ImageView logo;


    public ViewGame(Group root) {

        // root.setBackground(new Background( new BackgroundImage(new Image("assets/background/backgroundJeux.jpg"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        this.root = root;
        initBackgroundHbox();
        initLogo();
        initGroupContainer();
        initStickMan();
        initEnemy();
        initBoxGroupPaysageEnemy();
        initTotalRoot();

    }

    private void initGroupContainer() {
        boxGroupPaysageEnemy = new Group();
        boxGroupPaysageEnemy.minWidth(8500);
        boxGroupPaysageEnemy.minHeight(1050);
    }

    public void setEvent(ControllerGame controllerGame) {


    }

    public void initEnemy(){
        initDrone();
    }

    public void initDrone(){
        drone1 = new Drone("assets/image/enemy/drone.png", 800, 200, 100);
        anim.animDrone(drone1, 0, -300, 0, -100, -200, 0, 200, 0  );

        drone2 = new Drone("assets/image/enemy/drone.png", 1700, 100, 80);
        drone2.setRotate(30);
        drone2.setScaleX(-1);
        anim.animDrone(drone2, 0, 200, 300, 0, -50, 200, 500, 300  );

    }


    public void initStickMan(){

       stickMan = new StickMan("assets/gif/stickFatigue.gif");
       // System.out.println(stickMan);
       //imgStick = new ImageView("assets/gif/stickRun.gif");

    }

    public void initLogo(){
        logo = new ImageView("assets/image/Super Stick.png");
        logo.setX(580);
        logo.setY(30);
        logo.setOpacity(0.55);
        logo.setFitWidth(300);
        logo.setPreserveRatio(true);
    }

    public void initBackgroundHbox() {
        boxBackground = new HBox();
        boxBackground.setMinWidth(8500);
        boxBackground.setMinHeight(1050);
        BackgroundImage myBI = new BackgroundImage(new Image("assets/image/background/beton.jpg", 1400, 1050, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        boxBackground.setBackground(new Background(myBI));

    }

    public void initTotalRoot(){
        root.getChildren().clear();
        root.getChildren().add(boxBackground);
        root.getChildren().add(logo);
        root.getChildren().add(boxGroupPaysageEnemy);
        root.getChildren().add(stickMan);
    }

    public void initBoxGroupPaysageEnemy(){
        boxGroupPaysageEnemy.getChildren().clear();
        boxGroupPaysageEnemy.getChildren().add(drone1);
        boxGroupPaysageEnemy.getChildren().add(drone2);

    }

    void setEvents(ControllerGame cj) {

        root.getScene().setOnKeyPressed(cj);
        root.getScene().setOnKeyReleased(cj);
    }

    public HBox getBoxBackground() {
        return boxBackground;
    }

    public void defilementRight(int i) {
        int compteurDefilementEnd = compteurDefilement - 8000;

        final KeyFrame defillementStart = new KeyFrame(Duration.ZERO, new KeyValue(boxBackground.translateXProperty(), compteurDefilement));
        final KeyFrame defillementEnd = new KeyFrame(Duration.seconds(32), new KeyValue(boxBackground.translateXProperty(),compteurDefilementEnd ));

        final KeyFrame defillementBoxStart = new KeyFrame(Duration.ZERO, new KeyValue(boxGroupPaysageEnemy.translateXProperty(), compteurDefilement));
        final KeyFrame defillementBoxEnd = new KeyFrame(Duration.seconds(32), new KeyValue(boxGroupPaysageEnemy.translateXProperty(),compteurDefilementEnd ));


        timelineDefilementRight = new Timeline(defillementStart, defillementBoxStart, defillementBoxEnd, defillementEnd);
        timelineDefilementRight.setCycleCount(1);

    }

    public void defilementLeft(int compteurDefilement) {
        int compteurDefilementEnd = compteurDefilement + 8000;

        final KeyFrame defillementStart = new KeyFrame(Duration.ZERO, new KeyValue(boxBackground.translateXProperty(), compteurDefilement));
        final KeyFrame defillementEnd = new KeyFrame(Duration.seconds(32), new KeyValue(boxBackground.translateXProperty(),compteurDefilementEnd ));

        final KeyFrame defillementBoxStart = new KeyFrame(Duration.ZERO, new KeyValue(boxGroupPaysageEnemy.translateXProperty(), compteurDefilement));
        final KeyFrame defillementBoxEnd = new KeyFrame(Duration.seconds(32), new KeyValue(boxGroupPaysageEnemy.translateXProperty(),compteurDefilementEnd ));


        timelineDefilementLeft = new Timeline(defillementStart, defillementBoxStart, defillementBoxEnd, defillementEnd);
        timelineDefilementLeft.setCycleCount(1);
    }

    public Timeline getTimelineDefilementRight() {
        return timelineDefilementRight;
    }

    public int getCompteurDefilement() {
        compteurDefilement = boxBackground.translateXProperty().intValue();
        return  compteurDefilement ;
    }

    public void setCompteurDefilement(int compteurDefilement) {
        this.compteurDefilement = compteurDefilement;
    }

    public Timeline getTimelineDefilementLeft() {
        return timelineDefilementLeft;
    }

    public StickMan getStickMan() {
        return stickMan;
    }

    public Group getRoot() {
        return root;
    }
}
