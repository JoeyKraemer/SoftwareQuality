package jabberpoint.style.builder;

import jabberpoint.style.styles.Style;
import jabberpoint.style.styles.TitleOneStyle;

/**
 * <p>This is a TitleOneStyleBuilder, it implements StyleBuilder</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TitleOneStyleBuilder extends StyleBuilder
{

    public TitleOneStyleBuilder()
    {
        super();
    }

    @Override
    public Style getResult()
    {
        return new TitleOneStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
