package jabberpoint.presentation;

import jabberpoint.slide.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PresentationTest {

    private Presentation presentation;
    private Slide slide1;
    private Slide slide2;

    @BeforeEach
    public void setup() {
        presentation = new Presentation();
        slide1 = new Slide();
        slide2 = new Slide();
    }

    @Test
    public void getSize_appendTwoPresentation_Size_sizeIsTwo() {
        assertEquals(0, presentation.getSize());

        presentation.append(slide1);
        assertEquals(1, presentation.getSize());

        presentation.append(slide2);
        assertEquals(2, presentation.getSize());
    }

    @Test
    public void getTitle_setTitle_titleIsEqual() {
        assertNull(presentation.getTitle());
        String title = "Presentation Title";

        presentation.setTitle(title);

        assertEquals(title, presentation.getTitle());
    }

    @Test
    public void setSlideNumber_changeSlide_Slide2() {
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(1);

        assertEquals(1, presentation.getSlideNumber());
        assertEquals(slide2, presentation.getCurrentSlide());
    }

    @Test
    public void previousSlide_changeSlide_Slide1() {
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(1);
        presentation.previousSlide();

        assertEquals(0, presentation.getSlideNumber());
        assertEquals(slide1, presentation.getCurrentSlide());
    }

    @Test
    public void nextSlide_changeSlide_Slide2() {
        presentation.append(slide1);
        presentation.append(slide2);
        presentation.setSlideNumber(0);
        presentation.nextSlide();

        assertEquals(1, presentation.getSlideNumber());
        assertEquals(slide2, presentation.getCurrentSlide());
    }

    @Test
    public void clear_removeAllSlides_allSlidesRemoved() {
        presentation.append(slide1);
        presentation.append(slide2);

        assertEquals(2, presentation.getSize());
        presentation.clear();
        assertEquals(0, presentation.getSize());
    }

    @Test
    public void getSlide_returnSlide1_Slide1() {
        presentation.append(slide1);
        presentation.append(slide2);

        assertEquals(slide1, presentation.getSlide(0));
    }
}
