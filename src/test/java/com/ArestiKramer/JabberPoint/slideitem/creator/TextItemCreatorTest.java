package com.ArestiKramer.JabberPoint.slideitem.creator;

import com.ArestiKramer.JabberPoint.slideitem.SlideItem;
import com.ArestiKramer.JabberPoint.slideitem.items.TextItem;
import com.ArestiKramer.JabberPoint.style.styles.Style;
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
    void createTextSlideItem_createItem_slideItemExists() {
        SlideItem slideItem = textItemCreator.createSlideItem();

        assertNotNull(slideItem, "SlideItem should not be null");
        assertInstanceOf(TextItem.class, slideItem, "SlideItem should be an instance of TextItem");
    }

    @Test
    void createTextSlideItemWithStyle_createItem_slideItemExist() {
        Style mockStyle = mock(Style.class);
        String testString = "Test String";

        SlideItem slideItem = textItemCreator.createSlideItem(mockStyle, testString);

        assertNotNull(slideItem, "SlideItem should not be null");
        assertInstanceOf(TextItem.class, slideItem, "SlideItem should be an instance of TextItem");
        assertEquals(mockStyle, slideItem.getStyle(), "The style should match the one provided");
        assertEquals(testString, slideItem.getText(), "The text should match the one provided");
    }
}
