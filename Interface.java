package ticTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface extends JPanel implements ActionListener{
	
	//attributes
	
	private static JLabel myTurnLabel = new JLabel("Turn: X");
	private static GamePanel myGamePanel = new GamePanel();                              // screen1
		
	private static CardLayout cardlayout = new CardLayout();                  // creates the cardLayout
	private static JPanel panelswitcher = new JPanel(cardlayout);             // tells the JPanel how to arrange the contents
	private static JPanel winPanel = new JPanel();                            // screen2
	private static JLabel winLabel = new JLabel();
	private static JPanel buttonsPanel = new JPanel();
	private static JPanel menuPanel = new JPanel();
	private static JButton menuButton = new JButton("Main Menu");
	private static JButton ticTacToeButton = new JButton();
	private static JButton connectFourButton = new JButton();
	private static JButton resetButton  = new JButton("Reset Game");
	private static String theWinner = " ";
	
	
		//constructor
	public Interface() {
		
		// setting up the win panel
		

		winLabel.setFont(new Font("Jumble", Font.BOLD, 20));
		winLabel.setHorizontalAlignment(JLabel.CENTER);
		
		winPanel.setLayout(new BorderLayout());
		winPanel.setBackground(Color.WHITE);
		winPanel.add(winLabel, BorderLayout.CENTER);
		winPanel.add(buttonsPanel, BorderLayout.SOUTH);
		winPanel.add(myTurnLabel, BorderLayout.NORTH);
			
		panelswitcher.add(myGamePanel, "Gamepanel");
		panelswitcher.add(winPanel, "Win Panel");
		panelswitcher.add(menuPanel, "Menu Panel");

		this.setLayout(new BorderLayout());
		this.add(panelswitcher, BorderLayout.CENTER);
		this.add(myTurnLabel, BorderLayout.NORTH);
		
		myTurnLabel.setHorizontalAlignment(JLabel.CENTER);	
		myTurnLabel.setBackground(Color.WHITE);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 2));
		buttonsPanel.add(resetButton);
		buttonsPanel.add(menuButton);
		
		resetButton.addActionListener(this);
		resetButton.setText("Play Again");
		resetButton.setFont(new Font("Jumble", Font.BOLD, 20));
		resetButton.setBackground(Color.WHITE);
		resetButton.setFocusable(false);
		
		ticTacToeButton.addActionListener(this);
		ticTacToeButton.setText("Tic Tac Toe");
		ticTacToeButton.setFont(new Font("Jumble", Font.BOLD, 20));
		ticTacToeButton.setBackground(Color.WHITE);
		ticTacToeButton.setFocusable(false);
		
		connectFourButton.addActionListener(this);
		connectFourButton.setText("Connect 4");
		connectFourButton.setFont(new Font("Jumble", Font.BOLD, 20));
		connectFourButton.setBackground(Color.WHITE);
		connectFourButton.setFocusable(false);
		
		menuButton.addActionListener(this);
		menuButton.setText("Main Menu");
		menuButton.setFont(new Font("Jumble", Font.BOLD, 20));
		menuButton.setBackground(Color.WHITE);
		menuButton.setFocusable(false);
		
		
		
		menuPanel.setLayout(new BorderLayout());
		menuPanel.setBackground(Color.WHITE);
		menuPanel.add(connectFourButton, BorderLayout.EAST);
		menuPanel.add(ticTacToeButton, BorderLayout.WEST);
		
		
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
	
	public static void showMenuPanel() {
		cardlayout.show(panelswitcher, "Menu Panel");
	}
	
	public void resetBoard() {
		myGamePanel.resetBoard();
		myTurnLabel.setText("Turn: " + myGamePanel.getTurn());
		cardlayout.show(panelswitcher, "Gamepanel");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		myTurnLabel.setText("Turn: " + myGamePanel.getTurn());
		showWhoWon();
		if (e.getSource() == resetButton) { 
			resetBoard();
		}
		if (e.getSource() == menuButton) {
			showMenuPanel();
		}
	}
}




