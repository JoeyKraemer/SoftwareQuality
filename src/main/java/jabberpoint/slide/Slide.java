package jabberpoint.slide;

import jabberpoint.slide.iterator.SlideItemIterator;
import jabberpoint.slideitem.SlideItem;
import jabberpoint.slideitem.creator.BitmapItemCreator;
import jabberpoint.slideitem.creator.SlideItemCreator;
import jabberpoint.slideitem.creator.TextItemCreator;
import jabberpoint.style.StyleOptions;
import jabberpoint.style.styles.Style;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * <p>This is a slide. This class has a drawing functionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class Slide
{
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    private String title; // title is saved separately
    private final Vector<SlideItem> slideItems; // slide items are saved in a Vector
    private final StyleOptions styleOptions;

    public Slide()
    {
        this.slideItems = new Vector<SlideItem>();
        this.title = "Example Name";

        this.styleOptions = new StyleOptions();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    public SlideItem getSpecificSlideItem(int number)
    {
        return this.slideItems.elementAt(number);
    }

    public Vector<SlideItem> getSlideItems()
    {
        return this.slideItems;
    }

    private void appendTextItem(SlideItem anItem)
    {
        this.slideItems.addElement(anItem);
    }

    public void appendBitMapItem(Style style, String imageName)
    {
        SlideItemCreator item = new BitmapItemCreator();
        appendTextItem(item.createSlideItem(style, imageName));
    }

    public void appendTextItem(Style style, String text)
    {
        SlideItemCreator item = new TextItemCreator();
        appendTextItem(item.createSlideItem(style, text));
    }

    public void draw(Graphics graphics, Rectangle area, ImageObserver observer)
    {
        float scale = getScale(area);
        SlideItemIterator iterator = new SlideItemIterator(this.slideItems);

        Style titleStyle = styleOptions.getTitleOne();
        SlideItemCreator titleItem = new TextItemCreator();
        SlideItem title = titleItem.createSlideItem(titleStyle, this.title);

        title.draw(area.x, area.y, scale, graphics, observer);
        area.y += title.getBoundingBox(graphics, observer, scale).height;

        //iterator
        while (iterator.hasNext())
        {
            SlideItem item = iterator.next();

            item.draw(area.x, area.y, scale, graphics, observer);
            area.y += item.getBoundingBox(graphics, observer, scale).height;
        }
    }

    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }
}
