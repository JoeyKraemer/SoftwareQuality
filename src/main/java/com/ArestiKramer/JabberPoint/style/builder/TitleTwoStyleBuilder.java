package com.ArestiKramer.JabberPoint.style.builder;

import com.ArestiKramer.JabberPoint.style.styles.Style;
import com.ArestiKramer.JabberPoint.style.styles.TitleTwoStyle;

/**
 * <p>This is a TitleTwoStyleBuilder, it implements StyleBuilder</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TitleTwoStyleBuilder extends StyleBuilder
{

    public TitleTwoStyleBuilder()
    {
        super();
    }

    @Override
    public Style getResult()
    {
        return new TitleTwoStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
