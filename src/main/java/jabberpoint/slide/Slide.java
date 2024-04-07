package jabberpoint.slide;

import jabberpoint.slide.iterator.SlideItemIterator;
import jabberpoint.slideitem.SlideItem;
import jabberpoint.slideitem.items.BitmapItem;
import jabberpoint.slideitem.items.TextItem;

import jabberpoint.style.*;
import jabberpoint.style.styles.Style;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * <p>This is a slide. This class has a drawing functionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class Slide {
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    private String title; // title is saved separately
    private Vector<SlideItem> slideItems; // slide items are saved in a Vector
    private StyleOptions styleOptions;

    public Slide() {
        this.slideItems = new Vector<SlideItem>();
        this.title = "Example Name";

        this.styleOptions = new StyleOptions();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public SlideItem getSpecificSlideItem(int number) {
        return this.slideItems.elementAt(number);
    }

    public Vector<SlideItem> getSlideItems() {
        return this.slideItems;
    }

    // Add a slide item
    private void appendTextItem(SlideItem anItem) {
        this.slideItems.addElement(anItem);
    }

    public void appendBitMapItem(Style style, String imageName) {
        SlideItem item = new BitmapItem();
        appendTextItem(item.createSlideItem(style, imageName));
    }

    public void appendTextItem(Style style, String text) {
        SlideItem item = new TextItem();
        appendTextItem(item.createSlideItem(style, text));
    }

    // draw the slide
    public void draw(Graphics graphics, Rectangle area, ImageObserver observer) {
        float scale = getScale(area);
        SlideItemIterator iterator = new SlideItemIterator(this.slideItems);

        Style titleStyle = styleOptions.getTitleOne();
        SlideItem titleItem = new TextItem();
        titleItem.createSlideItem(titleStyle, this.title);

        titleItem.draw(area.x, area.y, scale, graphics, observer);
        area.y += titleItem.getBoundingBox(graphics, observer, scale).height;

        //iterator
        while(iterator.hasNext()){
            SlideItem item = iterator.next();

            item.draw(area.x, area.y, scale, graphics, observer);
            area.y += item.getBoundingBox(graphics, observer, scale).height;
        }
    }

    // Give the scale for drawing
    private float getScale(Rectangle area) {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }
}
