package jabberpoint.style;

import jabberpoint.style.styles.Style;
import jabberpoint.style.builder.SubtitleStyleBuilder;
import jabberpoint.style.builder.TextStyleBuilder;
import jabberpoint.style.builder.TitleStyleBuilder;

/** <p>This is StyleOptions, it requests the creation of styles</p>
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class StyleOptions {
    private final Director director;
    private final SubtitleStyleBuilder subtitleStyleBuilder;
    private final TitleStyleBuilder titleStyleBuilder;
    private final TextStyleBuilder textStyleBuilder;
    private final Style subtitle;
    private final Style title;
    private final Style text;

    public StyleOptions() {
        this.director = new Director();
        this.subtitleStyleBuilder = new SubtitleStyleBuilder();
        this.titleStyleBuilder = new TitleStyleBuilder();
        this.textStyleBuilder = new TextStyleBuilder();

        this.director.constructSubtitleStyle(this.subtitleStyleBuilder);
        this.subtitle = this.subtitleStyleBuilder.getResult();

        this.director.constructTitleStyle(this.titleStyleBuilder);
        this.title = this.titleStyleBuilder.getResult();

        this.director.constructTextStyle(this.textStyleBuilder);
        this.text = this.textStyleBuilder.getResult();
    }

    public Style getSubtitle() {
        return subtitle;
    }

    public Style getTitle() {
        return title;
    }

    public Style getText() {
        return text;
    }
}
