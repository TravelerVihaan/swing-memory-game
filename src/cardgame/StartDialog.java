package cardgame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import cardgame.cards.CardPanel;

public class StartDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JButton submit; 
	
	private final JButton cancel;
	
	private final JTextField nameField;
	
	//tworzenie okna dialogowego w celu podania imienia gracza
	public StartDialog() {
		super(Game.instance(), "Rozpocznij nowa gre", true);
		setSize(280, 130);
		setResizable(false);
		setLocationRelativeTo(Game.instance());
		
		TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), " Player name: ");
		
		Box fieldBox = Box.createHorizontalBox();
		fieldBox.setBorder(border);
		
		//stworzenie pola tekstowego
		nameField = new JTextField(20);
		nameField.setMaximumSize(nameField.getPreferredSize());
		fieldBox.add(nameField);
		
		final Box buttonBox = Box.createHorizontalBox();
		//stworzenie buttona Start
		submit = new JButton("Start");
		submit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				onSubmit();
			}
		});
		
		//stworzenie buttona Anuluj
		cancel = new JButton("Anuluj");
		cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				onCancel();
			}
		});
		
		buttonBox.add(submit);
		buttonBox.add(Box.createHorizontalStrut(5));
		buttonBox.add(cancel);
		
		final Box main = Box.createVerticalBox();
		main.add(Box.createHorizontalStrut(3));
		main.add(fieldBox);
		main.add(Box.createHorizontalStrut(3));
		main.add(buttonBox);
		main.add(Box.createHorizontalStrut(3));
		
		getContentPane().add(main, BorderLayout.CENTER);
	}
	
	//przycisk Anuluj
	protected void onCancel() {
		StartDialog.this.dispose();
	}
	
	//przycisk Start
	protected void onSubmit() {
		String value = nameField.getText();
		if(value == null || value.trim().length() == 0) {
			JOptionPane.showMessageDialog(Game.instance(), "Imie nie mo¿e byc puste!");
		} else {
			Game.instance().getStatusBar().setPlayer(value);
			Game.instance().getStatusBar().setScore(0);
			Game.instance().getCardPanel().reset(CardPanel.DEFAULT_ROWS_COUNT, CardPanel.DEFAULT_COLUMNS_COUNT, true);
			StartDialog.this.dispose();
		}
	}
}
