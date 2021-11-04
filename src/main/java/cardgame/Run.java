package cardgame;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;

public class Run {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkLookAndFeel();
					
					//tworzenie okienka z gr�
					Game dialog = Game.instance();
					dialog.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	
	//sprawdzanie listy dost�pnych motyw�w i ustawienie niestandardowego w miar� mo�liwo�ci
	private static void checkLookAndFeel() {
		try {
			LookAndFeelInfo[] list = UIManager.getInstalledLookAndFeels();
			for (int i = 0; i < list.length; i++) {
				LookAndFeelInfo x = list[i];
				if (x.getName().equalsIgnoreCase("nimbus")) {
					UIManager.setLookAndFeel(x.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Nie mo�na przeszukac motywow systemu");
		}
	}
}
