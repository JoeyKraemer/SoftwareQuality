package com.ArestiKramer.JabberPoint.controller.menucontroller;

import com.ArestiKramer.JabberPoint.controller.Command;
import com.ArestiKramer.JabberPoint.accessor.Accessor;
import com.ArestiKramer.JabberPoint.accessor.XMLAccessor;
import com.ArestiKramer.JabberPoint.presentation.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * <p>This is the SaveFileCommand, it's used in MenuController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class SaveFileCommand extends Command
{
    private final Frame frame;

    public SaveFileCommand(Presentation presentation, Frame frame)
    {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute()
    {
        Accessor xmlAccessor = new XMLAccessor();
        try
        {
            xmlAccessor.saveFile(this.presentation, "dump.xml");
        } catch (IOException exc)
        {
            JOptionPane.showMessageDialog(this.frame, "IO Exception: " + exc,
                    "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
