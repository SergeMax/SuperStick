package anim;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import models.StickMan;

public class Anim {

    private Timeline timelineJump = new Timeline();
    private Timeline timelineJumpBackToGround = new Timeline();
    private Timeline timelineTirYeux;

    public void animJump(StickMan stickMan){

        int stickManY = stickMan.translateYProperty().intValue();
        final KeyFrame JumpStart = new KeyFrame(Duration.ZERO, new KeyValue(stickMan.translateYProperty(), stickManY));
        final KeyFrame JumpMiddle = new KeyFrame(Duration.seconds(1), new KeyValue(stickMan.translateYProperty(), stickManY-200 ));
        final KeyFrame JumpEnd = new KeyFrame(Duration.seconds(2), new KeyValue(stickMan.translateYProperty(), 0 ));

        timelineJump = new Timeline(JumpStart, JumpMiddle, JumpEnd);
        timelineJump.setCycleCount(1);
        timelineJump.play();
    }

    public void animJumpBakcToGround(StickMan stickMan){

        int stickManY = stickMan.translateYProperty().intValue();
        final KeyFrame JumpStart = new KeyFrame(Duration.ZERO, new KeyValue(stickMan.translateYProperty(), stickManY));
        final KeyFrame JumpEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(stickMan.translateYProperty(), 0 ));

        timelineJumpBackToGround = new Timeline(JumpStart, JumpEnd);
        timelineJumpBackToGround.setCycleCount(1);
        timelineJumpBackToGround.play();
    }

    public void animTirYeux(ImageView laser, StickMan stickMan){
        int stickManY = stickMan.yProperty().intValue();
        int stickManYAjustTranslate = stickMan.yProperty().intValue();

        int stickManX = stickMan.xProperty().intValue();

        final KeyFrame laserStart = new KeyFrame(Duration.ZERO, new KeyValue(laser.translateXProperty(), stickManX+80));
        final KeyFrame laserY = new KeyFrame(Duration.ZERO, new KeyValue(laser.translateYProperty(), stickManY - stickManYAjustTranslate));


        final KeyFrame laserEnd = new KeyFrame(Duration.seconds(1), new KeyValue(laser.translateXProperty(), stickManX+2000 ));

        timelineTirYeux = new Timeline(laserStart, laserY, laserEnd);
        timelineTirYeux.setCycleCount(1);
        timelineTirYeux.play();
    }

    public Timeline getTimelineJump() {
        return timelineJump;
    }

    public Timeline getTimelineJumpBackToGround() {
        return timelineJumpBackToGround;
    }
}
