package views;

import anim.Anim;
import controllers.ControllerGame;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
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
    private int compteurDefilement = 0;
    private Timeline timelineDefilementRight = new Timeline();
    private Timeline timelineDefilementLeft = new Timeline();
    private StickMan stickMan;
    private ImageView imgStick;
    private Drone drone1;
    private Anim anim = new Anim();
    private Group boxGroupPaysageEnemy;
    private Drone drone2;
    private ImageView logo;
    private Boolean valide;
    private int compteurPositonPlayer;
    private ImageView lifeText;
    private ImageView life;
    private ImageView p1;
    private ImageView p12;
    private Timeline timelineDrone1;
    private Timeline timelineDrone2;
    private boolean tirToucheD1 = true;
    private boolean tirToucheD2 = true;


    public ViewGame(Group root) {

        // root.setBackground(new Background( new BackgroundImage(new Image("assets/background/backgroundJeux.jpg"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.valide = false;
        this.root = root;
        initBackgroundHbox();
        initLogo();
        initLife();
        initGroupContainer();
        initStickMan();
        initEnemyAndPaysage();
        initBoxGroupPaysageEnemy();
        initTotalRoot();


        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(25),
                ae -> updatePositionPlayer()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


    }

    private void initGroupContainer() {
        boxGroupPaysageEnemy = new Group();
        boxGroupPaysageEnemy.minWidth(8500);
        boxGroupPaysageEnemy.minHeight(1050);
    }

    public void setEvent(ControllerGame controllerGame) {


    }

    public void initEnemyAndPaysage() {
        initDrone();
        initPaysage();
    }

    private void initPaysage() {

        p1 = new ImageView("assets/image/p1.png");
        p1.setY(340);
        p1.setFitWidth(1600);
        p1.setOpacity(0.3);
        p1.setPreserveRatio(true);

        p12 = new ImageView("assets/image/P12.png");
        p12.setY(340);
        p12.setFitWidth(1600);
        p12.setOpacity(0.7);
        p12.setPreserveRatio(true);

    }

    public void initDrone() {
        drone1 = new Drone("assets/image/enemy/drone.png", 1700, 200, 100);

        drone1.translateXProperty().addListener(checkIntersection);
        drone1.translateYProperty().addListener(checkIntersection);
        drone1.setPickOnBounds(false);
        timelineDrone1 = anim.animDrone(drone1, 0, -300, 0, -100, -200, 0, 200, 0);

        timelineDrone1.play();


        drone2 = new Drone("assets/image/enemy/drone.png", 2700, 100, 80);
        drone2.setRotate(30);
        drone2.setScaleX(-1);
        drone2.setPickOnBounds(false);

        timelineDrone2 = anim.animDrone(drone2, 0, 200, 300, 0, -50, 200, 500, 300);
timelineDrone2.play();
    }

    private final ChangeListener<Number> checkIntersection = (ob, n, n1)->{
        if (stickMan.getLayoutBounds().intersects(drone1.getLayoutBounds())){
            System.out.println("Intersection detected");
        }
    };


    public void initStickMan() {

        stickMan = new StickMan("assets/gif/stickFatigue.gif");
        // System.out.println(stickMan);
        //imgStick = new ImageView("assets/gif/stickRun.gif");
        stickMan.setPickOnBounds(false);



    }

    public void initLogo() {
        logo = new ImageView("assets/image/Super Stick.png");
        logo.setX(500);
        logo.setY(40);
        logo.setOpacity(0.55);
        logo.setFitWidth(500);
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

    public void initTotalRoot() {
        root.getChildren().clear();
        root.getChildren().add(boxBackground);
        root.getChildren().add(logo);
        root.getChildren().add(life);
        root.getChildren().add(lifeText);
        root.getChildren().add(boxGroupPaysageEnemy);
        root.getChildren().add(stickMan);
    }

    public void initBoxGroupPaysageEnemy() {
        boxGroupPaysageEnemy.getChildren().clear();
        boxGroupPaysageEnemy.getChildren().add(drone1);
        boxGroupPaysageEnemy.getChildren().add(drone2);
        boxGroupPaysageEnemy.getChildren().add(p1);
        boxGroupPaysageEnemy.getChildren().add(p12);

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
        final KeyFrame defillementEnd = new KeyFrame(Duration.seconds(32), new KeyValue(boxBackground.translateXProperty(), compteurDefilementEnd));

        final KeyFrame defillementBoxStart = new KeyFrame(Duration.ZERO, new KeyValue(boxGroupPaysageEnemy.translateXProperty(), compteurDefilement));
        final KeyFrame defillementBoxEnd = new KeyFrame(Duration.seconds(32), new KeyValue(boxGroupPaysageEnemy.translateXProperty(), compteurDefilementEnd));


        timelineDefilementRight = new Timeline(defillementStart, defillementBoxStart, defillementBoxEnd, defillementEnd);
        timelineDefilementRight.setCycleCount(1);

    }

    public void defilementLeft(int compteurDefilement) {
        int compteurDefilementEnd = compteurDefilement + 8000;

        final KeyFrame defillementStart = new KeyFrame(Duration.ZERO, new KeyValue(boxBackground.translateXProperty(), compteurDefilement));
        final KeyFrame defillementEnd = new KeyFrame(Duration.seconds(32), new KeyValue(boxBackground.translateXProperty(), compteurDefilementEnd));

        final KeyFrame defillementBoxStart = new KeyFrame(Duration.ZERO, new KeyValue(boxGroupPaysageEnemy.translateXProperty(), compteurDefilement));
        final KeyFrame defillementBoxEnd = new KeyFrame(Duration.seconds(32), new KeyValue(boxGroupPaysageEnemy.translateXProperty(), compteurDefilementEnd));


        timelineDefilementLeft = new Timeline(defillementStart, defillementBoxStart, defillementBoxEnd, defillementEnd);
        timelineDefilementLeft.setCycleCount(1);
    }


    public void initLife() {
        life = new ImageView("assets/image/life.png");
        life.setX(900);
        life.setY(40);
        life.setOpacity(0);

        lifeText = new ImageView("assets/image/lifeLabel.png");
        lifeText.setFitWidth(150);
        lifeText.setPreserveRatio(true);
        lifeText.setTranslateX(650);
        lifeText.setTranslateY(40);
        lifeText.setOpacity(0);

    }

    public Timeline getTimelineDefilementRight() {
        return timelineDefilementRight;
    }


    private void updatePositionPlayer() {

        compteurPositonPlayer = boxBackground.translateXProperty().intValue();

        if (valide == false) {
            System.out.println("ok2");


            if (compteurPositonPlayer <= -300) {
                valide = true;
                System.out.println("ok3");
                final KeyFrame logotStart = new KeyFrame(Duration.ZERO, new KeyValue(logo.xProperty(), 500));
                final KeyFrame logoEnd = new KeyFrame(Duration.seconds(1), new KeyValue(logo.xProperty(), 50));

                final KeyFrame logotWStart = new KeyFrame(Duration.ZERO, new KeyValue(logo.fitWidthProperty(), 500));
                final KeyFrame logoWEnd = new KeyFrame(Duration.seconds(1), new KeyValue(logo.fitWidthProperty(), 250));

                Timeline timelineLogo = new Timeline(logotStart, logoEnd, logotWStart, logoWEnd);
                timelineLogo.setCycleCount(1);
                timelineLogo.play();

                final KeyFrame opacity = new KeyFrame(Duration.seconds(1), new KeyValue(life.opacityProperty(), 0));
                final KeyFrame opacityEnd = new KeyFrame(Duration.seconds(3), new KeyValue(life.opacityProperty(), 1));

                final KeyFrame opacityLifeText = new KeyFrame(Duration.seconds(1), new KeyValue(lifeText.opacityProperty(), 0));
                final KeyFrame opacityLifeTextEnd = new KeyFrame(Duration.seconds(3), new KeyValue(lifeText.opacityProperty(), 1));

                Timeline timelineOpacity = new Timeline(opacity, opacityEnd, opacityLifeText, opacityLifeTextEnd);
                timelineOpacity.setCycleCount(1);
                timelineOpacity.play();


            }
        }

        if (stickMan.intersects(
                stickMan.sceneToLocal(drone1.localToScene(
                        drone1.getBoundsInLocal())))) {
            stickMan.getAni().getTimelineJump().stop();
            stickMan.getAni().getTimelineJumpBackToGround().play();


            final KeyFrame stickManOpacity = new KeyFrame(Duration.ZERO, new KeyValue(stickMan.opacityProperty(), 2));
            final KeyFrame stickManOpacityEnd = new KeyFrame(Duration.seconds(0.2), new KeyValue(stickMan.opacityProperty(), 0));

            Timeline timelineOpacity = new Timeline(stickManOpacity, stickManOpacityEnd);
            timelineOpacity.setAutoReverse(true);
            timelineOpacity.setCycleCount(10);
            timelineOpacity.play();

           // PauseTransition delayRemoveTir = new PauseTransition(Duration.seconds(10));
           // delayRemoveTir.setOnFinished(event -> {
            //  timelineOpacity.stop();
            //});
            //delayRemoveTir.play();



        }

        if (stickMan.intersects(
                stickMan.sceneToLocal(drone2.localToScene(
                        drone2.getBoundsInLocal())))) {
            stickMan.getAni().getTimelineJump().stop();
            stickMan.getAni().getTimelineJumpBackToGround().play();


            final KeyFrame stickManOpacity = new KeyFrame(Duration.ZERO, new KeyValue(stickMan.opacityProperty(), 2));
            final KeyFrame stickManOpacityEnd = new KeyFrame(Duration.seconds(0.2), new KeyValue(stickMan.opacityProperty(), 0));

            Timeline timelineOpacity = new Timeline(stickManOpacity, stickManOpacityEnd);
            timelineOpacity.setAutoReverse(true);
            timelineOpacity.setCycleCount(10);
            timelineOpacity.play();
        }

        if (stickMan.getLaserYeux().intersects(
                stickMan.getLaserYeux().sceneToLocal(drone2.localToScene(
                        drone2.getBoundsInLocal())))) {


            if (tirToucheD1 == true){
            tirToucheD1 = false;
            timelineDrone2.stop();
            Image explo = new Image("assets/image/explosion/source.gif");
            PauseTransition delayRemoveTir = new PauseTransition(Duration.seconds(3));
             delayRemoveTir.setOnFinished(event -> {
              boxGroupPaysageEnemy.getChildren().remove(drone2);
            });
            delayRemoveTir.play();

            drone2.setImage(explo);
            drone2.setFitWidth(200);}
        }

        if (stickMan.getLaserYeux().intersects(
                stickMan.getLaserYeux().sceneToLocal(drone1.localToScene(
                        drone1.getBoundsInLocal())))) {

            if (tirToucheD2 == true) {
                tirToucheD2 = false;
                timelineDrone1.stop();

                Image explo = new Image("assets/image/explosion/source.gif");

                PauseTransition delayRemoveTir = new PauseTransition(Duration.seconds(3));
                delayRemoveTir.setOnFinished(event -> {
                    boxGroupPaysageEnemy.getChildren().remove(drone1);
                });
                delayRemoveTir.play();

                drone1.setImage(explo);
                drone1.setFitWidth(200);


            }

        }


    }







    public int getCompteurDefilement() {


        compteurDefilement = boxBackground.translateXProperty().intValue();
        System.out.println("ok");

        return compteurDefilement;
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
