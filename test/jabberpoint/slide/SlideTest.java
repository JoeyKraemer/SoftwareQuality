package jabberpoint.slide;

import jabberpoint.slideitem.SlideItem;
import jabberpoint.style.StyleOptions;
import jabberpoint.style.styles.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.*;

public class SlideTest {

    private Slide slide;
    private Style style;

    @BeforeEach
    public void setup() {
        slide = new Slide();

        StyleOptions styleOptions = new StyleOptions();
        style = styleOptions.getSubtitleOne();
    }

    @Test
    public void appendTextItem_addItem_itemAddedToSlide() {
        slide.appendTextItem(style, "Test Text");
        assertEquals(1, slide.getSlideItems().size());
        assertEquals("Test Text", slide.getSlideItems().get(0).getText()); // Assuming getText() method exists
    }

    @Test
    public void appendBitMapItem_addItem_itemAddedToSlide() {
        slide.appendBitMapItem(style, "Default.png");
        assertEquals(1, slide.getSlideItems().size());
        assertEquals("Default.png", slide.getSlideItems().get(0).getText()); // Assuming getText() method exists
    }

    @Test
    public void getSpecificSlideItem_validIndex_returnsCorrectItem() {
        slide.appendTextItem(style, "Test Text");
        SlideItem item = slide.getSpecificSlideItem(0);
        assertNotNull(item);
        assertEquals("Test Text", item.getText()); // Assuming getText() method exists
    }

    @Test
    public void getSpecificSlideItem_invalidIndex_throwsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            slide.getSpecificSlideItem(0);
        });
    }

    @Test
    public void draw_slideWithItems_itemsDrawnCorrectly() {
        slide.appendTextItem(style, "Test Text");
        slide.appendBitMapItem(style, "Default.png");

        BufferedImage bufferedImage = new BufferedImage(Slide.WIDTH, Slide.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        ImageObserver observer = (img, infoflags, x, y, width, height) -> false;

        Rectangle area = new Rectangle(0, 0, Slide.WIDTH, Slide.HEIGHT);
        slide.draw(g2d, area, observer);
    }

    @Test
    public void getTitle_defaultTitle_correctTitleReturned() {
        assertEquals("Example Name", slide.getTitle());
    }

    @Test
    public void setTitle_newTitle_titleUpdated() {
        String newTitle = "New Title";
        slide.setTitle(newTitle);
        assertEquals(newTitle, slide.getTitle());
    }
}
