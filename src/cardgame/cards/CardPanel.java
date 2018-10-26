package cardgame.cards;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cardgame.Game;
import cardgame.StartDialog;

public class CardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_ROWS_COUNT = 3;
	
	public static final int DEFAULT_COLUMNS_COUNT = 4;
	
	private final ActionListener clickListener;
	
	private final Set<CardButton> cards = new HashSet<CardButton>();
	
	private final Set<CardButton> scoredCards = new HashSet<CardButton>();
	
	private int cardHorizontalGap = 4;
	
	private int cardVerticalGap = 4;
	
	private int maxNumber = 100;
	
	private CardButton currentCard = null;
	
	public CardPanel() {
		this(DEFAULT_ROWS_COUNT, DEFAULT_COLUMNS_COUNT);
	}
	
	public CardPanel(int rows, int columns) {
		this.clickListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof CardButton) {
					CardButton source = (CardButton) e.getSource();
					//sprawdzanie czy karta jest ju¿ kliknieta
					if (currentCard == null) {
						source.showCard(true);
						currentCard = source;
					} else if (currentCard != null) {
						//sprawdzanie czy klikamy drug¹ kartê
						if (currentCard.getCardValue() == source.getCardValue()) {
							source.showCard(true);
							//dodawanie kart do Setu kart zapunktowanych
							scoredCards.add(currentCard);
							scoredCards.add(source);
							
							int score = Game.instance().getStatusBar().getScore() + 1;  
							Game.instance().getStatusBar().setScore(score);
							
							currentCard = null;
							} else {
							//chowanie kart o roznych wartosciach
							source.showCard(true);
							JOptionPane.showMessageDialog(Game.instance(), "Karty nie s¹ takie same!");
							currentCard.showCard(false);
							source.showCard(false);
							currentCard = null;
							}
						}
					}
				if(Game.instance().getStatusBar().getScore() == 6){
					JOptionPane.showMessageDialog(Game.instance(), "Gratulacje, wygrales! Wcisnij OK, aby zagrac jeszcze raz");
					StartDialog dialog = new StartDialog();
					dialog.setVisible(true);
				}
				}
				
			
		};
		
		reset(rows, columns, false);
	}
	
	private CardButton createCard(int value) {
		CardButton card = new CardButton(value);
		card.addActionListener(clickListener);
		return card;
	}

	private Set<CardButton> generateCards(int cardsCount) {
		Set<CardButton> result = new HashSet<CardButton>();
		int valuesCount = cardsCount / 2;
		if (valuesCount > 0) {
			//generowanie wartoœci kart i przypisywanie ich do buttonów
			Random random = new Random();
			
			List<Integer> values = new ArrayList<Integer>();
			for (int i = 0; i < valuesCount; i++) {
				int x = random.nextInt(maxNumber);
				
				//sprawdzanie czy wylosowana liczba nie jest dublerem
				while (values.contains(x)) {
					x = random.nextInt(maxNumber);
				}
				values.add(x);
				
				//tworzenie pierwszej kopii danej karty
				CardButton card = createCard(x);
				result.add(card);
				
				//tworzenie drugiej kopii danej karty
				card = createCard(x);
				result.add(card);
			}
		}
		return result;
	}
	
	public void reset(int rows, int columns, boolean generate) {
		//za³adowanie liczby wierszy i kolumn
		if (rows < 1) {
			rows = DEFAULT_ROWS_COUNT;
		}
		if (columns < 1) {
			columns = DEFAULT_COLUMNS_COUNT;
		}
		
		//czyszczenie kart
		Iterator<CardButton> iter = cards.iterator();
		while (iter.hasNext()) {
			CardButton card = iter.next();
			remove(card);
		}
		if (isVisible()) {
			validate();
		}
		cards.clear();
		
		//ustawienie GridLayoutu
		setLayout(new GridLayout(rows, columns, cardHorizontalGap, cardVerticalGap));

		if (generate) {
			Set<CardButton> newCards = generateCards(rows * columns);
			for (CardButton card : newCards) {
				cards.add(card);
				add(card);
				
				if (isVisible()) {
					validate();
				}
			}
		}
	}
	
	public Set<CardButton> getCards() {
		return cards;
	}
}
