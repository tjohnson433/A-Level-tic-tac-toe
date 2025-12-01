package ticTacToe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface extends JPanel implements ActionListener{
	
	//attributes
	private static JLabel myTurnLabel = new JLabel("Turn: X");
	private static GamePanel myGamePanel = new GamePanel();                               // screen1
		
	private static CardLayout cardlayout = new CardLayout();
	private static JPanel panelswitcher = new JPanel(cardlayout);
	private static JPanel winPanel = new JPanel();
	private static JLabel winLabel = new JLabel();
	private static JButton resetButton  =new JButton("Reset Game");

	private String theWinner = " ";
	
	
		//constructor
	public Interface() {
		
		// setting up the win panel
		
		winPanel.setLayout(new BorderLayout());
		winLabel.setFont(new Font("Jumble", Font.BOLD, 20));
		winLabel.setHorizontalAlignment(JLabel.CENTER);
		winPanel.add(winLabel, BorderLayout.CENTER);
			
		panelswitcher.add(myGamePanel, "Gamepanel");
		panelswitcher.add(winPanel, "Win Panel");

		this.setLayout(new BorderLayout());
		this.add(panelswitcher, BorderLayout.CENTER);
		this.add(myTurnLabel, BorderLayout.NORTH);
	
		myGamePanel.setActionListener(this);
	}
	
	
	public void showWhoWon() {
		
		if (myGamePanel.getWinner() == 0) {
			theWinner = "Draw";
			winLabel.setText("Draw");
		} else if (myGamePanel.getWinner() == 1) {
			theWinner = "Crosses wins";
			winLabel.setText("Crosses wins");
		} else {
			theWinner = "Noughts wins";
			winLabel.setText("Noughts wins");
		}
		
	}
	
	public static void showWinPanel() {
		cardlayout.show(panelswitcher, "Win Panel");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		myTurnLabel.setHorizontalAlignment(JLabel.CENTER);
		myTurnLabel.setText("Turn: " + myGamePanel.getTurn());
		showWhoWon();
	}
}
