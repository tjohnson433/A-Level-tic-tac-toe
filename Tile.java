import javax.swing.*;

public class Tile extends JButton{
	
	//attributes
	private char mySymbol = ' ';
	
	//methods
	public void setSymbol(char s) {
		mySymbol = 's';
		if (s == ' ') {
			this.setText("");
		} else {
			this.setText("" + s);
		}		
	}
	
	
	
	public char getSymbol() {
		return mySymbol;
	}
}
