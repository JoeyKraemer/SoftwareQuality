package jabberpoint.controller;

import jabberpoint.Presentation;

/**
 * <p>This is the Command, it's extended in all the Command subclasses</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public abstract class Command {
    public Presentation presentation;

    public Command(Presentation presentation) {
        this.presentation = presentation;
    }

    public abstract void execute();

}
