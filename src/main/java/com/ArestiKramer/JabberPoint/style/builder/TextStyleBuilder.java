package com.ArestiKramer.JabberPoint.style.builder;

import com.ArestiKramer.JabberPoint.style.styles.TextStyle;

/**
 * <p>This is a TextStyleBuilder, it implements StyleBuilder</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TextStyleBuilder extends StyleBuilder<TextStyle>
{
    @Override
    public TextStyle build()
    {
        return new TextStyle(indent, color, fontSize, leading);
    }
}
