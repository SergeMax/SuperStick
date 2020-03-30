package models.Enemy;

import anim.Anim;
import javafx.animation.PauseTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import models.StickMan;

public class Enemy extends ImageView {


    private Anim ani = new Anim();
    private PauseTransition delaySetStickManFall = new PauseTransition();
    private int contactAttaque;
    private boolean touche = false;

    public Enemy(String url, Double setX, Double setY, int setWidth, int contactAttack) {

        this.setImage(new Image(url));
        this.setPreserveRatio(true);
        this.setX(setX);
        this.setY(setY);
        this.setFitWidth(setWidth);
        this.contactAttaque = contactAttack;


    }

    public void contactAttack(StickMan stickMan) {

        if (touche == false) {
            touche = true;
            int life = stickMan.getLife();
            life -= contactAttaque;
            stickMan.setLife(life);

            PauseTransition delayRemoveTir = new PauseTransition(Duration.seconds(2));
            delayRemoveTir.setOnFinished(event -> {
                touche = false;
            });
            delayRemoveTir.play();
        }


    }


}
