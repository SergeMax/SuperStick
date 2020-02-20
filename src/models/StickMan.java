package models;


import anim.anim;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StickMan extends ImageView{


    public StickMan(String url) {

        this.setImage(new Image(url));
        this.setFitWidth(100);
        this.setPreserveRatio(true);
        this.setX(100);
        this.setY(600);

    }

    public StickMan() {



    }

    public void setStickManRun(){
       this.setImage(new Image("assets/gif/stickRun.gif"));

    }

    public void setStickManFatigue(){
        this.setImage(new Image("assets/gif/stickFatigue.gif"));

    }

    public void setStickManJump(){
        anim ani = new anim();
        //ani.getTimelineJumpBackToGround().stop();
        this.setImage(new Image("assets/gif/stickJump.gif"));
        ani.animJump(this);
    }

    public void setStickManJumpDown(){
        anim ani = new anim();
        //ani.getTimelineJump().stop();
        this.setImage(new Image("assets/gif/stickFatigue.gif"));
        ani.animJumpBakcToGround(this);

    }
}
