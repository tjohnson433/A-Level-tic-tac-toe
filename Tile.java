import javax.swing.*;

public class Tile extends JButton{
	
	//attributes
	private char mySymbol = ' ';
	private boolean  clicked = false;
	
	//methods
	public void setSymbol(char s) {
		mySymbol = s;
		if (s == ' ') {
			this.setText("");
		} else {
			this.setText("" + s);
		}		
		this.setEnabled(false);
	}
	
	public boolean isClicked() {
		return !this.isEnabled();
	}
	
	//public (boolean c)
	
	public char getSymbol() {
		return mySymbol;
	}
}

