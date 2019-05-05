package by.itstep.homework.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI extends JFrame {

	public ContentPane contentPane;

	private static final long serialVersionUID = 6473202730372239115L;

	public GUI() {
		this.setTitle("Musical Library");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 626, 448);
		this.setLocationRelativeTo(null);
		this.buildGUI();
	}

	public void showWindow() {
		this.setVisible(true);
	}

	public static void showMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showError(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}

	public static boolean showConfirmation(String message, String title) {
		return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	private void buildGUI() {
		contentPane = new ContentPane();
		this.setContentPane(contentPane);
	}
}
