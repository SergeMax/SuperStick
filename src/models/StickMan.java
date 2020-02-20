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

    }

    public void setStickManRunLeft() {
        this.setImage(new Image("assets/gif/stickRunrLeft.gif"));
    }

    public void setStickManFatigue(){
        this.setImage(new Image("assets/gif/stickFatigue.gif"));

    }

    public void setStickManJump(){
        ani.getTimelineJumpBackToGround().stop();
        this.setImage(new Image("assets/gif/stickJump.gif"));
        ani.animJump(this);
    }

    public void setStickManJumpLeft(){
        ani.getTimelineJumpBackToGround().stop();
        this.setImage(new Image("assets/gif/stickJumpLeft.gif"));
        ani.animJump(this);
    }

    public void setStickManJumpDown(){
        ani.getTimelineJump().stop();
        this.setImage(new Image("assets/gif/stickJumpDownRight.gif"));
        ani.animJumpBakcToGround(this);

    }
    public void setStickManJumpDownLeft(){
        ani.getTimelineJump().stop();
        this.setImage(new Image("assets/gif/stickJumpDownLeft.gif"));
        ani.animJumpBakcToGround(this);

    }

    public Anim getAni() {
        return ani;
    }
}
