package JabberPoint;

import JabberPoint.commands.keyController.*;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** <p>The controller for the menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
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

		this.fileMenu.add(this.menuItem = mkMenuItem("OPEN"));
		this.menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new OpenFileCommand(presentation,frame);
			}
		} );

		this.fileMenu.add(this.menuItem = mkMenuItem("New"));
		this.menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new NewFileCommand(presentation,frame);
			}
		});

		this.fileMenu.add(this.menuItem = mkMenuItem("Save"));
		this.menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaveFileCommand(presentation,frame);
			}
		});

		this.fileMenu.addSeparator();

		this.fileMenu.add(this.menuItem = mkMenuItem("Exit"));
		this.menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new ExitCommand(presentation);
			}
		});

		add(this.fileMenu);
		this.viewMenu.add(this.menuItem = mkMenuItem("Next"));
		this.menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new NextSlideCommand(presentation);
			}
		});

		this.viewMenu.add(this.menuItem = mkMenuItem("Previous"));
		this.menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new PreviousSlideCommand(presentation);
			}
		});

		this.viewMenu.add(this.menuItem = mkMenuItem("Go-To"));
		this.menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new GoToSlideCommand(presentation);
			}
		});

		add(this.viewMenu);

		this.helpMenu.add(this.menuItem = mkMenuItem("About"));
		this.menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new ShowAboutCommand(presentation,frame);
			}
		});
		setHelpMenu(this.helpMenu);		// needed for portability (Motif, etc.).
	}

// create a menu item
	private MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
