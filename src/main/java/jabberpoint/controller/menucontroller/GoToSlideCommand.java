package jabberpoint.controller.menucontroller;

import jabberpoint.presentation.Presentation;
import jabberpoint.controller.Command;

import javax.swing.JOptionPane;

/**
 * <p>This is the GoToSlideCommand, it's used in MenuController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class GoToSlideCommand extends Command {
    public GoToSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        String pageNumberStr = JOptionPane.showInputDialog((Object) "Page number?");
        int pageNumber = Integer.parseInt(pageNumberStr);
        this.presentation.setSlideNumber(pageNumber - 1);
    }
}
