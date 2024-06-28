package com.ArestiKramer.JabberPoint.slideitem.creator;

import com.ArestiKramer.JabberPoint.slideitem.SlideItem;
import com.ArestiKramer.JabberPoint.slideitem.items.BitmapItem;
import com.ArestiKramer.JabberPoint.style.styles.Style;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BitmapItemCreatorTest {
    private BitmapItemCreator bitmapItemCreator;

    @BeforeEach
    void setUp() {
        bitmapItemCreator = new BitmapItemCreator();
    }

    @Test
    void createBitmapSlideItem_createItem_slideItemExists() {
        SlideItem slideItem = bitmapItemCreator.createSlideItem();

        assertNotNull(slideItem, "SlideItem should not be null");
        assertInstanceOf(BitmapItem.class, slideItem, "SlideItem should be an instance of BitmapItem");
    }

    @Test
    void createBitmapSlideItemWithStyle_createItem_slideItemExist() {
        Style mockStyle = mock(Style.class);
        String testString = "Default.png";

        SlideItem slideItem = bitmapItemCreator.createSlideItem(mockStyle, testString);

        assertNotNull(slideItem, "SlideItem should not be null");
        assertInstanceOf(BitmapItem.class, slideItem, "SlideItem should be an instance of BitmapItem");
        assertEquals(mockStyle, slideItem.getStyle(), "The style should match the one provided");
    }
}