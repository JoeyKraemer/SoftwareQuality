package com.ArestiKramer.JabberPoint;

import javax.swing.*;
import java.awt.*;

/**
 * THis is the About-box. It shows information about the program
 *
 * @author Ian F. Darwin, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class AboutBox
{
    public static void show(Frame parent)
    {
        JOptionPane.showMessageDialog(parent,
                "JabberPoint.JabberPoint.JabberPoint.JabberPoint is a primitive slide-show program in Java(tm). It\n" +
                        "is freely copyable as long as you keep this notice and\n" +
                        "the splash screen intact.\n" +
                        "Copyright (c) 1995-1997 by Ian F. Darwin, ian@darwinsys.com.\n" +
                        "Adapted by Gert Florijn (version 1.1) and " +
                        "Sylvia Stuurman (version 1.2 and higher) for the Open" +
                        "University of the Netherlands, 2002 -- now." +
                        "Author's version available from http://www.darwinsys.com/",
                "About JabberPoint.JabberPoint.JabberPoint.JabberPoint",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
