package jabberpoint.slideitem.items;

import jabberpoint.slide.Slide;
import jabberpoint.slideitem.SlideItem;
import jabberpoint.style.StyleOptions;
import jabberpoint.style.styles.Style;

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
 * <p>This is a textItem</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class TextItem implements SlideItem {
    private String text;
    private Style style;

    // "Constructor" without parameters
    @Override
    public SlideItem createSlideItem() {
        this.text = "text";

        StyleOptions tempStyle = new StyleOptions();
        this.style = tempStyle.getText();

        return this;
    }

    //"Constructor" with parameters
    @Override
    public SlideItem createSlideItem(Style style, String text) {
        if (text.isEmpty()){
            throw new IllegalArgumentException("Image needs to be at least 1 character long");
        }

        this.text = text;

        StyleOptions tempStyle = new StyleOptions();
        this.style = tempStyle.getText();

        return this;
    }

    public String getText() {
        return text;
    }

    // give the bounding box of the item
    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale) {
        List<TextLayout> layouts = getLayouts(graphics, this.style, scale);
        int xsize = 0, ysize = (int) (this.style.getLeading() * scale);
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
        return new Rectangle((int) (style.getIndent() * scale), 0, xsize, ysize);
    }

    // draw the item
    @Override
    public void draw(int x, int y, float scale, Graphics graphics, ImageObserver observer) {

        List<TextLayout> layouts = getLayouts(graphics, this.style, scale);

        Point pen = new Point(x + (int) (this.style.getIndent() * scale), y + (int) (this.style.getLeading() * scale));
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(this.style.getColor());
        java.util.Iterator<TextLayout> it = layouts.iterator();

        while (it.hasNext()) {
            TextLayout layout = it.next();
            pen.y += layout.getAscent();
            layout.draw(g2d, pen.x, pen.y);
            pen.y += layout.getDescent();
        }
    }

    @Override
    public Style getStyle() {
        return this.style;
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
        float wrappingWidth = (Slide.WIDTH - style.getIndent()) * scale;

        while (measurer.getPosition() < getText().length()) {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }

        return layouts;
    }

}
