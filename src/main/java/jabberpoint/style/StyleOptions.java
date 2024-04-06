package jabberpoint.style;

import jabberpoint.style.builder.TitleTwoStyleBuilder;
import jabberpoint.style.styles.Style;
import jabberpoint.style.builder.SubtitleOneStyleBuilder;
import jabberpoint.style.builder.TextStyleBuilder;
import jabberpoint.style.builder.TitleOneStyleBuilder;

public class StyleOptions {
    private final Director director;
    private final SubtitleOneStyleBuilder subtitleOneStyleBuilder;
    private final TitleOneStyleBuilder titleOneStyleBuilder;
    private final TitleTwoStyleBuilder titleTwoStyleBuilder;
    private final TextStyleBuilder textStyleBuilder;
    private final Style subtitleOne;
    private final Style titleOne;
    private final Style titleTwo;
    private final Style text;

    public StyleOptions() {
        this.director = new Director();
        this.subtitleOneStyleBuilder = new SubtitleOneStyleBuilder();
        this.titleOneStyleBuilder = new TitleOneStyleBuilder();
        this.titleTwoStyleBuilder = new TitleTwoStyleBuilder();
        this.textStyleBuilder = new TextStyleBuilder();

        this.director.constructSubtitleOneStyle(this.subtitleOneStyleBuilder);
        this.subtitleOne = this.subtitleOneStyleBuilder.getResult();

        this.director.constructTitleOneStyle(this.titleOneStyleBuilder);
        this.titleOne = this.titleOneStyleBuilder.getResult();

        this.director.constructTitleTwoStyle(this.titleTwoStyleBuilder);
        this.titleTwo = this.titleTwoStyleBuilder.getResult();

        this.director.constructTextStyle(this.textStyleBuilder);
        this.text = this.textStyleBuilder.getResult();
    }

    public Style getSubtitle() {
        return subtitleOne;
    }

    public Style getTitleOne() {
        return titleOne;
    }

    public Style getTitleTwo() {
        return titleTwo;
    }

    public Style getText() {
        return text;
    }
}
