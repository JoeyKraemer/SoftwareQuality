package jabberpoint;

import java.io.IOException;

/**
 * <p>Een JabberPoint.JabberPoint.Accessor maakt het mogelijk om gegevens voor een presentatie
 * te lezen of te schrijven.</p>
 * <p>Niet-abstracte subklassen moeten de load en de save methode implementeren.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
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
