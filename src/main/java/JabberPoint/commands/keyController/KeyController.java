package JabberPoint.commands.keyController;

import JabberPoint.Presentation;
import JabberPoint.commands.Command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 * <p>This is the JabberPoint.commands.keyController.KeyController (KeyListener)</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/04 Caterina Aresti & Joey Kramer
 */

public class KeyController extends KeyAdapter {
    private Presentation presentation; // Commands are given to the presentation

    public KeyController(Presentation presentation) {
        this.presentation = presentation;
    }

    public void keyPressed(KeyEvent keyEvent) {
        Command action = null;
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                action = new NextSlideCommand(this.presentation);
                action.execute();
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                action = new PreviousSlideCommand(this.presentation);
                action.execute();
                break;
            case 'q':
            case 'Q':
                action = new QuitCommand(this.presentation);
                action.execute();
                break; // Probably never reached!!
            default:
                break;
        }
    }
}
