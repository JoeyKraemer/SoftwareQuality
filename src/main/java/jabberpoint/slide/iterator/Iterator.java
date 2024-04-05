package jabberpoint.slide.iterator;

import jabberpoint.slideitem.SlideItem;

public interface Iterator<SlideItems> {

    boolean hasNext();
    SlideItem next();
}
