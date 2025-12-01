package ticTacToe;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
	
	//attributes
	private Tile[] myTiles = new Tile[9];
	private char currentTurn = 'X';
	private ActionListener myListener;
	private static boolean winner = false;
	private int whichWinner = 0;
	
	
	
	
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
		if (currentTurn == 'O') {
			currentTurn = 'X';
		} else {
			currentTurn = 'O';
		}
		if (myListener != null) {
			myListener.actionPerformed(new ActionEvent(this, 0, "Swap"));
		}
	}
	
	
	public void checkWinner() {
	    // check rows
	    checkThree(0, 1, 2);
	    checkThree(3, 4, 5);
	    checkThree(6, 7, 8);
	    
	    // check columns
	    checkThree(0, 3, 6);
	    checkThree(1, 4, 7);
	    checkThree(2, 5, 8);
	    
	    // check diagonals
	    checkThree(0, 4, 8);
	    checkThree(2, 4, 6);
	}

	private void checkThree(int a, int b, int c) {
	    if (myTiles[a].getSymbol() == myTiles[b].getSymbol() && 
	        myTiles[b].getSymbol() == myTiles[c].getSymbol() && 
	        myTiles[a].getSymbol() != ' ') {                    // are a, b and c all the same? and not just empty
	    	
	    	winner = true;
	        System.out.println("winner: " + myTiles[a].getSymbol());
	        
	        
	        if (winner == true) {
	        	if (myTiles[a].getSymbol() == 'X') {                    //if winner is X set whichWinner to 1, set whichWinner to 2 if O wins, if whchWinner = 0 then its a draw
	        		whichWinner = 1;
	        	} else if (myTiles[a].getSymbol() == 'O') {
	        		whichWinner = 2;
	        	}
	        }
	    }
	}
	
	public char getTurn() {
		return currentTurn;
	}
	
	
	public int getWinner() {
		return whichWinner;
	}
	
	public void checkFullTiles() {
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
		Tile source = (Tile)e.getSource();		
		source.setSymbol(currentTurn);
		
		checkWinner();
		if (winner == true) {
			Interface.showWinPanel();
		}
		
		swapTurns();
	}
}
