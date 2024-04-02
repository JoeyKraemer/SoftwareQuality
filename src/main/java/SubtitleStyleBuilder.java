import java.awt.*;

public class SubtitleStyleBuilder implements StyleBuilder{

    private int indent;
    private Color color;
    private int fontSize;
    private int leading;

    public SubtitleStyleBuilder() {
        this.indent = 20;
        this.color = Color.blue;
        this.fontSize = 40;
        this.leading = 10;
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
