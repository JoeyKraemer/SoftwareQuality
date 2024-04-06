package jabberpoint.style;

import jabberpoint.style.builder.*;
import jabberpoint.style.styles.Style;

public class StyleOptions {
    private final Director director;
    private final SubtitleOneStyleBuilder subtitleOneStyleBuilder;
    private final SubtitleTwoStyleBuilder subtitleTwoStyleBuilder;
    private final TitleOneStyleBuilder titleOneStyleBuilder;
    private final TitleTwoStyleBuilder titleTwoStyleBuilder;
    private final TextStyleBuilder textStyleBuilder;
    private final Style subtitleOne;
    private final Style subtitleTwo;
    private final Style titleOne;
    private final Style titleTwo;
    private final Style text;

    public StyleOptions() {
        this.director = new Director();
        this.subtitleOneStyleBuilder = new SubtitleOneStyleBuilder();
        this.subtitleTwoStyleBuilder = new SubtitleTwoStyleBuilder();
        this.titleOneStyleBuilder = new TitleOneStyleBuilder();
        this.titleTwoStyleBuilder = new TitleTwoStyleBuilder();
        this.textStyleBuilder = new TextStyleBuilder();

        this.director.constructSubtitleOneStyle(this.subtitleOneStyleBuilder);
        this.subtitleOne = this.subtitleOneStyleBuilder.getResult();

        this.director.constructSubtitleTwoStyle(this.subtitleTwoStyleBuilder);
        this.subtitleTwo = this.subtitleTwoStyleBuilder.getResult();

        this.director.constructTitleOneStyle(this.titleOneStyleBuilder);
        this.titleOne = this.titleOneStyleBuilder.getResult();

        this.director.constructTitleTwoStyle(this.titleTwoStyleBuilder);
        this.titleTwo = this.titleTwoStyleBuilder.getResult();

        this.director.constructTextStyle(this.textStyleBuilder);
        this.text = this.textStyleBuilder.getResult();
    }

    public Style getSubtitleOne() {
        return subtitleOne;
    }

    public Style getSubtitleTwo() {
        return subtitleTwo;
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
