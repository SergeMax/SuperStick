package models;


import anim.Anim;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StickMan extends ImageView{


    private Anim ani = new Anim();

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
        this.setImage(new Image("assets/gif/stickJumpDownRight.gif"));
        ani.animJumpBakcToGround(this);
        this.setFitWidth(150);
        this.setTranslateY(0);

    }
    public void setStickManJumpDownLeft(){
        ani.getTimelineJump().stop();
        this.setImage(new Image("assets/gif/stickJumpDownLeft.gif"));
        ani.animJumpBakcToGround(this);
        this.setFitWidth(150);
        this.setTranslateY(0);

    }

    public Anim getAni() {
        return ani;
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
}
