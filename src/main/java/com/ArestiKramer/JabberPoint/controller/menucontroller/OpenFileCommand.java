package com.ArestiKramer.JabberPoint.controller.menucontroller;

import com.ArestiKramer.JabberPoint.controller.Command;
import com.ArestiKramer.JabberPoint.accessor.Accessor;
import com.ArestiKramer.JabberPoint.accessor.XMLAccessor;
import com.ArestiKramer.JabberPoint.presentation.Presentation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * <p>This is the OpenFileCommand, it's used in MenuController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class OpenFileCommand extends Command
{
    private final Frame frame;

    public OpenFileCommand(Presentation presentation, Frame frame)
    {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute()
    {
        this.presentation.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try
        {
            xmlAccessor.loadFile(this.presentation, "test.xml");
            this.presentation.setSlideNumber(0);
        } catch (IOException exc)
        {
            JOptionPane.showMessageDialog(this.frame, "IO Exception: " + exc, "Load Error", JOptionPane.ERROR_MESSAGE);
        }
        this.frame.repaint();
    }
}
