package jabberpoint.controller.menucontroller;

import jabberpoint.presentation.Presentation;
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
 * <p>This is the MenuController, it contains all the menus</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */
public class MenuController extends MenuBar {

    private Frame frame; // the frame, only used as parent for the Dialogs
    private Presentation presentation; // Commands are given to the presentation
    private Menu fileMenu;
    private Menu viewMenu;
    private Menu helpMenu;


    public MenuController(Frame frame, Presentation presentation) {
        this.frame = frame;
        this.presentation = presentation;
        this.fileMenu = new Menu("File");
        this.viewMenu = new Menu("View");
        this.helpMenu = new Menu("Help");

        //adding menu items for file operations
        addMenuItem(fileMenu, "Open", new OpenFileCommand(presentation, frame));
        addMenuItem(fileMenu, "New", new NewFileCommand(presentation, frame));
        addMenuItem(fileMenu, "Save", new SaveFileCommand(presentation, frame));
        fileMenu.addSeparator();
        addMenuItem(fileMenu, "Exit", new ExitCommand(presentation));

        //adding menu items for navigation
        addMenuItem(viewMenu, "Next", new NextSlideCommand(presentation));
        addMenuItem(viewMenu, "Previous", new PreviousSlideCommand(presentation));
        addMenuItem(viewMenu, "Go-To", new GoToSlideCommand(presentation));

        //adding menu item to show info about the application
        addMenuItem(helpMenu, "About", new ShowAboutCommand(presentation, frame));

        // adding and setting menus to the menu bar
        add(fileMenu);
        add(viewMenu);
        setHelpMenu(helpMenu);
    }

    // add a menu item
    private void addMenuItem(Menu menu, String name, Command command) {
        MenuItem menuItem = makeMenuItem(name);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                command.execute();
            }
        });
        menu.add(menuItem);
    }

    // create a menu item
    private MenuItem makeMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
