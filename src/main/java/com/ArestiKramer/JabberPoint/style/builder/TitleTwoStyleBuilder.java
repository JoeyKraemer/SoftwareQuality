package com.ArestiKramer.JabberPoint.style.builder;

import com.ArestiKramer.JabberPoint.style.styles.TitleTwoStyle;

/**
 * <p>This is a TitleTwoStyleBuilder, it implements StyleBuilder</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TitleTwoStyleBuilder extends StyleBuilder<TitleTwoStyle>
{
    @Override
    public TitleTwoStyle build()
    {
        return new TitleTwoStyle(indent, color, fontSize, leading);
    }
}

