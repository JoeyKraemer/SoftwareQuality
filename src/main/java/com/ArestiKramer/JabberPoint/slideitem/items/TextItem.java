package com.ArestiKramer.JabberPoint.slideitem.items;

import com.ArestiKramer.JabberPoint.slide.Slide;
import com.ArestiKramer.JabberPoint.slideitem.SlideItem;
import com.ArestiKramer.JabberPoint.style.StyleOptions;
import com.ArestiKramer.JabberPoint.style.styles.Style;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>This is a textItem</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class TextItem implements SlideItem
{
    private String text;
    private Style style;

    @Override
    public SlideItem createSlideItem()
    {
        this.text = "text";

        StyleOptions tempStyle = new StyleOptions();
        this.style = tempStyle.getText();

        return this;
    }

    @Override
    public SlideItem createSlideItem(Style style, String text)
    {
        if (text.isEmpty())
        {
            throw new IllegalArgumentException("Image needs to be at least 1 character long");
        }

        if (style == null)
        {
            throw new IllegalArgumentException("Style cant be null");
        }

        this.text = text;
        this.style = style;

        return this;
    }

    @Override
    public String getText()
    {
        return text;
    }

    @Override
    public BufferedImage getBufferedImage()
    {
        return null;
    }

    @Override
    public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale)
    {
        List<TextLayout> layouts = getLayouts(graphics, this.style, scale);
        int xsize = 0, ysize = (int) (this.style.getLeading() * scale);
        java.util.Iterator<TextLayout> iterator = layouts.iterator();
        while (iterator.hasNext())
        {
            TextLayout layout = iterator.next();
            Rectangle2D bounds = layout.getBounds();
            if (bounds.getWidth() > xsize)
            {
                xsize = (int) bounds.getWidth();
            }
            if (bounds.getHeight() > 0)
            {
                ysize += bounds.getHeight();
            }
            ysize += layout.getLeading() + layout.getDescent();
        }
        return new Rectangle((int) (style.getIndent() * scale), 0, xsize, ysize);
    }

    @Override
    public void draw(int x, int y, float scale, Graphics graphics, ImageObserver observer)
    {

        List<TextLayout> layouts = getLayouts(graphics, this.style, scale);

        Point pen = new Point(x + (int) (this.style.getIndent() * scale), y + (int) (this.style.getLeading() * scale));
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(this.style.getColor());
        java.util.Iterator<TextLayout> it = layouts.iterator();

        while (it.hasNext())
        {
            TextLayout layout = it.next();
            pen.y += layout.getAscent();
            layout.draw(g2d, pen.x, pen.y);
            pen.y += layout.getDescent();
        }
    }

    @Override
    public Style getStyle()
    {
        return this.style;
    }

    public AttributedString getAttributedString(Style style, float scale)
    {
        AttributedString attrStr = new AttributedString(getText());
        attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, this.text.length());
        return attrStr;
    }

    private List<TextLayout> getLayouts(Graphics graphics, Style style, float scale)
    {
        List<TextLayout> layouts = new ArrayList<TextLayout>();
        AttributedString attrStr = getAttributedString(style, scale);
        Graphics2D g2d = (Graphics2D) graphics;
        FontRenderContext frc = g2d.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
        float wrappingWidth = (Slide.WIDTH - style.getIndent()) * scale;

        while (measurer.getPosition() < getText().length())
        {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            layouts.add(layout);
        }

        return layouts;
    }
}
