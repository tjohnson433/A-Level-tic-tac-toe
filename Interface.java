package ticTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface extends JPanel implements ActionListener{
	
	//attributes
	private static JLabel myTurnLabel = new JLabel("Turn: X");
	private static GamePanel myGamePanel = new GamePanel();
		
	private static CardLayout cardlayout = new CardLayout();
	private static JPanel panelswitcher = new JPanel(cardlayout);
	private static JPanel winPanel = new JPanel();
	private static JLabel winLabel = new JLabel();
	
	
		
		//constructor
	public Interface() {
		
		winLabel.setText("win");
		winPanel.setBackground(Color.red);
		winPanel.setVisible(true);
			
		panelswitcher.add(myGamePanel, "Gamepanel");
		panelswitcher.add(winPanel, winLabel);

		this.setLayout(new BorderLayout());
		this.add(panelswitcher, BorderLayout.CENTER);
		this.add(myTurnLabel, BorderLayout.NORTH);
		
		//set up window
		
		
		myGamePanel.setActionListener(this);
	}
	
	public static void showWinPanel() {
		cardlayout.show(panelswitcher, "win");
	}
	
	public void resetGame() {
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		myTurnLabel.setText("turn" + myGamePanel.getTurn());
	}
}
