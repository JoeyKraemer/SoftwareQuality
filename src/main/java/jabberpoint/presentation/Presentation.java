package jabberpoint.presentation;

import jabberpoint.slide.Slide;
import jabberpoint.slideviewer.SlideViewerComponent;

import java.util.ArrayList;


/**
 * <p>This is the Presentation. It maintains the slides in the presentation.</p>
 *
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class Presentation
{
    private String showTitle;
    private ArrayList<Slide> showList = null;
    private int currentSlideNumber = 0;
    private SlideViewerComponent slideViewComponent = null;

    public Presentation()
    {
        this.slideViewComponent = null;
        clear();
    }

    public Presentation(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
        clear();
    }

    public int getSize()
    {
        return this.showList.size();
    }

    public String getTitle()
    {
        return this.showTitle;
    }

    public void setTitle(String title)
    {
        this.showTitle = title;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
    }

    public int getSlideNumber()
    {
        return this.currentSlideNumber;
    }

    public void setSlideNumber(int number)
    {
        if (number < 0 || number > (getSize() - 1) ) {
            this.currentSlideNumber = getSlideNumber();
        }
        else {
            this.currentSlideNumber = number;
        }

        if (this.slideViewComponent != null)
        {
            this.slideViewComponent.update(this, getCurrentSlide());
        }

    }

    public void previousSlide()
    {
        if (this.currentSlideNumber > 0)
        {
            setSlideNumber(this.currentSlideNumber - 1);
        }

        else if (this.currentSlideNumber == 0)
        {
            setSlideNumber(1);
        }
    }

    public void nextSlide()
    {
        if (this.currentSlideNumber < (getSize() -1))
        {
            setSlideNumber(this.currentSlideNumber + 1);
        }
    }

    public void clear()
    {
        this.showList = new ArrayList<Slide>();
        setSlideNumber(-1);
    }

    public void append(Slide slide)
    {
        this.showList.add(slide);
    }

    public Slide getSlide(int number)
    {
        if (number < 0 || number >= getSize())
        {
            return null;
        }
        return this.showList.get(number);
    }

    public Slide getCurrentSlide()
    {
        return getSlide(currentSlideNumber);
    }

    public void exit()
    {
        System.exit(0);
    }
}
