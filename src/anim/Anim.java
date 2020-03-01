package anim;

import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import models.Enemy.Drone;
import models.StickMan;

public class Anim {

    private Timeline timelineJump = new Timeline();
    private Timeline timelineJumpBackToGround = new Timeline();
    private Timeline timelineTirYeux;
    private Timeline timelineDrone;
    private Timeline timelineFall;
    private Timeline timelineJumpBackToGround3;


    //Anim StickMan ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public void animJump(Pane stickManPane, StickMan stickMan) {

        int stickManYPane = stickManPane.translateYProperty().intValue();
        final KeyFrame JumpStartPane = new KeyFrame(Duration.ZERO, new KeyValue(stickManPane.translateYProperty(), stickManYPane));
        final KeyFrame JumpMiddlePane = new KeyFrame(Duration.seconds(1), new KeyValue(stickManPane.translateYProperty(), stickManYPane - 300));
        final KeyFrame JumpEndPane = new KeyFrame(Duration.seconds(2), new KeyValue(stickManPane.translateYProperty(), 700));

        int stickManY = stickMan.translateYProperty().intValue();
        final KeyFrame JumpStart = new KeyFrame(Duration.ZERO, new KeyValue(stickMan.translateYProperty(), stickManY));
        final KeyFrame JumpMiddle = new KeyFrame(Duration.seconds(1), new KeyValue(stickMan.translateYProperty(), stickManY - 300));
        final KeyFrame JumpEnd = new KeyFrame(Duration.seconds(2), new KeyValue(stickMan.translateYProperty(), 0));


        timelineJump = new Timeline(JumpStart, JumpStartPane, JumpMiddlePane, JumpMiddle, JumpEndPane, JumpEnd);
        timelineJump.setCycleCount(1);
        timelineJump.play();
    }

    public void animJumpBakcToGround(Pane stickManPane, StickMan stickMan) {

        int stickManPaneY = stickManPane.translateYProperty().intValue();
        final KeyFrame JumpStart = new KeyFrame(Duration.ZERO, new KeyValue(stickManPane.translateYProperty(), stickManPaneY));
        final KeyFrame JumpEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(stickManPane.translateYProperty(), 700));

        int stickManY = stickMan.translateYProperty().intValue();

        final KeyFrame JumpStartStick = new KeyFrame(Duration.ZERO, new KeyValue(stickMan.translateYProperty(), stickManY));
        final KeyFrame JumpEndStick = new KeyFrame(Duration.seconds(0.5), new KeyValue(stickMan.translateYProperty(), 0));


        timelineJumpBackToGround = new Timeline(JumpStart, JumpStartStick, JumpEndStick, JumpEnd);
        timelineJumpBackToGround.setCycleCount(1);
        timelineJumpBackToGround.play();
    }

    public void animJumpBakcToGroundInt(Pane stickManPane, StickMan stickMan, int YStickManPane, int YstickMan) {

        int stickManPaneY = stickManPane.translateYProperty().intValue();
        final KeyFrame JumpStart = new KeyFrame(Duration.ZERO, new KeyValue(stickManPane.translateYProperty(), stickManPaneY));
        final KeyFrame JumpEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(stickManPane.translateYProperty(), YStickManPane));

        int stickManY = stickMan.translateYProperty().intValue();

        final KeyFrame JumpStartStick = new KeyFrame(Duration.ZERO, new KeyValue(stickMan.translateYProperty(), stickManY));
        final KeyFrame JumpEndStick = new KeyFrame(Duration.seconds(0.5), new KeyValue(stickMan.translateYProperty(), YstickMan));


        timelineJumpBackToGround3 = new Timeline(JumpStart, JumpStartStick, JumpEndStick, JumpEnd);
        timelineJumpBackToGround3.setCycleCount(1);
        timelineJumpBackToGround3.play();
    }

    public void animTirYeux(ImageView laser, StickMan stickMan) {
        int stickManY = stickMan.yProperty().intValue();
        int stickManYAjustTranslate = stickMan.yProperty().intValue();

        int stickManX = stickMan.xProperty().intValue();

        final KeyFrame laserStart = new KeyFrame(Duration.ZERO, new KeyValue(laser.translateXProperty(), stickManX + 80));
        final KeyFrame laserY = new KeyFrame(Duration.ZERO, new KeyValue(laser.translateYProperty(), stickManY - stickManYAjustTranslate));


        final KeyFrame laserEnd = new KeyFrame(Duration.seconds(1), new KeyValue(laser.translateXProperty(), stickManX + 2000));

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
    public Timeline animDrone(Drone drone, double startX, double midelX, double starty, double midelY, double midelY2, double midelY3, double midelY4, double endY) {
        //int stickManY = stickMan.translateYProperty().intValue();
        final KeyFrame yStart = new KeyFrame(Duration.ZERO, new KeyValue(drone.translateYProperty(), starty));
        final KeyFrame yMidel = new KeyFrame(Duration.seconds(1), new KeyValue(drone.translateYProperty(), midelY, Interpolator.EASE_OUT));
        final KeyFrame yMidel2 = new KeyFrame(Duration.seconds(2), new KeyValue(drone.translateYProperty(), midelY2, Interpolator.EASE_IN));
        final KeyFrame yMidel3 = new KeyFrame(Duration.seconds(3), new KeyValue(drone.translateYProperty(), midelY3, Interpolator.EASE_BOTH));
        final KeyFrame yMidel4 = new KeyFrame(Duration.seconds(4), new KeyValue(drone.translateYProperty(), midelY4));

        final KeyFrame yEnd = new KeyFrame(Duration.seconds(5), new KeyValue(drone.translateYProperty(), endY));


        final KeyFrame xStart = new KeyFrame(Duration.ZERO, new KeyValue(drone.translateXProperty(), startX));
        final KeyFrame xMidel = new KeyFrame(Duration.seconds(3), new KeyValue(drone.translateXProperty(), midelX, Interpolator.EASE_OUT));
        final KeyFrame xEnd = new KeyFrame(Duration.seconds(7), new KeyValue(drone.translateXProperty(), startX, Interpolator.EASE_OUT));


        timelineDrone = new Timeline(yStart, yMidel, yMidel2, yMidel3, yMidel4, yEnd, xStart, xMidel, xEnd);
        timelineDrone.setCycleCount(Animation.INDEFINITE);
        // timelineDrone.play();
        return timelineDrone;


    }

    public Timeline getTimelineDrone() {
        return timelineDrone;
    }

    public void animFall(Pane stickManPane, StickMan stickMan) {


        int stickManY = stickMan.translateYProperty().intValue();

        if (stickManY >= 0){

        final KeyFrame JumpStartStick = new KeyFrame(Duration.ZERO, new KeyValue(stickMan.translateYProperty(), 0));
        final KeyFrame JumpEndStick = new KeyFrame(Duration.seconds(0.5), new KeyValue(stickMan.translateYProperty(), 300));

        final KeyFrame JumpStart = new KeyFrame(Duration.ZERO, new KeyValue(stickManPane.translateYProperty(), 700));
        final KeyFrame JumpEnd = new KeyFrame(Duration.seconds(0.5), new KeyValue(stickManPane.translateYProperty(), 1300));

        timelineFall = new Timeline(JumpStart, JumpStartStick, JumpEnd, JumpEndStick);
        timelineFall.setCycleCount(1);
        timelineFall.play();}
    }
}

