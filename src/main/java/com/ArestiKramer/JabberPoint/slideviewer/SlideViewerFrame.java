package com.ArestiKramer.JabberPoint.slideviewer;

import com.ArestiKramer.JabberPoint.controller.keycontroller.KeyController;
import com.ArestiKramer.JabberPoint.controller.menucontroller.MenuController;
import com.ArestiKramer.JabberPoint.presentation.Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <p>This is a SlideViewerFrame, The application window for a SlideViewComponent</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class SlideViewerFrame extends JFrame
{

    public SlideViewerFrame(String title, Presentation presentation)
    {
        super(title);
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
        presentation.setShowView(slideViewerComponent);
        setupWindow(slideViewerComponent, presentation);
    }

    public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation)
    {
        setTitle("Jabberpoint 2.0 - OU");
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        getContentPane().add(slideViewerComponent);
        addKeyListener(new KeyController(presentation));
        setMenuBar(new MenuController(this, presentation));
        setSize(new Dimension(1200, 800));
        setVisible(true);
    }
}
