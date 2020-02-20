package anim;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import models.StickMan;

public class anim {

    private Timeline timelineJump;
    private Timeline timelineJumpBackToGround;

    public void animJump(StickMan stickMan){

        final KeyFrame JumpStart = new KeyFrame(Duration.ZERO, new KeyValue(stickMan.translateYProperty(), 0));
        final KeyFrame JumpMiddle = new KeyFrame(Duration.seconds(1), new KeyValue(stickMan.translateYProperty(), -200 ));
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

    public Timeline getTimelineJump() {
        return timelineJump;
    }

    public Timeline getTimelineJumpBackToGround() {
        return timelineJumpBackToGround;
    }
}
