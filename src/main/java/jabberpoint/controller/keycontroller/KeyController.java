package jabberpoint.controller.keycontroller;

import jabberpoint.controller.Receiver;
import jabberpoint.presentation.Presentation;
import jabberpoint.controller.Command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 * <p>This is the KeyController, it executes commands when keys are pressed</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class KeyController extends KeyAdapter implements Receiver {
    private final Presentation presentation; // Commands are given to the presentation

    public KeyController(Presentation presentation) {
        this.presentation = presentation;
    }

    @Override
    public void executeCommand(Command command){
        command.execute();
    }

    public void keyPressed(KeyEvent keyEvent) {

        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                executeCommand(new NextSlideCommand(this.presentation));
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                executeCommand(new PreviousSlideCommand(this.presentation));
                break;
            case 'q':
            case 'Q':
                executeCommand(new QuitCommand(this.presentation));
                break; // Probably never reached!!
            default:
                break;
        }
    }


}
