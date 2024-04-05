package jabberpoint.slideitem.creator;

import jabberpoint.slideitem.SlideItem;
import jabberpoint.style.styles.Style;

public abstract class SlideItemCreator {

    public abstract SlideItem createSlideItem();
    public abstract SlideItem createSlideItem(Style style, String string);

}
