package com.ArestiKramer.JabberPoint.style.builder;

import com.ArestiKramer.JabberPoint.style.styles.TitleOneStyle;

/**
 * <p>This is a TitleOneStyleBuilder, it implements StyleBuilder</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TitleOneStyleBuilder extends StyleBuilder<TitleOneStyle>
{
    @Override
    public TitleOneStyle build()
    {
        return new TitleOneStyle(indent, color, fontSize, leading);
    }
}

