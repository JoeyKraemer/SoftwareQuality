package jabberpoint.slideitem;

import jabberpoint.Style;
import jabberpoint.slide.SlideIterator;

import java.awt.*;
import java.awt.image.ImageObserver;

public interface SlideItem {


    SlideItem createSlideItem();

    SlideItem createSlideItem(int level, String string);

    Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style style);

    void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer);

    SlideIterator createIterator();

}
