package jabberpoint.style;

import java.awt.*;

public abstract class Style {
    protected int indent;
    protected Color color;
    protected int fontSize;
    protected int leading;

    public Style(int indent, Color color, int fontSize, int leading) {
        this.indent = indent;
        this.color = color;
        this.fontSize = fontSize;
        this.leading = leading;
    }

    public int getIndent() {
        return indent;
    }

    public Color getColor() {
        return color;
    }

    public int getFontSize() {
        return fontSize;
    }

    public int getLeading() {
        return leading;
    }
}
