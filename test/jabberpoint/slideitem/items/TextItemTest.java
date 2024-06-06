package jabberpoint.slideitem.items;

import jabberpoint.slideitem.SlideItem;
import jabberpoint.style.styles.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TextItemTest {
    private TextItem textItem;

    @BeforeEach
    void setUp() {
        textItem = new TextItem();
    }

    @Test
    void testCreateSlideItem() {
        SlideItem slideItem = textItem.createSlideItem();

        assertNotNull(slideItem, "SlideItem should not be null");
        assertTrue(slideItem instanceof TextItem, "SlideItem should be an instance of TextItem");
        assertEquals("text", ((TextItem) slideItem).getText(), "The text should be 'text'");
    }

    @Test
    void testCreateSlideItemWithStyleAndText() {
        Style mockStyle = mock(Style.class);
        String testText = "Test Text";

        SlideItem slideItem = textItem.createSlideItem(mockStyle, testText);

        assertNotNull(slideItem, "SlideItem should not be null");
        assertTrue(slideItem instanceof TextItem, "SlideItem should be an instance of TextItem");
        assertEquals(testText, ((TextItem) slideItem).getText(), "The text should match the one provided");
        assertEquals(mockStyle, ((TextItem) slideItem).getStyle(), "The style should match the one provided");
    }

    @Test
    void testCreateSlideItemWithEmptyTextThrowsException() {
        Style mockStyle = mock(Style.class);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            textItem.createSlideItem(mockStyle, "");
        });

        assertEquals("Image needs to be at least 1 character long", thrown.getMessage(), "Exception message should match expected message");
    }

    @Test
    void testCreateSlideItemWithNullStyleThrowsException() {
        String testText = "Test Text";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            textItem.createSlideItem(null, testText);
        });

        assertEquals("Style cant be null", thrown.getMessage(), "Exception message should match expected message");
    }

    @Test
    void testGetBoundingBox() {
        Graphics mockGraphics = mock(Graphics.class);
        ImageObserver mockObserver = mock(ImageObserver.class);
        Style mockStyle = mock(Style.class);

        when(mockStyle.getIndent()).thenReturn(10);
        when(mockStyle.getLeading()).thenReturn(20);
        when(mockStyle.getColor()).thenReturn(Color.BLACK);

        textItem.createSlideItem(mockStyle, "Test Text");

        Rectangle boundingBox = textItem.getBoundingBox(mockGraphics, mockObserver, 1.0f);

        assertNotNull(boundingBox, "BoundingBox should not be null");
        assertTrue(boundingBox.width > 0, "BoundingBox width should be greater than 0");
        assertTrue(boundingBox.height > 0, "BoundingBox height should be greater than 0");
    }

    @Test
    void testDraw() {
        Graphics mockGraphics = mock(Graphics.class);
        ImageObserver mockObserver = mock(ImageObserver.class);
        Style mockStyle = mock(Style.class);

        when(mockStyle.getIndent()).thenReturn(10);
        when(mockStyle.getLeading()).thenReturn(20);
        when(mockStyle.getColor()).thenReturn(Color.BLACK);

        textItem.createSlideItem(mockStyle, "Test Text");

        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        textItem.draw(0, 0, 1.0f, g2d, mockObserver);

        verify(mockGraphics, never()).drawString(anyString(), anyInt(), anyInt());
    }
}
