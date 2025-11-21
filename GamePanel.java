
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
	
	//attributes
	private Tile[] myTiles = new Tile[9];
	private char currentTurn = 'x';
	private ActionListener myListener;
	
	
	//constructor
	public GamePanel() {
		this.setLayout(new GridLayout(3,3));
		for (int i = 0; i < 9; i++) {
			myTiles[i] = new Tile();
			this.add(myTiles[i]);
			myTiles[i].addActionListener(this);
		}
	}
	
	public void setActionListener(ActionListener a) {
		myListener = a;
	}
	
	public void swapTurns() {
		if (currentTurn == 'o') {
			currentTurn = 'x';
		} else {
			currentTurn = 'o';
		}
		if (myListener != null) {
			myListener.actionPerformed(new ActionEvent(this, 0, "Swap"));
			System.out.println("swapped");
		}
	}
	
	
	public void checkWinner() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("clicked");
		Tile source = (Tile)e.getSource();
		source.setSymbol(currentTurn);
		swapTurns();
	}
}
