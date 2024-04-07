package jabberpoint.presentation;

import jabberpoint.accessor.Accessor;
import jabberpoint.slide.Slide;
import jabberpoint.style.StyleOptions;
import jabberpoint.style.styles.Style;

/**
 * <p>This is a built-in demo presentation</p>
 *
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

class DemoPresentation extends Accessor {

    public void loadFile(Presentation presentation, String unusedFilename) {
        StyleOptions styleOptions = new StyleOptions();
        Style titleOne = styleOptions.getTitleOne();
        Style titleTwo = styleOptions.getTitleTwo();
        Style subtitleOne = styleOptions.getSubtitleOne();
        Style subtitleTwo = styleOptions.getSubtitleTwo();
        Style text = styleOptions.getText();

        System.out.println(titleOne.getFontSize());

        presentation.setTitle("Demo Presentation");
        Slide slide;
        slide = new Slide();
        slide.setTitle("jabberpoint");
        slide.appendTextItem(titleOne, "The Java Presentation Tool");
        slide.appendTextItem(titleTwo, "Copyright (c) 1996-2000: Ian Darwin");
        slide.appendTextItem(subtitleOne, "Copyright (c) 2000-now:");
        slide.appendTextItem(subtitleTwo, "Gert Florijn andn Sylvia Stuurman");
        slide.appendTextItem(text, "Starting JabberPoint without a filename");
        slide.appendTextItem(text, "shows this presentation");
        slide.appendTextItem(titleOne, "Navigate:");
        slide.appendTextItem(text, "Next slide: PgDn or Enter");
        slide.appendTextItem(text, "Previous slide: PgUp or up-arrow");
        slide.appendTextItem(text, "Quit: q or Q");
        presentation.append(slide);

        slide = new Slide();
        slide.setTitle("Demonstration of levels and stijlen");
        slide.appendTextItem(titleOne, "Level 1");
        slide.appendTextItem(subtitleOne, "Level 2");
        slide.appendTextItem(titleOne, "Again level 1");
        slide.appendTextItem(titleOne, "Level 1 has style number 1");
        slide.appendTextItem(titleOne, "Level 2 has style number  2");
        slide.appendTextItem(text, "This is how level 3 looks like");
        slide.appendTextItem(text, "And this is level 4");
        presentation.append(slide);

        slide = new Slide();
        slide.setTitle("The third slide");
        slide.appendTextItem(titleOne, "To open a new presentation,");
        slide.appendTextItem(subtitleOne, "use File->Open from the menu.");
        slide.appendTextItem(titleOne, " ");
        slide.appendTextItem(titleOne, "This is the end of the presentation.");
        slide.appendBitMapItem(titleOne, "Default.png");
        presentation.append(slide);
    }

    public void saveFile(Presentation presentation, String unusedFilename) {
        throw new IllegalStateException("Save As->Demo! called");
    }
}
