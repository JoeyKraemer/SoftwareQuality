package jabberpoint.slideitem.creator;

import jabberpoint.slideitem.items.BitmapItem;
import jabberpoint.slideitem.SlideItem;
import jabberpoint.style.styles.Style;

/**
 * <p>This is the BitmapItemCreator, it creates BitmapItems</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

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
