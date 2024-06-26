package jabberpoint.controller.keycontroller;

import jabberpoint.presentation.Presentation;
import jabberpoint.controller.Command;

/**
 * <p>This is the PreviousSlideCommand, its used in KeyController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class PreviousSlideCommand extends Command {
    public PreviousSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.prevSlide();
    }
}
