package com.ArestiKramer.JabberPoint.style;


import com.ArestiKramer.JabberPoint.style.builder.StyleBuilder;
import com.ArestiKramer.JabberPoint.style.styles.Style;

import java.awt.*;

/**
 * <p>This is the Director, through this class the creation of styles is requested</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class Director
{

    public <T extends Style> T constructStyle(StyleBuilder<T> builder, int indent, Color color, int fontSize, int leading)
    {
        return builder.setIndent(indent)
                .setColor(color)
                .setFontSize(fontSize)
                .setLeading(leading)
                .build();
    }

    public <T extends Style> T constructTitleOneStyle(StyleBuilder<T> builder)
    {
        return constructStyle(builder, 0, Color.green, 48, 20);
    }

    public <T extends Style> T constructTitleTwoStyle(StyleBuilder<T> builder)
    {
        return constructStyle(builder, 0, Color.red, 48, 20);
    }

    public <T extends Style> T constructSubtitleOneStyle(StyleBuilder<T> builder)
    {
        return constructStyle(builder, 20, Color.blue, 40, 10);
    }

    public <T extends Style> T constructSubtitleTwoStyle(StyleBuilder<T> builder)
    {
        return constructStyle(builder, 20, Color.pink, 40, 10);
    }

    public <T extends Style> T constructTextStyle(StyleBuilder<T> builder)
    {
        return constructStyle(builder, 50, Color.black, 36, 10);
    }
}
