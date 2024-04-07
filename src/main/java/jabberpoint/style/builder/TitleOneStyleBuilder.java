package jabberpoint.style.builder;

import jabberpoint.style.builder.StyleBuilder;
import jabberpoint.style.styles.TitleOneStyle;

import java.awt.*;

/** <p>This is a TitleOneStyleBuilder, it implements StyleBuilder</p>
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TitleOneStyleBuilder implements StyleBuilder {
    private int indent;
    private Color color;
    private int fontSize;
    private int leading;

    @Override
    public void setIndent(int indent) {
        if (indent < 0) {
            throw new IllegalArgumentException("The indent can not be negative");
        }
        this.indent = indent;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setFontSize(int fontSize) {
        if (fontSize <= 0) {
            throw new IllegalArgumentException("The font size can not be zero or negative");
        }
        this.fontSize = fontSize;
    }

    @Override
    public void setLeading(int leading) {
        if (leading < 0) {
            throw new IllegalArgumentException("The leading can not be negative");
        }
        this.leading = leading;
    }


    public TitleOneStyle getResult() {
        return new TitleOneStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
