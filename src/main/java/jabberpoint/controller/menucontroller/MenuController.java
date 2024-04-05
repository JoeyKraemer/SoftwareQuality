package jabberpoint.controller.menucontroller;

import jabberpoint.Presentation;
import jabberpoint.controller.Command;
import jabberpoint.controller.keycontroller.*;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * <p>The controller for the menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 2.0 2024/04/04 Caterina Aresti & Joey Kramer
 */
public class MenuController extends MenuBar {

    private Frame frame; // the frame, only used as parent for the Dialogs
    private Presentation presentation; // Commands are given to the presentation
    private MenuItem menuItem;
    private Menu fileMenu;
    private Menu viewMenu;
    private Menu helpMenu;


    public MenuController(Frame frame, Presentation presentation) {
        this.frame = frame;
        this.presentation = presentation;
        this.fileMenu = new Menu("File");
        this.viewMenu = new Menu("View");
        this.helpMenu = new Menu("Help");

        this.fileMenu.add(this.menuItem = mkMenuItem("Open"));
        this.menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Command action = new OpenFileCommand(presentation, frame);
                action.execute();
            }
        });

        this.fileMenu.add(this.menuItem = mkMenuItem("New"));
        this.menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Command action = new NewFileCommand(presentation, frame);
                action.execute();
            }
        });

        this.fileMenu.add(this.menuItem = mkMenuItem("Save"));
        this.menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command action = new SaveFileCommand(presentation, frame);
                action.execute();
            }
        });

        this.fileMenu.addSeparator();

        this.fileMenu.add(this.menuItem = mkMenuItem("Exit"));
        this.menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Command action = new ExitCommand(presentation);
                action.execute();
            }
        });

        add(this.fileMenu);
        this.viewMenu.add(this.menuItem = mkMenuItem("Next"));
        this.menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Command action = new NextSlideCommand(presentation);
                action.execute();
            }
        });

        this.viewMenu.add(this.menuItem = mkMenuItem("Previous"));
        this.menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Command action = new PreviousSlideCommand(presentation);
                action.execute();
            }
        });

        this.viewMenu.add(this.menuItem = mkMenuItem("Go-To"));
        this.menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Command action = new GoToSlideCommand(presentation);
                action.execute();
            }
        });

        add(this.viewMenu);

        this.helpMenu.add(this.menuItem = mkMenuItem("About"));
        this.menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Command action = new ShowAboutCommand(presentation, frame);
                action.execute();
            }
        });
        setHelpMenu(this.helpMenu);        // needed for portability (Motif, etc.).
    }

    // create a menu item
    private MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
