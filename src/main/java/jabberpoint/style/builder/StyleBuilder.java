package jabberpoint.style.builder;

import jabberpoint.style.styles.Style;

import java.awt.*;

/**
 * <p>This is a StyleBuilder, it creates the steps to build a style</p>
 *
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public abstract class StyleBuilder
{
    protected int indent;
    protected Color color;
    protected int fontSize;
    protected int leading;

    public StyleBuilder()
    {
    }

    public void setIndent(int indent)
    {
        if (indent < 0)
        {
            throw new IllegalArgumentException("The indent can not be negative");
        }
        this.indent = indent;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public void setFontSize(int fontSize)
    {
        if (fontSize <= 0)
        {
            throw new IllegalArgumentException("The font size can not be zero or negative");
        }
        this.fontSize = fontSize;
    }

    public void setLeading(int leading)
    {
        if (leading < 0)
        {
            throw new IllegalArgumentException("The leading can not be negative");
        }
        this.leading = leading;
    }

    abstract Style getResult();
}
