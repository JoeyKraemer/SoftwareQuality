package JabberPoint;

import JabberPoint.commands.keyController.KeyController;
import JabberPoint.commands.menuController.MenuController;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

/**
 * <p>The application window for a slideviewcomponent</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/04 Caterina Aresti & Joey Kramer
 */

public class SlideViewerFrame extends JFrame {

    public SlideViewerFrame(String title, Presentation presentation) {
        super(title);
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
        presentation.setShowView(slideViewerComponent);
        setupWindow(slideViewerComponent, presentation);
    }

    // Setup GUI
    public void setupWindow(SlideViewerComponent
                                    slideViewerComponent, Presentation presentation) {
        setTitle("Jabberpoint 2.0 - OU");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(slideViewerComponent);
        addKeyListener(new KeyController(presentation)); // add a controller
        setMenuBar(new MenuController(this, presentation));    // add another controller
        setSize(new Dimension(1200, 800)); // Same sizes as JabberPoint.Slide has.
        setVisible(true);
    }
}
