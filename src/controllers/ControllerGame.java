package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import views.ViewHandler;

public class ControllerGame implements EventHandler<KeyEvent> {
    private ViewHandler viewHandler;
    private boolean rightpressed;

    public ControllerGame(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.viewHandler.setEventHandlerGame(this);


    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getEventType().equals(KeyEvent.KEY_PRESSED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {

                if (rightpressed == false) {
                    System.out.println("keycode right");
                    viewHandler.getViewGame().defilement(viewHandler.getViewGame().getCompteurDefilement());
                    viewHandler.getViewGame().getTimelineDefilement().playFromStart();
                    rightpressed = true;
                }
            }
        }
        if (keyEvent.getEventType().equals(KeyEvent.KEY_RELEASED)) {

            if (keyEvent.getCode() == KeyCode.RIGHT) {
                viewHandler.getViewGame().getTimelineDefilement().stop();
                viewHandler.getViewGame().setCompteurDefilement(viewHandler.getViewGame().getCompteurDefilement());
                // presseLeft = false;
                // launcher.getGame().getAnimTextMenuArrivee().stop();
                rightpressed= false;
            }

        }
    }
}