package jabberpoint.slideitem.creator;

import jabberpoint.slideitem.SlideItem;
import jabberpoint.slideitem.items.TextItem;

public class TextItemCreator extends SlideItemCreator {
    @Override
    public SlideItem createSlideItem() {
        SlideItem item = new TextItem();

        return item.createSlideItem();
    }

    @Override
    public SlideItem createSlideItem(int level, String string) {
        SlideItem item = new TextItem();

        return item.createSlideItem(level, string);
    }
}
