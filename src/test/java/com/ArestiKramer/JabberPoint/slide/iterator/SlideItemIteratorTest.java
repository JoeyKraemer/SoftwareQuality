package com.ArestiKramer.JabberPoint.slide.iterator;

import com.ArestiKramer.JabberPoint.slideitem.SlideItem;
import com.ArestiKramer.JabberPoint.slideitem.items.BitmapItem;
import com.ArestiKramer.JabberPoint.slideitem.items.TextItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class SlideItemIteratorTest {

    private Vector<SlideItem> slideItems;
    private SlideItemIterator iterator;
    private SlideItem slideItem1;
    private SlideItem slideItem2;

    @BeforeEach
    public void setup() {
        slideItems = new Vector<>();
        slideItem1 = new BitmapItem();
        slideItem2 = new TextItem();
    }

    @Test
    public void hasNext_WithTwoItems_FalseOnThirdHasNext() {
        slideItems.add(slideItem1);
        slideItems.add(slideItem2);
        iterator = new SlideItemIterator(slideItems);

        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void next_hasNoItems_NoSuchElementException() {
        iterator = new SlideItemIterator(slideItems);

        assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testIterator_resetIterator_startsFromBeginning() {
        slideItems.add(slideItem1);
        slideItems.add(slideItem2);
        iterator = new SlideItemIterator(slideItems);

        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());

        // Reset iterator
        iterator = new SlideItemIterator(slideItems);

        assertTrue(iterator.hasNext());
        assertEquals(slideItem1, iterator.next());
    }
}
