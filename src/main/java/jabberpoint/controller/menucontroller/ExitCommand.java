package jabberpoint.controller.menucontroller;

import jabberpoint.presentation.Presentation;
import jabberpoint.controller.Command;

/**
 * <p>This is the ExitCommand, it's used in MenuController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class ExitCommand extends Command {
    public ExitCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.exit(0);
    }
}
