
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class connectFourGamePanel extends JPanel implements ActionListener{
	
	private Tile[] connect4Tiles = new Tile[42];
	private char currentTurn = 'X'; 
	private ActionListener myListener;
	private static boolean winner = false;
	private int whichWinner = 0; //testing repository
	
	public connectFourGamePanel() {
		this.setLayout(new GridLayout(6,7));
		for (int i = 0; i < 42; i++) {
			connect4Tiles[i] = new Tile();
			this.add(connect4Tiles[i]);
			connect4Tiles[i].addActionListener(this);
		} 
		updateAvailableTiles();
	}
	
	public void setActionListener(ActionListener a) {
		myListener = a;
	}
	
	public void swapTurns() {
		if (currentTurn == 'O') {
			currentTurn = 'X';
		} else {
			currentTurn = 'O';
		}
		if (myListener != null) {
			myListener.actionPerformed(new ActionEvent(this, 0, "Swap"));
		}
	}
	
	public char getTurn() {
		return currentTurn;
	}
	
	// Update which tiles can be clicked (only tiles with support below them)
	private void updateAvailableTiles() {
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				int index = row * 7 + col;
				
				// If tile already has a symbol, keep it disabled
				if (connect4Tiles[index].getSymbol() != ' ') {
					connect4Tiles[index].setEnabled(false);
				}
				// Bottom row is always clickable (if empty)
				else if (row == 5) {
					connect4Tiles[index].setEnabled(true);
				}
				// Other rows: only clickable if tile below has a symbol
				else {
					int belowIndex = (row + 1) * 7 + col;
					if (connect4Tiles[belowIndex].getSymbol() != ' ') {
						connect4Tiles[index].setEnabled(true);
					} else {
						connect4Tiles[index].setEnabled(false);
					}
				}
			}
		}
	}
	
	public void resetBoard() {
		for (int i = 0; i < 42; i++) { 
			connect4Tiles[i].setSymbol(' ');
			connect4Tiles[i].setEnabled(true);
		}
		currentTurn = 'X';
		winner = false;
		whichWinner = 0;
		updateAvailableTiles();
	}
	
	public void checkWinner() {
		// Check horizontal (4 in a row left-right)
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 4; col++) {
				checkFour(row * 7 + col, row * 7 + col + 1, row * 7 + col + 2, row * 7 + col + 3);
			}
		}
		
		// Check vertical (4 in a row up-down)
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 7; col++) {
				checkFour(row * 7 + col, (row + 1) * 7 + col, (row + 2) * 7 + col, (row + 3) * 7 + col);
			}
		}
		
		// Check diagonal (down-right)
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 4; col++) {
				checkFour(row * 7 + col, (row + 1) * 7 + col + 1, (row + 2) * 7 + col + 2, (row + 3) * 7 + col + 3);
			}
		}
		
		// Check diagonal (down-left)
		for (int row = 0; row < 3; row++) {
			for (int col = 3; col < 7; col++) {
				checkFour(row * 7 + col, (row + 1) * 7 + col - 1, (row + 2) * 7 + col - 2, (row + 3) * 7 + col - 3);
			}
		}
	}
	
	private void checkFour(int a, int b, int c, int d) {
		if (connect4Tiles[a].getSymbol() == connect4Tiles[b].getSymbol() && 
			connect4Tiles[b].getSymbol() == connect4Tiles[c].getSymbol() && 
			connect4Tiles[c].getSymbol() == connect4Tiles[d].getSymbol() &&
			connect4Tiles[a].getSymbol() != ' ') {
			
			winner = true;
			
			if (winner == true) {
				if (connect4Tiles[a].getSymbol() == 'X') {
					whichWinner = 1;
				} else if (connect4Tiles[a].getSymbol() == 'O') {
					whichWinner = 2;
				}
			}
		}
	}
	
	public int getWinner() {
		return whichWinner;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Tile source = (Tile)e.getSource();		
		source.setSymbol(currentTurn);
		
		checkWinner();
		if (winner == true) {
			Interface.showWinPanelConnect4();
		}
		
		updateAvailableTiles();
		swapTurns();
	}
}