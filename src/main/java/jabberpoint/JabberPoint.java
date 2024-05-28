package jabberpoint;

import jabberpoint.accessor.Accessor;
import jabberpoint.accessor.XMLAccessor;
import jabberpoint.presentation.Presentation;
import jabberpoint.slideviewer.SlideViewerFrame;

import javax.swing.*;
import java.io.IOException;

/**
 * <p>This is the JabberPoint Main Program</p>
 *
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class JabberPoint
{
    protected static final String JABVERSION = "Jabberpoint 2.0 - OU version";

    public static void main(String[] argv)
    {

        Presentation presentation = new Presentation();
        new SlideViewerFrame(JABVERSION, presentation);
        try
        {
            if (argv.length == 0)
            {
                Accessor.getDemoAccessor().loadFile(presentation, "");
            } else
            {
                new XMLAccessor().loadFile(presentation, argv[0]);
            }
            presentation.setSlideNumber(0);
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null,
                    JabberPointErrors.IOERR.name() + ex, JabberPointErrors.JABBER.name(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
