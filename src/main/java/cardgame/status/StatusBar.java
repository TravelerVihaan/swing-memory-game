package cardgame.status;

import javax.swing.*;

public class StatusBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	
	private static final String NO_VALUE = "         ";
	
	private String playerPrefix = "Player: ";
	
	private String scorePrefix = "Score: ";
	
	private String player;
	
	private final JLabel playerLabel;
	
	private final JLabel scoreLabel;
	
	private int score;
	
	
	public StatusBar() {
		super(BoxLayout.X_AXIS);
		
		playerLabel = new JLabel();
		scoreLabel = new JLabel();
		
		clear();
		
		add(playerLabel);
		add(new JLabel("  ||  "));
		add(scoreLabel);
	}
	
	//czyszczenie zawartosci status bara
	public void clear() {
		playerLabel.setText(playerPrefix + NO_VALUE);
		scoreLabel.setText(scorePrefix + NO_VALUE);
	}
	
	public String getPlayer() {
		return player;
	}

	public JLabel getPlayerLabel() {
		return playerLabel;
	}
	

	public int getScore() {
		return score;
	}
	
	
	public JLabel getScoreLabel() {
		return scoreLabel;
	}
	
	public void setPlayer(String player) {
		this.player = player;
		if (this.player != null && this.player.length() > 0) {
			playerLabel.setText(playerPrefix + this.player);
		} else {
			playerLabel.setText(playerPrefix + NO_VALUE);
		}
	}
	
	public void setScore(int score) {
		this.score = score;
		if (this.score >= 0) {
			scoreLabel.setText(scorePrefix + this.score);
		} else {
			scoreLabel.setText(scorePrefix + NO_VALUE);
		}
	}
}
