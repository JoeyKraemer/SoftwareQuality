package com.ArestiKramer.JabberPoint.slideitem.creator;

import com.ArestiKramer.JabberPoint.slideitem.SlideItem;
import com.ArestiKramer.JabberPoint.slideitem.items.TextItem;
import com.ArestiKramer.JabberPoint.style.styles.Style;

/**
 * <p>This is the TextItemCreator, it creates TextItems</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TextItemCreator extends SlideItemCreator
{
    @Override
    public SlideItem createSlideItem()
    {
        SlideItem item = new TextItem();

        return item.createSlideItem();
    }

    @Override
    public SlideItem createSlideItem(Style style, String string)
    {
        SlideItem item = new TextItem();

        return item.createSlideItem(style, string);
    }
}
