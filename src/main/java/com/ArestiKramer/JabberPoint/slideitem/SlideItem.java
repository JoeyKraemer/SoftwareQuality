package com.ArestiKramer.JabberPoint.slideitem;

import com.ArestiKramer.JabberPoint.style.styles.Style;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 * <p>This is the SlideItem, it's implemented in its subclasses</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public interface SlideItem
{

    SlideItem createSlideItem();

    SlideItem createSlideItem(Style style, String string);

    Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale);

    void draw(int x, int y, float scale, Graphics graphics, ImageObserver observer);

    Style getStyle();

    String getText();

    BufferedImage getBufferedImage();
}
