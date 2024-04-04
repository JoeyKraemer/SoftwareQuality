import JabberPoint.Slide;
import JabberPoint.SlideItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MavenTest
{
    private Slide slide;
    private SlideItem slideItem1;
    private SlideItem slideItem2;

    @Test
    public void iWantToTestMyPipeline() {
        slide = new Slide();
        slide.items.add(slideItem1);
        slide.items.add(slideItem2);

        assertEquals(slide.items.size(),2);
    }

}
