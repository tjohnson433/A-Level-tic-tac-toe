import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface extends JPanel implements ActionListener{
	//attributes
	private JLabel myTurnLabel = new JLabel("Turn: X");
	private GamePanel myGamePanel = new GamePanel();
	
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
