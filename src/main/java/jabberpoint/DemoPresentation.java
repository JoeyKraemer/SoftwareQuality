package jabberpoint;

import jabberpoint.slide.Slide;
import jabberpoint.slideitem.items.BitmapItem;

/**
 * A built in demo-presentation
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

class DemoPresentation extends Accessor {

    public void loadFile(Presentation presentation, String unusedFilename) {
        presentation.setTitle("Demo JabberPoint.JabberPoint.Presentation");
        Slide slide;
        slide = new Slide();
        slide.setTitle("jabberpoint");
        slide.appendTextItem(1, "The Java Presentation Tool");
        slide.appendTextItem(2, "Copyright (c) 1996-2000: Ian Darwin");
        slide.appendTextItem(2, "Copyright (c) 2000-now:");
        slide.appendTextItem(2, "Gert Florijn andn Sylvia Stuurman");
        slide.appendTextItem(4, "Starting JabberPoint without a filename");
        slide.appendTextItem(4, "shows this presentation");
        slide.appendTextItem(1, "Navigate:");
        slide.appendTextItem(3, "Next slide: PgDn or Enter");
        slide.appendTextItem(3, "Previous slide: PgUp or up-arrow");
        slide.appendTextItem(3, "Quit: q or Q");
        presentation.append(slide);

        slide = new Slide();
        slide.setTitle("Demonstration of levels and stijlen");
        slide.appendTextItem(1, "Level 1");
        slide.appendTextItem(2, "Level 2");
        slide.appendTextItem(1, "Again level 1");
        slide.appendTextItem(1, "Level 1 has style number 1");
        slide.appendTextItem(2, "Level 2 has style number  2");
        slide.appendTextItem(3, "This is how level 3 looks like");
        slide.appendTextItem(4, "And this is level 4");
        presentation.append(slide);

        slide = new Slide();
        slide.setTitle("The third slide");
        slide.appendTextItem(1, "To open a new presentation,");
        slide.appendTextItem(2, "use File->Open from the menu.");
        slide.appendTextItem(1, " ");
        slide.appendTextItem(1, "This is the end of the presentation.");
        slide.appendBitMapItem(1, "Default.png");
        presentation.append(slide);
    }

    public void saveFile(Presentation presentation, String unusedFilename) {
        throw new IllegalStateException("Save As->Demo! called");
    }
}
