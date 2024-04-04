package JabberPoint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;


/** <p>JabberPoint.SlideViewerComponent is a graphical component that can show slides.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2024/04/04 Caterina Aresti & Joey Kramer
 */

public class SlideViewerComponent extends JComponent {
		
	private Slide slide; // current slide
	private Font labelFont = null; // font for labels
	private Presentation presentation = null; // the presentation
	private JFrame frame = null;

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

	public Dimension getPreferredSize() {
		return new Dimension(Slide.WIDTH, Slide.HEIGHT);
	}

	public void update(Presentation presentation, Slide data) {
		if (data == null) {
			repaint();
			return;
		}
		this.presentation = presentation;
		this.slide = data;
		repaint();
		frame.setTitle(presentation.getTitle());
	}

// draw the slide
	public void paintComponent(Graphics g) {
		int XPOS = 1100;
		int YPOS = 20;

		g.setColor(Color.white);
		g.fillRect(0, 0, getSize().width, getSize().height);
		if (presentation.getSlideNumber() < 0 || slide == null) {
			return;
		}
		g.setFont(labelFont);
		g.setColor(Color.black);
        g.drawString("JabberPoint.Slide " + (1 + presentation.getSlideNumber()) + " of " +
                 presentation.getSize(), XPOS, YPOS);
		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
		slide.draw(g, area, this);
	}
}