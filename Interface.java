
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface extends JPanel implements ActionListener{
	
	//attributes
	
	private static JLabel myTurnLabel = new JLabel("Turn: X");
	private static JLabel connect4TurnLabel = new JLabel("Turn: X");
	private static GamePanel myGamePanel = new GamePanel();   					// screen1
	private static connectFourGamePanel myConnect4GamePanel = new connectFourGamePanel();
		
	private static CardLayout cardlayout = new CardLayout();                  // creates the cardLayout
	private static JPanel panelswitcher = new JPanel(cardlayout);             // tells the JPanel how to arrange the contents
	private static JPanel winPanel = new JPanel();                            // screen2
	private static JLabel winLabel = new JLabel();
	private static JPanel buttonsPanel = new JPanel();
	private static JPanel menuPanel = new JPanel();
	private static JButton menuButton = new JButton("Main Menu");
	private static JButton ticTacToeButton = new JButton();
	private static JPanel ticTacToeOptionsPanel = new JPanel();
	private static JButton connectFourButton = new JButton();
	private static JPanel connect4Panel = new JPanel();
	private static JLabel connect4Label = new JLabel("not done");
	private static JButton resetButton  = new JButton("Reset Game");
	private static String theWinner = " ";
	private static String currentGame = "tictactoe";  // Track which game we're playing
	
	// New panels that include the turn label
	private static JPanel ticTacToeGamePanel = new JPanel();
	private static JPanel connect4GamePanel = new JPanel();
	
		//constructor
	public Interface() {
		
		// setting up the tic tac toe game panel with turn label
		ticTacToeGamePanel.setLayout(new BorderLayout());
		ticTacToeGamePanel.add(myTurnLabel, BorderLayout.NORTH);
		ticTacToeGamePanel.add(myGamePanel, BorderLayout.CENTER);
		
		// setting up the connect 4 game panel with turn label
		connect4GamePanel.setLayout(new BorderLayout());
		connect4GamePanel.add(connect4TurnLabel, BorderLayout.NORTH);
		connect4GamePanel.add(myConnect4GamePanel, BorderLayout.CENTER);
		
		// setting up the win panel
		winLabel.setFont(new Font("Jumble", Font.BOLD, 20));
		winLabel.setHorizontalAlignment(JLabel.CENTER);
		
		winPanel.setLayout(new BorderLayout());
		winPanel.setBackground(Color.WHITE);
		winPanel.add(winLabel, BorderLayout.CENTER);
		winPanel.add(buttonsPanel, BorderLayout.SOUTH);
			
		panelswitcher.add(ticTacToeGamePanel, "Gamepanel");
		panelswitcher.add(winPanel, "Win Panel");
		panelswitcher.add(menuPanel, "Menu Panel");
		panelswitcher.add(connect4GamePanel, "Connect 4 Panel");

		this.setLayout(new BorderLayout());
		this.add(panelswitcher, BorderLayout.CENTER);
		
		myTurnLabel.setHorizontalAlignment(JLabel.CENTER);	
		myTurnLabel.setBackground(Color.WHITE);
		myTurnLabel.setOpaque(true);
		
		connect4TurnLabel.setHorizontalAlignment(JLabel.CENTER);	
		connect4TurnLabel.setBackground(Color.WHITE);
		connect4TurnLabel.setOpaque(true);
		
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
		
		connect4Panel.setLayout(new BorderLayout());
		connect4Panel.add(connect4Label, BorderLayout.CENTER);
		connect4Label.setText("Not done");
		connect4Label.setFont(new Font("Jumble", Font.BOLD, 20));
		connect4Panel.setBackground(Color.WHITE);
		
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
		myConnect4GamePanel.setActionListener(this);
	}
	
	
	public void showWhoWon() {
		if (currentGame.equals("tictactoe")) {
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
		} else if (currentGame.equals("connect4")) {
			if (myConnect4GamePanel.getWinner() == 1) {
				theWinner = "Red wins";
				winLabel.setText("Red wins");
			} else if (myConnect4GamePanel.getWinner() == 2) {
				theWinner = "Yellow wins";
				winLabel.setText("Yellow wins");
			}
		}
	}
	
	public static void showWinPanel() {
		currentGame = "tictactoe";
		cardlayout.show(panelswitcher, "Win Panel");
	}
	
	public static void showWinPanelConnect4() {
		currentGame = "connect4";
		cardlayout.show(panelswitcher, "Win Panel");
	}
	
	public static void showMenuPanel() {
		cardlayout.show(panelswitcher, "Menu Panel");
	}
	
	public static void showTicTacToe() {
		currentGame = "tictactoe";
		myGamePanel.resetBoard();
		myTurnLabel.setText("Turn: " + myGamePanel.getTurn());
		cardlayout.show(panelswitcher, "Gamepanel");
	}
	
	
	public static void showConnect4() {
		currentGame = "connect4";
		myConnect4GamePanel.resetBoard();
		connect4TurnLabel.setText("Turn: " + myConnect4GamePanel.getTurn());
		cardlayout.show(panelswitcher, "Connect 4 Panel");
	}
	
	public void resetBoard() {
		if (currentGame.equals("tictactoe")) {
			myGamePanel.resetBoard();
			myTurnLabel.setText("Turn: " + myGamePanel.getTurn());
			cardlayout.show(panelswitcher, "Gamepanel");
		} else if (currentGame.equals("connect4")) {
			myConnect4GamePanel.resetBoard();
			connect4TurnLabel.setText("Turn: " + myConnect4GamePanel.getTurn());
			cardlayout.show(panelswitcher, "Connect 4 Panel");
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Update turn labels
		myTurnLabel.setText("Turn: " + myGamePanel.getTurn());
		connect4TurnLabel.setText("Turn: " + myConnect4GamePanel.getTurn());
		
		showWhoWon();
		
		if (e.getSource() == resetButton) { 
			resetBoard();
		}
		
		if (e.getSource() == menuButton) {
			showMenuPanel();
		}
		
		if (e.getSource() == ticTacToeButton) {
			showTicTacToe();
		}
		
		if (e.getSource() == connectFourButton) {
			showConnect4();
		}
	}
}