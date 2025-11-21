import javax.swing.*;

public class Runner {
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setSize(600, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new GamePanel());
		window.setVisible(true);
	}

}
