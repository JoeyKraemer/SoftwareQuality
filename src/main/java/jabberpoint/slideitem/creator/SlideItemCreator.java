package jabberpoint.slideitem.creator;

import jabberpoint.slideitem.SlideItem;

public abstract class SlideItemCreator {

    public abstract SlideItem createSlideItem();
    public abstract SlideItem createSlideItem(int level, String string);

}
