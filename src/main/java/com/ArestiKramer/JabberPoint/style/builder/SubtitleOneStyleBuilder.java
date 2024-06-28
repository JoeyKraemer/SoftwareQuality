package com.ArestiKramer.JabberPoint.style.builder;

import com.ArestiKramer.JabberPoint.style.styles.SubtitleOneStyle;

/**
 * <p>This is a SubtitleOneStyleBuilder, it implements StyleBuilder</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class SubtitleOneStyleBuilder extends StyleBuilder<SubtitleOneStyle>
{
    @Override
    public SubtitleOneStyle build()
    {
        return new SubtitleOneStyle(indent, color, fontSize, leading);
    }
}
