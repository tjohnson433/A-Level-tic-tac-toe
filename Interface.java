package ticTacToe;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface extends JPanel implements ActionListener{
	
	//attributes
	private JLabel myTurnLabel = new JLabel("Turn: X");
	private GamePanel myGamePanel = new GamePanel();
	private CardLayout cardlayout = new CardLayout();
	private JPanel cardPanel = new JPanel();		
	private JPanel winPanel = new JPanel();
	private JLabel winLabel = new JLabel();
	private JButton resetButton = new JButton("Reset");
	private JButton specialGameMode = new JButton("Special Mode");
	private JButton normalGameMode = new JButton("Normal");
		
	// set up panels
	
	win
	
	
	
	
	
	
	//button methods
	
	public void resetGame() {
		
	}
	
	//constructor
	public Interface() {
		this.setLayout(new BorderLayout());
		this.add(myGamePanel, BorderLayout.CENTER);
		this.add(myTurnLabel, BorderLayout.NORTH);
		
		myGamePanel.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
