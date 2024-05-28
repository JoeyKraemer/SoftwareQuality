package jabberpoint.accessor;

import jabberpoint.presentation.DemoPresentation;
import jabberpoint.presentation.Presentation;

import java.io.IOException;

/**
 * <p>This is the Accessor. It makes it possible to transfer data for a presentation
 * to read or write.</p>
 *
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public abstract class Accessor
{

    public Accessor()
    {

    }

    public static Accessor getDemoAccessor()
    {
        return new DemoPresentation();
    }

    public abstract void loadFile(Presentation p, String fn) throws IOException;

    public abstract void saveFile(Presentation p, String fn) throws IOException;

}
