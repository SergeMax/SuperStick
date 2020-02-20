package controllers;

import anim.anim;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import views.ViewGame;
import views.ViewHandler;

public class ControllerGame implements EventHandler<KeyEvent> {
    private ViewHandler viewHandler;
    private boolean rightpressed;
    private boolean leftpressed;
    private ViewGame viewGame;
    private boolean spacePresse = false;

    public ControllerGame(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewHandler.setEventHandlerGame(this);

        viewGame = viewHandler.getViewGame();

    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED)) {


            if (keyEvent.getCode() == KeyCode.RIGHT) {

                if (rightpressed == false) {
                    System.out.println("keycode right");
                    viewGame.defilementRight(viewHandler.getViewGame().getCompteurDefilement());
                    viewGame.getTimelineDefilementRight().playFromStart();
                    viewGame.getStickMan().setStickManRun();
                    rightpressed = true;
                }
            }

            if (keyEvent.getCode() == KeyCode.LEFT) {

                if (leftpressed == false) {
                    System.out.println("keycode right");
                    viewHandler.getViewGame().defilementLeft(viewHandler.getViewGame().getCompteurDefilement());
                    viewHandler.getViewGame().getTimelineDefilementLeft().playFromStart();
                    leftpressed = true;
                }
            }

            if (keyEvent.getCode() == KeyCode.SPACE) {
                if (spacePresse == false) {
                    viewGame.getStickMan().setStickManJump();
                    spacePresse = true;
                }
            }

        }
        if (keyEvent.getEventType().equals(KeyEvent.KEY_RELEASED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {
                viewHandler.getViewGame().getTimelineDefilementRight().stop();
                viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                viewGame.getStickMan().setStickManFatigue();

                rightpressed = false;
            }


            if (keyEvent.getCode() == KeyCode.LEFT) {
                viewHandler.getViewGame().getTimelineDefilementLeft().stop();
                viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                leftpressed = false;
            }

            if (keyEvent.getCode() == KeyCode.SPACE) {
                spacePresse=false;
                viewGame.getStickMan().setStickManJumpDown();
            }

        }
    }
}