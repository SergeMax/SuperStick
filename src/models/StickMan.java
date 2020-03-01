package models;


import anim.Anim;
import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class StickMan extends ImageView{


    private final Pane stickManPane;
    private Anim ani = new Anim();
    private PauseTransition delaySetStickManFall = new PauseTransition();
    private ImageView laserYeux = null;
    private String statuStick = null;

    public StickMan(String url) {

        this.setImage(new Image(url));
        this.setFitWidth(150);
        this.setPreserveRatio(true);
        this.setX(130);
        this.setY(700);

        stickManPane = new Pane();
        stickManPane.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
        stickManPane.setMinWidth(10);
        stickManPane.setMinHeight(150);
        stickManPane.setMaxWidth(10);
        stickManPane.setMaxHeight(150);
        // stickManPane.setOpacity(0.5);
        stickManPane.setTranslateX(200);
        stickManPane.setTranslateY(700);
        stickManPane.setPickOnBounds(false);
        statuStick = "fatigue";

    }

    public StickMan(Pane stickManPane) {

        this.stickManPane = stickManPane;
    }

    public Pane getStickManPane() {
        return stickManPane;
    }

    public void setStickManRunRight(){
        statuStick = "runRight";
       this.setImage(new Image("assets/gif/stickRun.gif"));
        this.setFitWidth(150);
    //    this.setTranslateY(0);
     //   stickManPane.setTranslateY(700);

    }

    public void setStickManRunLeft() {
        statuStick = "runLeft";

        this.setImage(new Image("assets/gif/stickRunrLeft.gif"));
        this.setFitWidth(150);
      //  this.setTranslateY(0);
       // stickManPane.setTranslateY(700);

    }

    public void setStickManFatigue(){
        statuStick = "fatigue";
        this.setImage(new Image("assets/gif/stickFatigue.gif"));
        this.setFitWidth(150);
    //    this.setTranslateY(0);

    }

    public void setStickManJump(){
        statuStick = "jumpRight";
        ani.getTimelineJumpBackToGround().stop();
        this.setImage(new Image("assets/gif/stickJump.gif"));
        ani.animJump(stickManPane, this);
        this.setFitWidth(150);
      //  this.setTranslateY(0);
    }

    public void setStickManJumpLeft(){
        statuStick = "jumpLeft";
        ani.getTimelineJumpBackToGround().stop();
        this.setImage(new Image("assets/gif/stickJumpLeft.gif"));
        ani.animJump(stickManPane, this);
        this.setFitWidth(150);
      //  this.setTranslateY(0);
    }

    public void setStickManJumpDown(){
        statuStick = "jumpDownRight";
        ani.getTimelineJump().stop();
        delaySetStickManFall = new PauseTransition(Duration.seconds(0.15));
        delaySetStickManFall.setOnFinished(eventt -> {
            this.setImage(new Image("assets/gif/stickJumpDownRight.gif"));

        });
        delaySetStickManFall.play();


              ani.animJumpBakcToGround(stickManPane, this);
        this.setFitWidth(150);
      //  this.setTranslateY(0);
    }

    public void setStatuStick(String statuStick) {
        this.statuStick = statuStick;
    }

    public void setStickManSimpleFall(){
        statuStick = "fall";
        this.setImage(new Image("assets/gif/stickJumpDownRight.gif"));
        this.setFitWidth(150);
        this.setTranslateY(0);
    }

    public void setStickManJumpDownLeft(){
        statuStick= "jumpDownLeft";
        ani.getTimelineJump().stop();
        delaySetStickManFall = new PauseTransition(Duration.seconds(0.15));
        delaySetStickManFall.setOnFinished(eventt -> {
            this.setImage(new Image("assets/gif/stickJumpDownLeft.gif"));
        });
        delaySetStickManFall.play();
        ani.animJumpBakcToGround(stickManPane, this);
        this.setFitWidth(150);
     //   this.setTranslateY(0);

    }

    public ImageView getLaserYeux() {
        return laserYeux;
    }

    public void tirLaser(Group root, StickMan stickMan){
         laserYeux = new ImageView("assets/image/laserYeux.png");
        laserYeux.setFitWidth(100);

        int stickManY = stickMan.yProperty().intValue()+20;
        int stickManYAjustTranslate = stickMan.translateYProperty().intValue();

        System.out.println(stickManY +" " + stickManYAjustTranslate);
        laserYeux.setY(stickManY+stickManYAjustTranslate);
        laserYeux.setPreserveRatio(true);
        root.getChildren().add(laserYeux);

        PauseTransition delaySpacePress = new PauseTransition(Duration.seconds(2)) ;
        delaySpacePress.setOnFinished(eventt -> {
            root.getChildren().remove(laserYeux);
        });
        delaySpacePress.play();

        ani.animTirYeux(laserYeux, this);


    }


    public void setStickManBeat() {
        statuStick = "beatRight";
        this.setImage(new Image("assets/gif/stickBeatRight.gif"));
       this.setFitWidth(300);

     //   viewHandler.getViewGame().getCompteurDefilement()
       this.setTranslateY(-150);

    }

    public void setStickManBeatRunRight() {
        statuStick = "beatRunRight";
        this.setImage(new Image("assets/gif/stickBeatRunRight.gif"));
        this.setFitWidth(300);

        //   viewHandler.getViewGame().getCompteurDefilement()
        this.setTranslateY(-150);

    }

    public PauseTransition getDelaySetStickManFall() {
        return delaySetStickManFall;
    }

    public Anim getAni() {
        return ani;
    }

    public String getStatuStick() {
        return statuStick;
    }

    public void setStickManBeatRunLeft() {

        statuStick = "beatRunRight";
        this.setImage(new Image("assets/gif/stickBeatRunRight.gif"));
        this.setFitWidth(300);

        //   viewHandler.getViewGame().getCompteurDefilement()
        this.setTranslateY(-150);
    }
}
