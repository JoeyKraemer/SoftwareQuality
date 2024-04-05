package jabberpoint.slideitem.items;

import jabberpoint.slide.Slide;
import jabberpoint.Style;
import jabberpoint.slide.iterator.Iterator;
import jabberpoint.slideitem.SlideItem;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.font.TextAttribute;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.List;
import java.util.ArrayList;

/**
 * <p>A tekst item.</p>
 * <p>A JabberPoint.JabberPoint.TextItem has drawingfunctionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class TextItem implements SlideItem {
    private String text;
    private int level;

    // "Constructor" without parameters
    @Override
    public SlideItem createSlideItem() {
        this.text = "text";
        this.level = 0;

        return this;
    }

    //"Constructor" with parameters
    @Override
    public SlideItem createSlideItem(int level, String text) {
        if (level < 0 || level > 5) {
            throw new IllegalArgumentException("Level must be between 0-5");
        }

        if (text.isEmpty()){
            throw new IllegalArgumentException("Image needs to be at least 1 character long")
        }

        this.text = text;
        this.level = level;
        return this;
    }

    public String getText() {
        return text;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public Iterator createIterator() {
        return null;
    }

    // give the bounding box of the item
    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style myStyle) {
        List<TextLayout> layouts = getLayouts(graphics, myStyle, scale);
        int xsize = 0, ysize = (int) (myStyle.leading * scale);
        java.util.Iterator<TextLayout> iterator = layouts.iterator();
        while (iterator.hasNext()) {
            TextLayout layout = iterator.next();
            Rectangle2D bounds = layout.getBounds();
            if (bounds.getWidth() > xsize) {
                xsize = (int) bounds.getWidth();
            }
            if (bounds.getHeight() > 0) {
                ysize += bounds.getHeight();
            }
            ysize += layout.getLeading() + layout.getDescent();
        }
        return new Rectangle((int) (myStyle.indent * scale), 0, xsize, ysize);
    }

    // draw the item
    @Override
    public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o) {

        List<TextLayout> layouts = getLayouts(g, myStyle, scale);
        Point pen = new Point(x + (int) (myStyle.indent * scale),
                y + (int) (myStyle.leading * scale));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(myStyle.color);
        java.util.Iterator<TextLayout> it = layouts.iterator();
        while (it.hasNext()) {
            TextLayout layout = it.next();
            pen.y += layout.getAscent();
            layout.draw(g2d, pen.x, pen.y);
            pen.y += layout.getDescent();
        }
    }

    // geef de AttributedString voor het item
    public AttributedString getAttributedString(Style style, float scale) {
        AttributedString attrStr = new AttributedString(getText());
        attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, this.text.length());
        return attrStr;
    }

    private List<TextLayout> getLayouts(Graphics graphics, Style style, float scale) {
        List<TextLayout> layouts = new ArrayList<TextLayout>();
        AttributedString attrStr = getAttributedString(style, scale);
        Graphics2D g2d = (Graphics2D) graphics;
        FontRenderContext frc = g2d.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
        float wrappingWidth = (Slide.WIDTH - style.indent) * scale;
        while (measurer.getPosition() < getText().length()) {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }
        return layouts;
    }

}
