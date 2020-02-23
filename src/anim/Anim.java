package anim;

import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import models.Enemy.Drone;
import models.StickMan;

public class Anim {

    private Timeline timelineJump = new Timeline();
    private Timeline timelineJumpBackToGround = new Timeline();
    private Timeline timelineTirYeux;


    //Anim StickMan ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void animJump(StickMan stickMan){

        int stickManY = stickMan.translateYProperty().intValue();
        final KeyFrame JumpStart = new KeyFrame(Duration.ZERO, new KeyValue(stickMan.translateYProperty(), stickManY));
        final KeyFrame JumpMiddle = new KeyFrame(Duration.seconds(1), new KeyValue(stickMan.translateYProperty(), stickManY-300 ));
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

    //Anim Enemy :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        //Anim Drone :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void animDrone(Drone drone, double startX, double midelX, double starty, double midelY, double midelY2, double midelY3, double midelY4, double endY ){
        //int stickManY = stickMan.translateYProperty().intValue();
        final KeyFrame yStart = new KeyFrame(Duration.ZERO, new KeyValue(drone.translateYProperty(), starty));
        final KeyFrame yMidel= new KeyFrame(Duration.seconds(1), new KeyValue(drone.translateYProperty(), midelY , Interpolator.EASE_OUT));
        final KeyFrame yMidel2= new KeyFrame(Duration.seconds(2), new KeyValue(drone.translateYProperty(), midelY2, Interpolator.EASE_IN ));
        final KeyFrame yMidel3= new KeyFrame(Duration.seconds(3), new KeyValue(drone.translateYProperty(), midelY3, Interpolator.EASE_BOTH ));
        final KeyFrame yMidel4 = new KeyFrame(Duration.seconds(4), new KeyValue(drone.translateYProperty(), midelY4 ));

        final KeyFrame yEnd = new KeyFrame(Duration.seconds(5), new KeyValue(drone.translateYProperty(), endY ));


        final KeyFrame xStart = new KeyFrame(Duration.ZERO, new KeyValue(drone.translateXProperty(), startX));
        final KeyFrame xMidel = new KeyFrame(Duration.seconds(3), new KeyValue(drone.translateXProperty(), midelX, Interpolator.EASE_OUT ));
        final KeyFrame xEnd = new KeyFrame(Duration.seconds(7), new KeyValue(drone.translateXProperty(), startX, Interpolator.EASE_OUT ));




        timelineJump = new Timeline(yStart, yMidel, yMidel2, yMidel3, yMidel4, yEnd, xStart, xMidel, xEnd);
        timelineJump.setCycleCount(Animation.INDEFINITE);
        timelineJump.play();


    }
}
