package com.ArestiKramer.JabberPoint.slide.iterator;

import com.ArestiKramer.JabberPoint.slideitem.SlideItem;

import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * <p>This is the SlideItemIterator, it iterates through a Slide's slideItems</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class SlideItemIterator implements Iterator
{

    private int currentPosition;
    private final Vector<SlideItem> slideItems;

    public SlideItemIterator(Vector<SlideItem> slideItems)
    {
        this.currentPosition = 0;
        this.slideItems = slideItems;
    }

    @Override
    public boolean hasNext()
    {
        return currentPosition < slideItems.size();
    }

    @Override
    public SlideItem next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        }
        return slideItems.get(currentPosition++);
    }
}
