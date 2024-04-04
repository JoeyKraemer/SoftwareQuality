package jabberPoint.commands.menuController;

import jabberPoint.Presentation;
import jabberPoint.commands.Command;

public class ExitCommand extends Command {
    public ExitCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.exit(0);
    }
}
