package com.ArestiKramer.JabberPoint.slideviewer;

import com.ArestiKramer.JabberPoint.presentation.Presentation;
import com.ArestiKramer.JabberPoint.slide.Slide;
import com.ArestiKramer.JabberPoint.style.styles.Style;
import com.ArestiKramer.JabberPoint.style.StyleOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SlideViewerComponentTest {

    private Presentation presentation;
    private Slide slide;
    private SlideViewerComponent slideViewerComponent;
    private JFrame frame;
    private Style style;

    @BeforeEach
    public void setup() {
        presentation = new Presentation();
        slide = new Slide();
        frame = mock(JFrame.class);
        slideViewerComponent = new SlideViewerComponent(presentation, frame);

        StyleOptions styleOptions = new StyleOptions();
        style = styleOptions.getSubtitleOne();
    }

    @Test
    public void getPreferredSize_defaultSize_correctDimensions() {
        Dimension preferredSize = slideViewerComponent.getPreferredSize();
        assertEquals(Slide.WIDTH, preferredSize.width);
        assertEquals(Slide.HEIGHT, preferredSize.height);
    }

    @Test
    public void update_withValidPresentationAndSlide_updatesComponents() {
        String testTitle = "Test Presentation";
        presentation.setTitle(testTitle);
        slideViewerComponent.update(presentation, slide);

        assertEquals(presentation, slideViewerComponent.getPresentation());
        assertEquals(slide, slideViewerComponent.getSlide());
        verify(frame).setTitle(testTitle);
    }

    @Test
    public void setAndGetLabelFont_updatesAndReturnsFont() {
        Font newFont = new Font("Serif", Font.PLAIN, 12);
        slideViewerComponent.setLabelFont(newFont);

        assertEquals(newFont, slideViewerComponent.getLabelFont());
    }

    @Test
    public void setAndGetFrame_updatesAndReturnsFrame() {
        JFrame newFrame = mock(JFrame.class);
        slideViewerComponent.setFrame(newFrame);

        assertEquals(newFrame, slideViewerComponent.getFrame());
    }

    @Test
    public void setAndGetPresentation_updatesAndReturnsPresentation() {
        Presentation newPresentation = new Presentation();
        slideViewerComponent.setPresentation(newPresentation);

        assertEquals(newPresentation, slideViewerComponent.getPresentation());
    }

    @Test
    public void setAndGetSlide_updatesAndReturnsSlide() {
        Slide newSlide = new Slide();
        slideViewerComponent.setSlide(newSlide);

        assertEquals(newSlide, slideViewerComponent.getSlide());
    }
}