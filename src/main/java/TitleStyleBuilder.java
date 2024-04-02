import java.awt.*;

public class TitleStyleBuilder implements StyleBuilder {
    private int indent;
    private Color color;
    private int fontSize;
    private int leading;

    public TitleStyleBuilder() {
        this.indent = 0;
        this.color = Color.red;
        this.fontSize = 48;
        this.leading = 20;
    }

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

    @Override
    public Style createStyle() {
        return new TitleStyle(this.indent, this.color, this.fontSize, this.leading);
    }
}
