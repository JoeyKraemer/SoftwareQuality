package jabberpoint.style.builder;

import jabberpoint.style.styles.Style;
import jabberpoint.style.styles.SubtitleOneStyle;

/**
 * <p>This is a SubtitleOneStyleBuilder, it implements StyleBuilder</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class SubtitleOneStyleBuilder extends StyleBuilder
{

    public SubtitleOneStyleBuilder()
    {
        super();
    }

    @Override
    public Style getResult()
    {
        return new SubtitleOneStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
