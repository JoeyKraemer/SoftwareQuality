package jabberpoint.style;

import jabberpoint.style.styles.Style;
import jabberpoint.style.builder.SubtitleStyleBuilder;
import jabberpoint.style.builder.TextStyleBuilder;
import jabberpoint.style.builder.TitleOneStyleBuilder;

public class StyleOptions {
    private final Director director;
    private final SubtitleStyleBuilder subtitleStyleBuilder;
    private final TitleOneStyleBuilder titleOneStyleBuilder;
    private final TextStyleBuilder textStyleBuilder;
    private final Style subtitle;
    private final Style titleOne;
    private final Style text;

    public StyleOptions() {
        this.director = new Director();
        this.subtitleStyleBuilder = new SubtitleStyleBuilder();
        this.titleOneStyleBuilder = new TitleOneStyleBuilder();
        this.textStyleBuilder = new TextStyleBuilder();

        this.director.constructSubtitleStyle(this.subtitleStyleBuilder);
        this.subtitle = this.subtitleStyleBuilder.getResult();

        this.director.constructTitleOneStyle(this.titleOneStyleBuilder);
        this.titleOne = this.titleOneStyleBuilder.getResult();

        this.director.constructTextStyle(this.textStyleBuilder);
        this.text = this.textStyleBuilder.getResult();
    }

    public Style getSubtitle() {
        return subtitle;
    }

    public Style getTitle() {
        return titleOne;
    }

    public Style getText() {
        return text;
    }
}
