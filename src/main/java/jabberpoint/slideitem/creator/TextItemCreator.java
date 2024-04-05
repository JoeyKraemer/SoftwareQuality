package jabberpoint.slideitem.creator;

import jabberpoint.slideitem.SlideItem;
import jabberpoint.slideitem.items.TextItem;
import jabberpoint.style.styles.Style;

public class TextItemCreator extends SlideItemCreator {
    @Override
    public SlideItem createSlideItem() {
        SlideItem item = new TextItem();

        return item.createSlideItem();
    }

    @Override
    public SlideItem createSlideItem(Style style, String string) {
        SlideItem item = new TextItem();

        return item.createSlideItem(style, string);
    }
}
