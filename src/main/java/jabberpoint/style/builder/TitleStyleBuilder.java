package jabberpoint.style.builder;

import jabberpoint.style.styles.TitleStyle;

import java.awt.*;

/** <p>This is a TitleStyleBuilder, it implements StyleBuilder</p>
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class TitleStyleBuilder implements StyleBuilder {
    private int indent;
    private Color color;
    private int fontSize;
    private int leading;

    @Override
    public void setIndent(int indent) {
        this.indent = indent;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public void setLeading(int leading) {
        this.leading = leading;
    }


    public TitleStyle getResult() {
        return new TitleStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
