package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class helpWin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void helpScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					helpWin window = new helpWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public helpWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 504);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(helpWin.class.getResource("/help2.png")));
		lblNewLabel.setBounds(0, 0, 749, 465);
		frame.getContentPane().add(lblNewLabel);
	}
}
