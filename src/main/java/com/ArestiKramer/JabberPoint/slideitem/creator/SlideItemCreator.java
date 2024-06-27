package com.ArestiKramer.JabberPoint.slideitem.creator;

import com.ArestiKramer.JabberPoint.slideitem.SlideItem;
import com.ArestiKramer.JabberPoint.style.styles.Style;

/**
 * <p>This is the SlideItemCreator, it creates SlideItems</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public abstract class SlideItemCreator
{

    public abstract SlideItem createSlideItem();

    public abstract SlideItem createSlideItem(Style style, String string);

}
