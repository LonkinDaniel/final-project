package by.itstep.homework.gui;

import javax.swing.JPanel;

public abstract class Panel extends JPanel {

	protected ContentPane contentPane;

	private static final long serialVersionUID = 6248880880917673482L;

	public abstract void build();

	public abstract void showPanel(Boolean flag);
}
