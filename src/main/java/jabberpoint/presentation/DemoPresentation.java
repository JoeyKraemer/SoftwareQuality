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

public class DemoPresentation extends Accessor {

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
        slide.setTitle("Jabberpoint");
        slide.appendTextItem(titleOne, "The Java Presentation Tool");
        slide.appendTextItem(subtitleOne, "Copyright (c) 1996-2000: Ian Darwin");
        slide.appendTextItem(titleTwo, "Copyright (c) 2000-now:");
        slide.appendTextItem(subtitleTwo, "Gert Florijn andn Sylvia Stuurman");
        slide.appendTextItem(titleTwo, "New version:");
        slide.appendTextItem(subtitleTwo, "Caterina Aresti & Joey Kramer");
        slide.appendTextItem(text, "Starting JabberPoint without a filename");
        slide.appendTextItem(text, "shows this presentation");
        presentation.append(slide);

        slide = new Slide();
        slide.setTitle("Demonstration of stiles");
        slide.appendTextItem(titleOne, "This is title 1");
        slide.appendTextItem(subtitleOne, "This is subtitle 1");
        slide.appendTextItem(titleTwo, "This is title 2");
        slide.appendTextItem(subtitleTwo, "This is subtitle 2");
        slide.appendTextItem(text, "This is how text looks like");
        slide.appendTextItem(text, "This is text again");
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
