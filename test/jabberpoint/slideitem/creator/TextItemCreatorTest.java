package jabberpoint.slideitem.creator;

import jabberpoint.slideitem.SlideItem;
import jabberpoint.slideitem.items.TextItem;
import jabberpoint.style.styles.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TextItemCreatorTest {
    private TextItemCreator textItemCreator;

    @BeforeEach
    void setup() {
        textItemCreator = new TextItemCreator();
    }

    @Test
    void createSlideItem_createItem_slideItemExists() {
        SlideItem slideItem = textItemCreator.createSlideItem();

        assertNotNull(slideItem, "SlideItem should not be null");
        assertInstanceOf(TextItem.class, slideItem, "SlideItem should be an instance of TextItem");
    }

    @Test
    void createSlideItemWithStyle_createItem_slideItemExist() {
        Style mockStyle = mock(Style.class);
        String testString = "Test String";

        SlideItem slideItem = textItemCreator.createSlideItem(mockStyle, testString);

        assertNotNull(slideItem, "SlideItem should not be null");
        assertInstanceOf(TextItem.class, slideItem, "SlideItem should be an instance of TextItem");

        assertEquals(mockStyle, ((TextItem) slideItem).getStyle(), "The style should match the one provided");
        assertEquals(testString, ((TextItem) slideItem).getText(), "The text should match the one provided");
    }
}
