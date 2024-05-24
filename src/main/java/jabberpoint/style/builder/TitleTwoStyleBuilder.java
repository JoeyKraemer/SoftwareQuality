package jabberpoint.style.builder;

import jabberpoint.style.styles.Style;
import jabberpoint.style.styles.TitleOneStyle;
import jabberpoint.style.styles.TitleTwoStyle;

import java.awt.*;

/** <p>This is a TitleTwoStyleBuilder, it implements StyleBuilder</p>
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TitleTwoStyleBuilder extends StyleBuilder {

    public TitleTwoStyleBuilder() {
        super();
    }

    @Override
    public Style getResult() {
        return new TitleTwoStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
