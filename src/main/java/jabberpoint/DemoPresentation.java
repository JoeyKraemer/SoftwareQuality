package jabberpoint;

import jabberpoint.slide.Slide;
import jabberpoint.slideitem.items.BitmapItem;
import jabberpoint.style.StyleOptions;
import jabberpoint.style.styles.Style;

/**
 * A built in demo-presentation
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

class DemoPresentation extends Accessor {

    public void loadFile(Presentation presentation, String unusedFilename) {
        StyleOptions styleOptions = new StyleOptions();
        Style title = styleOptions.getTitle();
        Style subtitle = styleOptions.getSubtitle();
        Style text = styleOptions.getText();

        presentation.setTitle("Demo Presentation");
        Slide slide;
        slide = new Slide();
        slide.setTitle("jabberpoint");
        slide.appendTextItem(title, "The Java Presentation Tool");
        slide.appendTextItem(subtitle, "Copyright (c) 1996-2000: Ian Darwin");
        slide.appendTextItem(subtitle, "Copyright (c) 2000-now:");
        slide.appendTextItem(subtitle, "Gert Florijn andn Sylvia Stuurman");
        slide.appendTextItem(text, "Starting JabberPoint without a filename");
        slide.appendTextItem(text, "shows this presentation");
        slide.appendTextItem(title, "Navigate:");
        slide.appendTextItem(text, "Next slide: PgDn or Enter");
        slide.appendTextItem(text, "Previous slide: PgUp or up-arrow");
        slide.appendTextItem(text, "Quit: q or Q");
        presentation.append(slide);

        slide = new Slide();
        slide.setTitle("Demonstration of levels and stijlen");
        slide.appendTextItem(title, "Level 1");
        slide.appendTextItem(subtitle, "Level 2");
        slide.appendTextItem(title, "Again level 1");
        slide.appendTextItem(title, "Level 1 has style number 1");
        slide.appendTextItem(title, "Level 2 has style number  2");
        slide.appendTextItem(text, "This is how level 3 looks like");
        slide.appendTextItem(text, "And this is level 4");
        presentation.append(slide);

        slide = new Slide();
        slide.setTitle("The third slide");
        slide.appendTextItem(title, "To open a new presentation,");
        slide.appendTextItem(subtitle, "use File->Open from the menu.");
        slide.appendTextItem(title, " ");
        slide.appendTextItem(title, "This is the end of the presentation.");
        slide.appendBitMapItem(title, "Default.png");
        presentation.append(slide);
    }

    public void saveFile(Presentation presentation, String unusedFilename) {
        throw new IllegalStateException("Save As->Demo! called");
    }
}
