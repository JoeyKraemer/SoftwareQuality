package com.ArestiKramer.JabberPoint.slideitem.items;

import com.ArestiKramer.JabberPoint.slideitem.SlideItem;
import com.ArestiKramer.JabberPoint.style.styles.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BitmapItemTest {
    private BitmapItem bitmapItem;

    @BeforeEach
    void setup() {
        bitmapItem = new BitmapItem();
    }

    @Test
    void createSlideItem_checkFileType_instanceOfBitmapItem() {
        SlideItem slideItem = bitmapItem.createSlideItem();

        assertNotNull(slideItem, "SlideItem should not be null");
        assertInstanceOf(BitmapItem.class, slideItem, "SlideItem should be an instance of BitmapItem");
        assertEquals("Default.png",slideItem.getText(), "The image name should be 'Default.png'");
    }

    @Test
    void createSlideItem_checkFileTypeAndImage_instanceOfBitmapItem() {
        Style mockStyle = mock(Style.class);
        String testImageName = "Default.png";

        SlideItem slideItem = bitmapItem.createSlideItem(mockStyle, testImageName);

        assertNotNull(slideItem, "SlideItem should not be null");
        assertInstanceOf(BitmapItem.class, slideItem, "SlideItem should be an instance of BitmapItem");
        assertEquals(testImageName, slideItem.getText(), "The image name should match the one provided");
        assertEquals(mockStyle, slideItem.getStyle(), "The style should match the one provided");
    }

    @Test
    void createBitmapSlideItem_shortImageName_throwsException() {
        Style mockStyle = mock(Style.class);
        String shortImageName = "Img";

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            bitmapItem.createSlideItem(mockStyle, shortImageName);
        });

        assertEquals("Image needs to be at least 4 character long", thrown.getMessage(), "Exception message should match expected message");
    }

    @Test
    void getBoundingBox_compareRectangles_noExceptionThrown() {
        Graphics mockGraphics = mock(Graphics.class);
        ImageObserver mockObserver = mock(ImageObserver.class);
        Style mockStyle = mock(Style.class);

        when(mockStyle.getIndent()).thenReturn(10);
        when(mockStyle.getLeading()).thenReturn(20);

        BufferedImage mockImage = new BufferedImage(1200, 1620, BufferedImage.TYPE_INT_ARGB);
        bitmapItem.createSlideItem(mockStyle, "Default.png");
        bitmapItem = spy(bitmapItem);
        doReturn(mockImage).when(bitmapItem).getBufferedImage();

        Rectangle boundingBox = bitmapItem.getBoundingBox(mockGraphics, mockObserver, 1.0f);

        assertEquals(new Rectangle(10, 0, 1200, 1620), boundingBox, "BoundingBox should match expected values");
    }
}
