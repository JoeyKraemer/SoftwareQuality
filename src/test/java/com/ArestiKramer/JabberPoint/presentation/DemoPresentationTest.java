package com.ArestiKramer.JabberPoint.presentation;

import com.ArestiKramer.JabberPoint.slide.Slide;
import com.ArestiKramer.JabberPoint.slideitem.SlideItem;
import com.ArestiKramer.JabberPoint.slideitem.items.TextItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoPresentationTest {

    private DemoPresentation demoPresentation;
    private Presentation presentation;

    @BeforeEach
    void setUp() {
        demoPresentation = new DemoPresentation();
        presentation = new Presentation();
    }

    @Test
    void testLoadFile() {
        demoPresentation.loadFile(presentation, null);

        assertEquals("Demo Presentation", presentation.getTitle());
        assertEquals(3, presentation.getSize());

        Slide slide1 = presentation.getSlide(0);

        assertEquals("Jabberpoint", slide1.getTitle());
        assertEquals(8, slide1.getSlideItems().size());

        checkTextItem(slide1.getSlideItems().get(0), "The Java Presentation Tool");


        Slide slide2 = presentation.getSlide(1);

        assertEquals("Demonstration of stiles", slide2.getTitle());
        assertEquals(6, slide2.getSlideItems().size());

        checkTextItem(slide2.getSlideItems().get(0), "This is title 1");

        Slide slide3 = presentation.getSlide(2);

        assertEquals("The third slide", slide3.getTitle());
        assertEquals(5, slide3.getSlideItems().size());

        checkTextItem(slide3.getSlideItems().get(0), "To open a new presentation,");
    }

    @Test
    void testSaveFile() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            demoPresentation.saveFile(presentation, null);
        });
        assertEquals("Save As->Demo! called", exception.getMessage());
    }

    private void checkTextItem(SlideItem slideItem, String expectedText) {
        assertTrue(slideItem instanceof TextItem);
        TextItem textItem = (TextItem) slideItem;
        assertEquals(expectedText, textItem.getText());
    }
}