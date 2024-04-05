package jabberpoint.slideitem.creator;

import jabberpoint.slideitem.items.BitmapItem;
import jabberpoint.slideitem.SlideItem;
import jabberpoint.style.styles.Style;

public class BitmapItemCreator extends SlideItemCreator {

    @Override
    public SlideItem createSlideItem() {
        SlideItem item = new BitmapItem();

        return item.createSlideItem();
    }

    @Override
    public SlideItem createSlideItem(Style style, String string) {
        SlideItem item = new BitmapItem();

        return item.createSlideItem(style, string);
    }
}
