package JabberPoint.commands;

import JabberPoint.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public abstract class Command
{
    public Presentation presentation;

    public Command(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public abstract void execute();

}
