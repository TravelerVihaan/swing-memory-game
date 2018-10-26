package cardgame.menu;

import javax.swing.JMenuBar;

public class MainMenu extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	
	private final GameMenu gameMenu;
	
	public MainMenu() {
		super();
		//konstruktor dodaj¹cy komponenty
		gameMenu = new GameMenu();
		add(gameMenu);
	}
	
	public GameMenu getGameMenu() {
		return gameMenu;
	}
}
