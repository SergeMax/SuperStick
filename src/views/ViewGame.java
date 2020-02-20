package views;

import controllers.ControllerGame;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;
import models.StickMan;

public class ViewGame {


    private Group root;
    private HBox boxBackground;
    private int compteurDefilement =0;
    private Timeline timelineDefilementRight = new Timeline();
    private Timeline timelineDefilementLeft = new Timeline();
    private StickMan stickMan;
    private ImageView imgStick;


    public ViewGame(Group root) {

        // root.setBackground(new Background( new BackgroundImage(new Image("assets/background/backgroundJeux.jpg"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        this.root = root;
        initBackgroundHbox();
        initStickMan();
        initTotalRoot();

    }

    public void setEvent(ControllerGame controllerGame) {


    }


    public void initStickMan(){

       stickMan = new StickMan("assets/gif/stickFatigue.gif");
       // System.out.println(stickMan);
       //imgStick = new ImageView("assets/gif/stickRun.gif");

    }

    public void initBackgroundHbox() {
        boxBackground = new HBox();
        boxBackground.setMinWidth(8500);
        boxBackground.setMinHeight(1400);
        BackgroundImage myBI = new BackgroundImage(new Image("assets/image/background/beton.jpg", 1400, 1400, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        boxBackground.setBackground(new Background(myBI));

    }

    public void initTotalRoot(){
        root.getChildren().clear();
        root.getChildren().add(boxBackground);
        root.getChildren().add(stickMan);


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

        timelineDefilementRight = new Timeline(defillementStart, defillementEnd);
        timelineDefilementRight.setCycleCount(1);

    }

    public void defilementLeft(int compteurDefilement) {
        int compteurDefilementEnd = compteurDefilement + 2000;

        final KeyFrame defillementStart = new KeyFrame(Duration.ZERO, new KeyValue(boxBackground.translateXProperty(), compteurDefilement));
        final KeyFrame defillementEnd = new KeyFrame(Duration.seconds(8), new KeyValue(boxBackground.translateXProperty(),compteurDefilementEnd ));

        timelineDefilementLeft = new Timeline(defillementStart, defillementEnd);
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
}
