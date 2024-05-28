package jabberpoint.controller.menucontroller;

import jabberpoint.accessor.Accessor;
import jabberpoint.accessor.XMLAccessor;
import jabberpoint.controller.Command;
import jabberpoint.presentation.Presentation;

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
