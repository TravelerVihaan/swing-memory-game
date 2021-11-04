package cardgame;

import cardgame.cards.CardPanel;
import cardgame.menu.MainMenu;
import cardgame.status.StatusBar;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

	public static Game instance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}
	
	private static final long serialVersionUID = 1L;
	
	private static Game instance;
	
	public static final int DEFAULT_HEIGHT = 480;
	
	public static final int DEFAULT_WIDTH = 640;
	
	private final CardPanel cardPanel;

	private final MainMenu menu;
	
	private final StatusBar statusBar;
	
	//parametry okienka z gr¹
	private Game() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
		setTitle("Gra w zapamietywanie");
		
		
	//dodanie poszczególnych elementów tworz¹cych ca³e okno gry
		menu = new MainMenu();
		cardPanel = new CardPanel();
		statusBar = new StatusBar();
		getContentPane().add(menu, BorderLayout.NORTH);
		getContentPane().add(cardPanel, BorderLayout.CENTER);
		getContentPane().add(statusBar, BorderLayout.SOUTH);
	}
	
	
	//odwo³ania do poszczególnych elementów okna poprzez klasê Game
	public CardPanel getCardPanel() {
		return cardPanel;
	}
	
	public MainMenu getMenu() {
		return menu;
	}
	
	public StatusBar getStatusBar() {
		return statusBar;
	}
}
