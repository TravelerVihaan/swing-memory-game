package cardgame.cards;

public interface Card {
	
	public int getCardValue();
	
	public boolean isCardMatch(Card card);
	
	public void setCardValue(int value);
}
