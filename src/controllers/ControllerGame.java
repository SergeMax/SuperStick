package controllers;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import models.Party;
import views.ViewGame;
import views.ViewHandler;

public class ControllerGame implements EventHandler<KeyEvent> {
    private final Party party;
    private ViewHandler viewHandler;
    private boolean rightpressed = false;
    private boolean leftpressed;
    private ViewGame viewGame;
    private boolean spacePresse = false;
    private boolean leftpressedAndSPace = false;
    private PauseTransition delayRemoveJumpDown = new PauseTransition();
    private boolean combineSpaceAndRightOrLeft;
    private boolean beatStart = false;
    private PauseTransition delayBoolJumpDown;
    private boolean spacePresseforBeat = false;

    public ControllerGame(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewHandler.setEventHandlerGame(this);

        party = new Party();

        viewGame = viewHandler.getViewGame();

    }

    @Override
    public void handle(KeyEvent keyEvent) {

        // Anim anim = new Anim();
        if (keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {

                if (rightpressed == false) {
                    delayRemoveJumpDown.stop();
                    rightpressed = true;
                    // leftpressed = false;

                    if (spacePresse == true ){

                        viewGame.getTimelineDefilementLeft().stop();

                        if (viewGame.getStickMan().getStatuStick().equals("jumpRight")== false && viewGame.getStickMan().getStatuStick().equals("jumpLeft")== false ){
                        viewGame.getStickMan().setStickManJump();}


                        viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                        System.out.println("keycode right");
                        viewGame.defilementRight(viewHandler.getViewGame().getCompteurDefilement());

                        viewGame.getTimelineDefilementRight().playFromStart();

                    }else if (beatStart == false && spacePresseforBeat == false && viewGame.getStickMan().getStatuStick().equals("jumpDownRight")) {

                        viewGame.getTimelineDefilementLeft().stop();

                        viewGame.getStickMan().setStickManJumpDown();

                        viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                        System.out.println("keycode right");
                        viewGame.defilementRight(viewHandler.getViewGame().getCompteurDefilement());

                        viewGame.getTimelineDefilementRight().playFromStart();
                    }else if (beatStart == false && spacePresseforBeat == false) {

                        viewGame.getTimelineDefilementLeft().stop();

                        viewGame.getStickMan().setStickManRunRight();

                        viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                        System.out.println("keycode right");
                        viewGame.defilementRight(viewHandler.getViewGame().getCompteurDefilement());

                        viewGame.getTimelineDefilementRight().playFromStart();
                    }else if (spacePresseforBeat == true){
                        viewGame.getTimelineDefilementLeft().stop();
                        viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                        viewGame.defilementRight(viewHandler.getViewGame().getCompteurDefilement());
                        viewGame.getTimelineDefilementRight().playFromStart();

                    }else{
                        viewGame.getTimelineDefilementLeft().stop();
                        viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                        viewGame.defilementRight(viewHandler.getViewGame().getCompteurDefilement());

                        viewGame.getStickMan().setStickManBeatRunRight();
                        viewGame.getTimelineDefilementRight().playFromStart();


                    }
                }
            }


            if (keyEvent.getCode() == KeyCode.LEFT) {

                if (leftpressed == false) {
                    delayRemoveJumpDown.stop();
                    leftpressed = true;

                    if (spacePresse == true){

                        viewGame.getTimelineDefilementRight().stop();

                        if (viewGame.getStickMan().getStatuStick().equals("jumpLeft")== false && viewGame.getStickMan().getStatuStick().equals("jumpRight")== false){
                            viewGame.getStickMan().setStickManJumpLeft();}


                        viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                        viewGame.defilementLeft(viewHandler.getViewGame().getCompteurDefilement());

                        viewGame.getTimelineDefilementLeft().playFromStart();


                    }else if (beatStart == false && spacePresseforBeat == false && viewGame.getStickMan().getStatuStick().equals("jumpDownLeft")) {

                        viewGame.getTimelineDefilementRight().stop();

                        viewGame.getStickMan().setStickManJumpDownLeft();

                        viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                        System.out.println("keycode Left");
                        viewGame.defilementRight(viewHandler.getViewGame().getCompteurDefilement());

                        viewGame.getTimelineDefilementLeft().playFromStart();
                    }else if (beatStart == false && spacePresseforBeat == false) {

                    viewGame.getTimelineDefilementRight().stop();

                    viewGame.getStickMan().setStickManRunLeft();

                    viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                    System.out.println("keycode left");
                    viewGame.defilementLeft(viewHandler.getViewGame().getCompteurDefilement());

                    viewGame.getTimelineDefilementLeft().playFromStart();
                 }else if (spacePresseforBeat == true){

                        viewGame.getTimelineDefilementRight().stop();
                        viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                        viewGame.defilementLeft(viewHandler.getViewGame().getCompteurDefilement());
                        viewGame.getTimelineDefilementLeft().playFromStart();

                }else{
                    viewGame.getTimelineDefilementRight().stop();
                    viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                    viewGame.defilementLeft(viewHandler.getViewGame().getCompteurDefilement());

                    viewGame.getStickMan().setStickManBeatRunLeft();
                    viewGame.getTimelineDefilementLeft().playFromStart();


                }


                }


            }


            if (keyEvent.getCode() == KeyCode.SPACE) {

              //  viewGame.setJumpDowTop13(false);
                spacePresseforBeat = true;
                delayRemoveJumpDown.stop();
                // viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());

                if (beatStart == false && (rightpressed == true || leftpressed == true)) {
                    if (spacePresse == false && leftpressed == true) {
                        viewGame.getStickMan().getDelaySetStickManFall().stop();
                        viewGame.getStickMan().setStickManJumpLeft();
                        spacePresse = true;
                        spacePresseforBeat = true;

                      //  PauseTransition delaySetStickManFall = new PauseTransition(Duration.seconds(0.5));

                     //   delaySetStickManFall.setOnFinished(eventt -> {
                         //   spacePresse = false;
                     //   });
                      //  delaySetStickManFall.play();
                    }
                    else if (spacePresse == false && rightpressed == true) {
                        viewGame.getStickMan().getDelaySetStickManFall().stop();

                        viewGame.getStickMan().setStickManJump();
                        spacePresse = true;
                        spacePresseforBeat = true;
                    }



                }
            }


            if (keyEvent.getCode() == KeyCode.N) {

                if (beatStart == false && spacePresseforBeat== false && spacePresse == false) {

                    if (rightpressed == false) {
                        viewGame.getStickMan().setStickManBeat();
                        beatStart = true;
                    }else{
                        viewGame.getStickMan().setStickManBeatRunRight();
                        beatStart = true;
                    }
                }

            }

            if (keyEvent.getCode() == KeyCode.H) {

                viewGame.getStickMan().tirLaser(viewGame.getRoot(), viewGame.getStickMan());

            }

        }
        if (keyEvent.getEventType().

                equals(KeyEvent.KEY_RELEASED)) {
            delayRemoveJumpDown.stop();


            if (keyEvent.getCode() == KeyCode.RIGHT) {
                viewHandler.getViewGame().getTimelineDefilementRight().stop();

                if (spacePresse == true) {
                   // viewGame.getStickMan().setStickManJumpDown();
                }

                if (leftpressed == true && spacePresse == false) {
                    viewGame.getStickMan().setStickManRunLeft();
                }

                if (spacePresse == true) {
                    combineSpaceAndRightOrLeft = true;

                } else if (spacePresse == false && leftpressed == false) {
                    viewGame.getStickMan().setStickManFatigue();
                    combineSpaceAndRightOrLeft = false;
                } else {
                  //  viewGame.getStickMan().setStickManSimpleFall();
                }

                if (beatStart == true && rightpressed == true) {
                    viewGame.getStickMan().setStickManBeat();
                }

                rightpressed = false;
            }


            if (keyEvent.getCode() == KeyCode.LEFT) {



                viewHandler.getViewGame().getTimelineDefilementLeft().stop();

                if (rightpressed == true && spacePresse == false) {
                    viewGame.getStickMan().setStickManRunRight();
                }

                if (spacePresse == true) {
                    combineSpaceAndRightOrLeft = true;
                 //   viewGame.getStickMan().setStickManSimpleFall();

                } else if (!spacePresse && rightpressed == false) {
                    viewGame.getStickMan().setStickManFatigue();
                    combineSpaceAndRightOrLeft = false;
                }

                if (beatStart == true && rightpressed == true) {
                    viewGame.getStickMan().setStickManBeat();
                }


                leftpressed = false;
            }

            if (keyEvent.getCode() == KeyCode.SPACE) {

                if (leftpressed == true || combineSpaceAndRightOrLeft == true || rightpressed == true) {


                    viewGame.getStickMan().getAni().getTimelineJump().stop();
                    viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());


                 if (leftpressed == true || combineSpaceAndRightOrLeft == true) {
                        viewGame.getStickMan().setStickManJumpDownLeft();
                        delayRemoveJumpDown = new PauseTransition(Duration.seconds(0.5));
                        delayRemoveJumpDown.setOnFinished(eventt -> {
                            viewGame.getStickMan().setStickManRunLeft();

                        });
                        delayRemoveJumpDown.play();
                    } else if (rightpressed == true || combineSpaceAndRightOrLeft == true) {
                        viewGame.getStickMan().setStickManJumpDown();
                        delayRemoveJumpDown = new PauseTransition(Duration.seconds(0.5));
                        delayRemoveJumpDown.setOnFinished(eventt -> {
                            viewGame.getStickMan().setStickManRunRight();
                        });
                        delayRemoveJumpDown.play();
                    } else if (rightpressed == false || combineSpaceAndRightOrLeft == false) {
                        viewGame.getStickMan().setStickManJumpDown();
                        delayRemoveJumpDown = new PauseTransition(Duration.seconds(0.5));
                        delayRemoveJumpDown.setOnFinished(eventt -> {
                            viewGame.getStickMan().setStickManFatigue();

                        });
                        delayRemoveJumpDown.play();
                    } else if (leftpressed == false || combineSpaceAndRightOrLeft == false) {
                        viewGame.getStickMan().setStickManJumpDown();
                        delayRemoveJumpDown = new PauseTransition(Duration.seconds(0.5));
                        delayRemoveJumpDown.setOnFinished(eventt -> {
                            viewGame.getStickMan().setStickManFatigue();
                        });
                        delayRemoveJumpDown.play();
                    } else {
                        viewGame.getStickMan().setStickManJumpDown();
                        delayRemoveJumpDown = new PauseTransition(Duration.seconds(0.5));
                        delayRemoveJumpDown.setOnFinished(eventt -> {
                            viewGame.getStickMan().setStickManFatigue();
                        });
                        delayRemoveJumpDown.play();

                    }

                    if (viewGame.getCompteurDefilement() < -1440 && viewGame.getCompteurDefilement()> -2340 && viewGame.getJumpDowTop13() == true ){
                      //  viewGame.getStickMan().getDelaySetStickManFall().stop();
                        viewGame.getStickMan().getAni().getTimelineJumpBackToGround().stop();
                        viewGame.getStickMan().getAni().animJumpBakcToGroundInt(viewGame.getStickManPane(), viewGame.getStickMan(), 500, -210);
                        System.out.println("condition ok");
                    }

                } else {

                    if (viewGame.getCompteurDefilement() < -1640 && viewGame.getCompteurDefilement()> -2340 && viewGame.getJumpDowTop13() == true ){
                        //  viewGame.getStickMan().getDelaySetStickManFall().stop();
                        viewGame.getStickMan().getAni().getTimelineJumpBackToGround().stop();
                        viewGame.getStickMan().getAni().animJumpBakcToGroundInt(viewGame.getStickManPane(), viewGame.getStickMan(), 500, -210);
                        System.out.println("condition ok");
                    }
                   // viewGame.getStickMan().setStickManSimpleFall();
                }
                leftpressedAndSPace = false;
                combineSpaceAndRightOrLeft = false;
                spacePresse = false;
           /*     combineSpaceAndRightOrLeft = false;
                spacePresse = false;
                leftpressedAndSPace = false;*/
                PauseTransition delaySpacePress = new PauseTransition(Duration.seconds(0.5)) ;
                 delaySpacePress.setOnFinished(eventt -> {

                    spacePresseforBeat = false;

                });
                delaySpacePress.play();

            }

            if (keyEvent.getCode() == KeyCode.N) {

                if (rightpressed == true && spacePresse == false) {
                    viewGame.getStickMan().setStickManRunRight();
                    beatStart = false;

                }

                if (rightpressed == false && spacePresse == false) {
                    viewGame.getStickMan().setStickManFatigue();
                    beatStart = false;

                }

            }
        }

    }
}
