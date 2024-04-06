package jabberpoint;

import java.io.IOException;

/**
 * <p>This is the Accessor. It makes it possible to transfer data for a presentation
 *  to read or write.</p>
 *
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public abstract class Accessor {
    public static final String DEMO_NAME = "Demonstration presentation";
    public static final String DEFAULT_EXTENSION = ".xml";

    public static Accessor getDemoAccessor() {
        return new DemoPresentation();
    }

    public Accessor() {
    }

    abstract public void loadFile(Presentation p, String fn) throws IOException;

    abstract public void saveFile(Presentation p, String fn) throws IOException;

}
