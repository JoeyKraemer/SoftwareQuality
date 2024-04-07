package jabberpoint.slide.iterator;

import jabberpoint.slideitem.SlideItem;

/**
 * <p>This is the Iterator, it's implemented in SlideItemIterator</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public interface Iterator<SlideItems> {

    boolean hasNext();
    SlideItem next();
}
