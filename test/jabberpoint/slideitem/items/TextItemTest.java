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
    void setup() {
        textItem = new TextItem();
    }

    @Test
    void createSlideItem_checkFileTypeAndText_instanceOfTextItem() {
        SlideItem slideItem = textItem.createSlideItem();

        assertNotNull(slideItem, "SlideItem should not be null");
        assertInstanceOf(TextItem.class, slideItem, "SlideItem should be an instance of TextItem");
        assertEquals("text", slideItem.getText(), "The text should be 'text'");
    }

    @Test
    void createSlideItemWithStyleAndText_checkFileTypeAndContent_instanceOfTextItemAndContentMatches() {
        Style mockStyle = mock(Style.class);
        String testText = "Test Text";

        SlideItem slideItem = textItem.createSlideItem(mockStyle, testText);

        assertNotNull(slideItem, "SlideItem should not be null");
        assertInstanceOf(TextItem.class, slideItem, "SlideItem should be an instance of TextItem");
        assertEquals(testText, slideItem.getText(), "The text should match the one provided");
        assertEquals(mockStyle, slideItem.getStyle(), "The style should match the one provided");
    }

    @Test
    void createSlideItemWithEmptyTextThrowsException_createWithoutText_exceptionThrown() {
        Style mockStyle = mock(Style.class);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            textItem.createSlideItem(mockStyle, "");
        });

        assertEquals("Image needs to be at least 1 character long", thrown.getMessage(), "Exception message should match expected message");
    }

    @Test
    void createSlideItemWithEmptyTextThrowsException_createWithoutStyle_exceptionThrown() {
        String testText = "Test Text";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            textItem.createSlideItem(null, testText);
        });

        assertEquals("Style cant be null", thrown.getMessage(), "Exception message should match expected message");
    }
}
