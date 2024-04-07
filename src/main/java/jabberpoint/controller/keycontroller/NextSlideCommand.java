package jabberpoint.controller.keycontroller;

import jabberpoint.presentation.Presentation;
import jabberpoint.controller.Command;

/**
 * <p>This is the NextSlideCommand, its used in KeyController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class NextSlideCommand extends Command {
    public NextSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.nextSlide();
    }
}
