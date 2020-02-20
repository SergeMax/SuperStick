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

public class ViewGame {


    private Group root;
    private HBox boxBackground;
    private int compteurDefilement =0;
    private Timeline timelineDefilement;


    public ViewGame(Group root) {

        // root.setBackground(new Background( new BackgroundImage(new Image("assets/background/backgroundJeux.jpg"), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        this.root = root;
        initBackgroundHbox();


    }

    public void setEvent(ControllerGame controllerGame) {


    }

    public void initBackgroundHbox() {
        boxBackground = new HBox();
        boxBackground.setMinWidth(8500);
        boxBackground.setMinHeight(1400);
        BackgroundImage myBI = new BackgroundImage(new Image("assets/image/background/beton.jpg", 1400, 1400, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        boxBackground.setBackground(new Background(myBI));
        root.getChildren().add(boxBackground);

    }

    void setEvents(ControllerGame cj) {

        root.getScene().setOnKeyPressed(cj);
        root.getScene().setOnKeyReleased(cj);
    }

    public HBox getBoxBackground() {
        return boxBackground;
    }

    public void defilement(int i) {
        int compteurDefilementEnd = compteurDefilement - 1000;
       // boxBackground.setTranslateX(compteurDefilement);
        final KeyFrame defillementStart = new KeyFrame(Duration.ZERO, new KeyValue(boxBackground.translateXProperty(), compteurDefilement));
        //compteurDefilement = compteurDefilement-1000;

        final KeyFrame defillementEnd = new KeyFrame(Duration.seconds(4), new KeyValue(boxBackground.translateXProperty(),compteurDefilementEnd ));

   //     final KeyFrame goLeftStartFace = new KeyFrame(Duration.ZERO, new KeyValue(vaissJ1Face.xProperty(), vaissJ1Face.getX()));
     //   final KeyFrame goLeftEndFace = new KeyFrame(Duration.seconds(0.5), new KeyValue(vaissJ1Face.xProperty(), 800));

        timelineDefilement = new Timeline(defillementStart, defillementEnd);
        timelineDefilement.setCycleCount(1);

    }

    public Timeline getTimelineDefilement() {
        return timelineDefilement;
    }

    public int getCompteurDefilement() {
        compteurDefilement = boxBackground.translateXProperty().intValue();
        return  compteurDefilement ;
    }

    public void setCompteurDefilement(int compteurDefilement) {
        this.compteurDefilement = compteurDefilement;
    }
}
