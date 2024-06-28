package com.ArestiKramer.JabberPoint.style.builder;

import com.ArestiKramer.JabberPoint.style.styles.Style;

import java.awt.*;

/**
 * <p>This is a StyleBuilder, it creates the steps to build a style</p>
 *
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public abstract class StyleBuilder<T extends Style>
{
    protected int indent;
    protected Color color;
    protected int fontSize;
    protected int leading;

    public StyleBuilder()
    {
    }

    public StyleBuilder<T> setIndent(int indent)
    {
        if (indent < 0)
        {
            throw new IllegalArgumentException("The indent can not be negative");
        }
        this.indent = indent;
        return this;
    }

    public StyleBuilder<T> setColor(Color color)
    {
        this.color = color;
        return this;
    }

    public StyleBuilder<T> setFontSize(int fontSize)
    {
        if (fontSize <= 0)
        {
            throw new IllegalArgumentException("The font size can not be zero or negative");
        }
        this.fontSize = fontSize;
        return this;
    }

    public StyleBuilder<T> setLeading(int leading)
    {
        if (leading < 0)
        {
            throw new IllegalArgumentException("The leading can not be negative");
        }
        this.leading = leading;
        return this;
    }

    public abstract T build();

}
