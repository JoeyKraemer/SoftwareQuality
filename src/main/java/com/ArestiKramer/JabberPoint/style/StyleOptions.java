package com.ArestiKramer.JabberPoint.style;

import com.ArestiKramer.JabberPoint.style.builder.*;
import com.ArestiKramer.JabberPoint.style.styles.Style;

/**
 * <p>This is StyleOptions, it requests the creation of styles</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class StyleOptions
{
    private final Director director = new Director();
    private final Style subtitleOne;
    private final Style subtitleTwo;
    private final Style titleOne;
    private final Style titleTwo;
    private final Style text;

    public StyleOptions()
    {
        this.subtitleOne = director.constructSubtitleOneStyle(new SubtitleOneStyleBuilder());
        this.subtitleTwo = director.constructSubtitleTwoStyle(new SubtitleTwoStyleBuilder());
        this.titleOne = director.constructTitleOneStyle(new TitleOneStyleBuilder());
        this.titleTwo = director.constructTitleTwoStyle(new TitleTwoStyleBuilder());
        this.text = director.constructTextStyle(new TextStyleBuilder());
    }

    public Style getSubtitleOne()
    {
        return subtitleOne;
    }

    public Style getSubtitleTwo()
    {
        return subtitleTwo;
    }

    public Style getTitleOne()
    {
        return titleOne;
    }

    public Style getTitleTwo()
    {
        return titleTwo;
    }

    public Style getText()
    {
        return text;
    }
}