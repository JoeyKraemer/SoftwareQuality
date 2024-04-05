package jabberpoint.style.builder;

import jabberpoint.style.styles.TextStyle;

import java.awt.*;

public class TextStyleBuilder implements StyleBuilder {
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

    public TextStyle getResult() {
        return new TextStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
