package jabberpoint.slideitem;

import jabberpoint.style.styles.Style;

import java.awt.*;
import java.awt.image.ImageObserver;

public interface SlideItem {

    SlideItem createSlideItem();

    SlideItem createSlideItem(Style style, String string);

    Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale);

    void draw(int x, int y, float scale, Graphics graphics, ImageObserver observer);

    Style getStyle();
}
