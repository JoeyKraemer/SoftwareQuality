package jabberpoint.slideitem.creator;

import jabberpoint.slideitem.items.BitmapItem;
import jabberpoint.slideitem.SlideItem;

public class BitmapItemCreator extends SlideItemCreator {

    @Override
    public SlideItem createSlideItem() {
        SlideItem item = new BitmapItem();

        return item.createSlideItem();
    }

    @Override
    public SlideItem createSlideItem(int level, String string) {
        SlideItem item = new BitmapItem();

        return item.createSlideItem(level, string);
    }
}
