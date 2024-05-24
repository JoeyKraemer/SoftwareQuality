package jabberpoint.style.builder;

import jabberpoint.style.styles.Style;
import jabberpoint.style.styles.TextStyle;

import java.awt.*;

/** <p>This is a TextStyleBuilder, it implements StyleBuilder</p>
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TextStyleBuilder extends StyleBuilder {

    public TextStyleBuilder() {
        super();
    }

    @Override
    public Style getResult() {
        return new TextStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
