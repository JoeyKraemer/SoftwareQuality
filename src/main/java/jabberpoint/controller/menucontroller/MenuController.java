package jabberpoint.controller.menucontroller;

import jabberpoint.controller.Command;
import jabberpoint.controller.Receiver;
import jabberpoint.controller.keycontroller.NextSlideCommand;
import jabberpoint.controller.keycontroller.PreviousSlideCommand;
import jabberpoint.presentation.Presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>This is the MenuController, it contains all the menus</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */
public class MenuController extends MenuBar implements Receiver
{

    private final Presentation presentation; // Commands are given to the presentation
    private final Menu fileMenu;
    private final Menu viewMenu;
    private final Menu helpMenu;


    public MenuController(Frame frame, Presentation presentation)
    {
        this.presentation = presentation;

        //menu columns
        this.fileMenu = new Menu("File");
        this.viewMenu = new Menu("View");
        this.helpMenu = new Menu("Help");

        //list of commands
        OpenFileCommand openFileCommand = new OpenFileCommand(this.presentation, frame);
        NewFileCommand newFileCommand = new NewFileCommand(this.presentation, frame);
        SaveFileCommand saveFileCommand = new SaveFileCommand(this.presentation, frame);
        ExitCommand exitCommand = new ExitCommand(this.presentation);
        NextSlideCommand nextSlideCommand = new NextSlideCommand(this.presentation);
        PreviousSlideCommand previousSlideCommand = new PreviousSlideCommand(this.presentation);
        GoToSlideCommand goToSlideCommand = new GoToSlideCommand(this.presentation);
        ShowAboutCommand showAboutCommand = new ShowAboutCommand(this.presentation, frame);


        //adding menu items for file operations
        addMenuItem(fileMenu, "Open", openFileCommand);
        addMenuItem(fileMenu, "New", newFileCommand);
        addMenuItem(fileMenu, "Save", saveFileCommand);
        fileMenu.addSeparator();
        addMenuItem(fileMenu, "Exit", exitCommand);

        //adding menu items for navigation
        addMenuItem(viewMenu, "Next", nextSlideCommand);
        addMenuItem(viewMenu, "Previous", previousSlideCommand);
        addMenuItem(viewMenu, "Go-To", goToSlideCommand);

        //adding menu item to show info about the application
        addMenuItem(helpMenu, "About", showAboutCommand);

        // adding and setting menus to the menu bar
        add(fileMenu);
        add(viewMenu);
        setHelpMenu(helpMenu);
    }

    public Presentation getPresentation()
    {
        return presentation;
    }

    public Menu getFileMenu()
    {
        return fileMenu;
    }

    public Menu getViewMenu()
    {
        return viewMenu;
    }

    public Menu getHelpMenu()
    {
        return helpMenu;
    }

    private void addMenuItem(Menu menu, String name, Command command)
    {
        MenuItem menuItem = makeMenuItem(name);
        menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                executeCommand(command);
            }
        });
        menu.add(menuItem);
    }

    private MenuItem makeMenuItem(String name)
    {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }

    @Override
    public void executeCommand(Command command)
    {
        command.execute();
    }
}
