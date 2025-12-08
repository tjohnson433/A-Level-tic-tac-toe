package ticTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface extends JPanel implements ActionListener{
	
	//attributes
	private static JLabel myTurnLabel = new JLabel("Turn: X");
	private static GamePanel myGamePanel = new GamePanel();                              // screen1
		
	private static CardLayout cardlayout = new CardLayout();
	private static JPanel panelswitcher = new JPanel(cardlayout);
	private static JPanel winPanel = new JPanel();
	private static JLabel winLabel = new JLabel();
	private static JPanel buttonsPanel = new JPanel();
	private static JPanel myTurnPanel = new JPanel();
	private static JButton resetButton  = new JButton("Reset Game");

	private String theWinner = " ";
	
	
		//constructor
	public Interface() {
		
		// setting up the win panel
		
		winPanel.setLayout(new BorderLayout());
		winPanel.setBackground(Color.WHITE);
		winLabel.setFont(new Font("Jumble", Font.BOLD, 20));
		winLabel.setHorizontalAlignment(JLabel.CENTER);
		winPanel.add(winLabel, BorderLayout.CENTER);
			
		panelswitcher.add(myGamePanel, "Gamepanel");
		panelswitcher.add(winPanel, "Win Panel");

		this.setLayout(new BorderLayout());
		this.add(panelswitcher, BorderLayout.CENTER);
		this.add(myTurnLabel, BorderLayout.NORTH);
		
		myTurnPanel.add(myTurnLabel, BorderLayout.NORTH);
		myTurnLabel.setHorizontalAlignment(JLabel.CENTER);
		myTurnLabel.setBackground(Color.WHITE);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 4));
		buttonsPanel.add(resetButton);
		
		resetButton.addActionListener(this);
		resetButton.setText("Play Again");
		resetButton.setFont(new Font("Jumble", Font.BOLD, 20));
		resetButton.setBackground(Color.WHITE);
		resetButton.setFocusable(false);

		winPanel.add(buttonsPanel, BorderLayout.SOUTH);
		winPanel.add(myTurnPanel, BorderLayout.NORTH);
		
		
		myGamePanel.setActionListener(this);
	}
	
	
	public void showWhoWon() {
		
		if (myGamePanel.getWinner() == 1) {
			theWinner = "Crosses wins";
			winLabel.setText("Crosses wins");
		} else if (myGamePanel.getWinner() == 2) {
			theWinner = "Noughts wins";
			winLabel.setText("Noughts wins");
		} else if (myGamePanel.getWinner() == 3){
			theWinner = "Draw";
			winLabel.setText("Draw");
		}
		
	}
	
	public static void showWinPanel() {
		cardlayout.show(panelswitcher, "Win Panel");
	}
	
	
//	public void resetBoard() {
//		for (int i = 0; i < 9; i++) { 
//			GamePanel
//		}
//	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		myTurnLabel.setText("Turn: " + myGamePanel.getTurn());
		showWhoWon();
		
//		if (e.getSource() == resetButton) {
//			resetBoard();
//		}
	}
}
