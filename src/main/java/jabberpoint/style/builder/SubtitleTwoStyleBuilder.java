package jabberpoint.style.builder;

import jabberpoint.style.styles.SubtitleTwoStyle;
import java.awt.*;

public class SubtitleTwoStyleBuilder implements StyleBuilder {

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

    public SubtitleTwoStyle getResult() {
        return new SubtitleTwoStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
