package com.ArestiKramer.JabberPoint.style.builder;

import com.ArestiKramer.JabberPoint.style.styles.Style;
import com.ArestiKramer.JabberPoint.style.styles.SubtitleTwoStyle;

/**
 * <p>This is a SubtitleTwoStyleBuilder, it implements StyleBuilder</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class SubtitleTwoStyleBuilder extends StyleBuilder
{

    public SubtitleTwoStyleBuilder()
    {
        super();
    }

    @Override
    public Style getResult()
    {
        return new SubtitleTwoStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
