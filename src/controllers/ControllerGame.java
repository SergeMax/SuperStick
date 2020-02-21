package controllers;

import anim.Anim;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import views.ViewGame;
import views.ViewHandler;

public class ControllerGame implements EventHandler<KeyEvent> {
    private ViewHandler viewHandler;
    private boolean rightpressed = false;
    private boolean leftpressed;
    private ViewGame viewGame;
    private boolean spacePresse = false;
    private boolean leftpressedAndSPace = false;
    private PauseTransition delayRemoveJumpDown = new PauseTransition();
    private boolean combineSpaceAndRightOrLeft;

    public ControllerGame(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewHandler.setEventHandlerGame(this);

        viewGame = viewHandler.getViewGame();

    }

    @Override
    public void handle(KeyEvent keyEvent) {

       // Anim anim = new Anim();
        if (keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {

                if (rightpressed == false) {
                    rightpressed = true;
                    leftpressed = false;
                    viewGame.getStickMan().setStickManRunRight();

                    viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());

                    System.out.println("keycode right");
                    viewGame.defilementRight(viewHandler.getViewGame().getCompteurDefilement());
                    viewGame.getTimelineDefilementLeft().stop();

                    viewGame.getTimelineDefilementRight().playFromStart();

                }
            }

            if (keyEvent.getCode() == KeyCode.LEFT) {

                if (leftpressed == false) {
                    leftpressed = true;
                    rightpressed = false;
                    viewGame.getStickMan().setStickManRunLeft();


                    viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                    viewGame.getTimelineDefilementRight().stop();
                    System.out.println("keycode Left");
                    viewHandler.getViewGame().defilementLeft(viewHandler.getViewGame().getCompteurDefilement());
                    viewHandler.getViewGame().getTimelineDefilementLeft().playFromStart();

                }


            }


            if (keyEvent.getCode() == KeyCode.SPACE) {

                delayRemoveJumpDown.stop();
                // viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());

                if (rightpressed == true || leftpressed == true) {
                    if (spacePresse == false) {
                        spacePresse = true;
                        if (leftpressed == true) {
                            viewGame.getStickMan().setStickManJumpLeft();
                        } else {
                            viewGame.getStickMan().setStickManJump();
                        }
                    }
                }
            }

        }
        if (keyEvent.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            delayRemoveJumpDown.stop();


            if (keyEvent.getCode() == KeyCode.RIGHT) {
                viewHandler.getViewGame().getTimelineDefilementRight().stop();

                if (spacePresse == true) {
                    viewGame.getStickMan().setStickManJumpDown();
                }

                if (leftpressed == true){
                    viewGame.getStickMan().setStickManRunLeft();
                }

                if (spacePresse == true) {
                    combineSpaceAndRightOrLeft = true;
                } else if (spacePresse == false){
                    viewGame.getStickMan().setStickManFatigue();
                    combineSpaceAndRightOrLeft = false;
                }

                rightpressed = false;
            }


            if (keyEvent.getCode() == KeyCode.LEFT) {
                viewHandler.getViewGame().getTimelineDefilementLeft().stop();

                if (spacePresse == true) {
                    viewGame.getStickMan().setStickManJumpDownLeft();
                }

                if (rightpressed == true){
                    viewGame.getStickMan().setStickManRunRight();
                }

                if (spacePresse == true) {
                    combineSpaceAndRightOrLeft = true;
                } else if (!spacePresse) {
                    viewGame.getStickMan().setStickManFatigue();
                    combineSpaceAndRightOrLeft = false;
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





                }
                combineSpaceAndRightOrLeft = false;
                spacePresse = false;
                leftpressedAndSPace = false;
            }
        }

    }
}
