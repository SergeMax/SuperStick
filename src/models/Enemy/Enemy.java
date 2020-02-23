package models.Enemy;

import anim.Anim;
import javafx.animation.PauseTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends ImageView {


    private Anim ani = new Anim();
    private PauseTransition delaySetStickManFall = new PauseTransition();

    public Enemy(String url, Double setX, Double setY, int setWidth) {

        this.setImage(new Image(url));
        this.setPreserveRatio(true);
        this.setX(setX);
        this.setY(setY);
        this.setFitWidth(setWidth);

    }



}
