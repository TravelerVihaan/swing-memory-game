package cardgame.cards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CardButton extends JButton implements Card {
	
	private static final long serialVersionUID = 1L;

	public static final String HIDDEN_VALUE = "?";
	
	private int cardValue;

	//tworzenie buttona-karty
	public CardButton(int value) {
		setCardValue(value);
		setText(HIDDEN_VALUE);
		
		addActionListener(new ActionListener() {
			//dodatnie listenera, który zmienia status karty
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isClicked()) {
					showCard(true);
				} else {
					showCard(false);
				}
			}
		});
	}
	
	//zmiana etykiety karty w razie klikniêcia
	public void showCard(boolean show) {
		if (show) {
			setText(String.valueOf(cardValue));
		} else {
			setText(HIDDEN_VALUE);
		}
	}
	
	@Override
	public int getCardValue() {
		return cardValue;
	}
	
	//funkcja sprawdzajaca stan klikniecia karty
	public boolean isClicked() {
		String displayedValue = getText();
		return !(HIDDEN_VALUE.equals(displayedValue));
	}
	
	@Override
	public boolean isCardMatch(Card card) {
		return cardValue == card.getCardValue();
	}
	
	@Override
	public void setCardValue(int value) {
		this.cardValue = value;
	}
}
