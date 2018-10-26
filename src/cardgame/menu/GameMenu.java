package cardgame.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import cardgame.StartDialog;

public class GameMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private final JMenuItem startGameItem;
	
	private final JMenuItem exitItem;
	
	public GameMenu() {
		super("Gra");
		
		startGameItem = new JMenuItem("Nowa Gra");
		startGameItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StartDialog dialog = new StartDialog();
				dialog.setVisible(true);
			}
		});
		add(startGameItem);
		
		exitItem = new JMenuItem("Wyjscie");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(exitItem);
	}
	
	public JMenuItem getStartGameItem() {
		return startGameItem;
	}
	
	public JMenuItem getExitItem() {
		return exitItem;
	}
}
