package jabberpoint.style.builder;

import jabberpoint.style.styles.TitleOneStyle;
import jabberpoint.style.styles.TitleTwoStyle;

import java.awt.*;

/** <p>This is a TitleTwoStyleBuilder, it implements StyleBuilder</p>
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TitleTwoStyleBuilder implements StyleBuilder {
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

    public TitleTwoStyle getResult() {
        return new TitleTwoStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
