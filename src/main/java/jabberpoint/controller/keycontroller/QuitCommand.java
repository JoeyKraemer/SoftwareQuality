package jabberpoint.controller.keycontroller;

import jabberpoint.Presentation;
import jabberpoint.controller.Command;

/**
 * <p>This is the QuitCommand, its used in KeyController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class QuitCommand extends Command {
    public QuitCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
