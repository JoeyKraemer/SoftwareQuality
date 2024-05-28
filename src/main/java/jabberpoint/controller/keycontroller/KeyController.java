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
    private final NextSlideCommand nextSlideCommand;
    private final PreviousSlideCommand previousSlideCommand;
    private final QuitCommand quitCommand;

    public KeyController(Presentation presentation)
    {
        this.presentation = presentation;
        this.nextSlideCommand = new NextSlideCommand(this.presentation);
        this.previousSlideCommand = new PreviousSlideCommand(this.presentation);
        this.quitCommand = new QuitCommand(this.presentation);
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
                executeCommand(this.nextSlideCommand);
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                executeCommand(this.previousSlideCommand);
                break;
            case 'q':
            case 'Q':
                executeCommand(this.quitCommand);
                break; // Probably never reached!!
            default:
                break;
        }
    }


}
