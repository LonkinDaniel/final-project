package by.itstep.homework.view;

import javax.swing.JPanel;

public abstract class Panel extends JPanel {

	protected ContentPane contentPane;

	private static final long serialVersionUID = 6248880880917673482L;

	public abstract void build();

	public abstract void showPanel(Boolean flag);

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
