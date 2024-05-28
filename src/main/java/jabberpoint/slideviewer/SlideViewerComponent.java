package jabberpoint.slideviewer;

import jabberpoint.presentation.Presentation;
import jabberpoint.slide.Slide;

import javax.swing.*;
import java.awt.*;


/**
 * <p>THis is a SlideViewerComponent. It is a graphical component that can show slides.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class SlideViewerComponent extends JComponent
{

    private Slide slide;
    private Font labelFont;
    private Presentation presentation;
    private JFrame frame;

    public SlideViewerComponent(Presentation presentation, JFrame frame)
    {
        this.slide = null;
        this.labelFont = new Font("Dialog", Font.BOLD, 10);
        this.presentation = presentation;
        this.frame = frame;

        setBackground(Color.white);
    }

    public Slide getSlide()
    {
        return slide;
    }

    public void setSlide(Slide slide)
    {
        this.slide = slide;
    }

    public Font getLabelFont()
    {
        return labelFont;
    }

    public void setLabelFont(Font labelFont)
    {
        this.labelFont = labelFont;
    }

    public Presentation getPresentation()
    {
        return presentation;
    }

    public void setPresentation(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public void setFrame(JFrame frame)
    {
        this.frame = frame;
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(Slide.WIDTH, Slide.HEIGHT);
    }

    public void update(Presentation presentation, Slide data)
    {
        if (data == null)
        {
            repaint();

            return;
        }
        this.presentation = presentation;
        this.slide = data;
        repaint();
        frame.setTitle(presentation.getTitle());
    }

    public void paintComponent(Graphics graphics)
    {
        final int XPOS = 1100;
        final int YPOS = 20;

        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        if (presentation.getSlideNumber() < 0 || slide == null)
        {
            return;
        }
        graphics.setFont(labelFont);
        graphics.setColor(Color.black);
        graphics.drawString("JabberPoint.JabberPoint.Slide " + (1 + presentation.getSlideNumber()) + " of " +
                presentation.getSize(), XPOS, YPOS);
        Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
        slide.draw(graphics, area, this);
    }
}
