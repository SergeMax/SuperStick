package models;


import anim.Anim;
import javafx.animation.PauseTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class StickMan extends ImageView{


    private Anim ani = new Anim();
    private PauseTransition delaySetStickManFall = new PauseTransition();

    public StickMan(String url) {

        this.setImage(new Image(url));
        this.setFitWidth(150);
        this.setPreserveRatio(true);
        this.setX(100);
        this.setY(600);

    }

    public StickMan() {



    }

    public void setStickManRunRight(){
       this.setImage(new Image("assets/gif/stickRun.gif"));
        this.setFitWidth(150);
        this.setTranslateY(0);

    }

    public void setStickManRunLeft() {
        this.setImage(new Image("assets/gif/stickRunrLeft.gif"));
        this.setFitWidth(150);
        this.setTranslateY(0);
    }

    public void setStickManFatigue(){
        this.setImage(new Image("assets/gif/stickFatigue.gif"));
        this.setFitWidth(150);
        this.setTranslateY(0);

    }

    public void setStickManJump(){
        ani.getTimelineJumpBackToGround().stop();
        this.setImage(new Image("assets/gif/stickJump.gif"));
        ani.animJump(this);
        this.setFitWidth(150);
        this.setTranslateY(0);
    }

    public void setStickManJumpLeft(){
        ani.getTimelineJumpBackToGround().stop();
        this.setImage(new Image("assets/gif/stickJumpLeft.gif"));
        ani.animJump(this);
        this.setFitWidth(150);
        this.setTranslateY(0);
    }

    public void setStickManJumpDown(){
        ani.getTimelineJump().stop();
        delaySetStickManFall = new PauseTransition(Duration.seconds(0.15));
        delaySetStickManFall.setOnFinished(eventt -> {
            this.setImage(new Image("assets/gif/stickJumpDownRight.gif"));
        });
        delaySetStickManFall.play();

            ani.animJumpBakcToGround(this);
        this.setFitWidth(150);
        this.setTranslateY(0);
    }

    public void setStickManSimpleFall(){
        this.setImage(new Image("assets/gif/stickJumpDownRight.gif"));
        this.setFitWidth(150);
        this.setTranslateY(0);
    }

    public void setStickManJumpDownLeft(){
        ani.getTimelineJump().stop();
        delaySetStickManFall = new PauseTransition(Duration.seconds(0.15));
        delaySetStickManFall.setOnFinished(eventt -> {
            this.setImage(new Image("assets/gif/stickJumpDownLeft.gif"));
        });
        delaySetStickManFall.play();
        ani.animJumpBakcToGround(this);
        this.setFitWidth(150);
        this.setTranslateY(0);

    }



    public void tirLaser(Group root, StickMan stickMan){
        ImageView laserYeux = new ImageView("assets/image/laserYeux.png");
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
        this.setImage(new Image("assets/gif/stickBeatRight.gif"));
       this.setFitWidth(300);

     //   viewHandler.getViewGame().getCompteurDefilement()
       this.setTranslateY(-150);

    }

    public void setStickManBeatRun() {
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

}
