package by.itstep.homework.gui;

import javax.swing.JFileChooser;

public class CoverAlbumChooserDialog extends JFileChooser {

	private static final long serialVersionUID = 1346160796746914653L;
	private AddAlbumPanel addAlbumPanel;

	public CoverAlbumChooserDialog(AddAlbumPanel addAlbumPanel) {
		this.addAlbumPanel = addAlbumPanel;
	}

	public CoverAlbumChooserDialog() {
		this.setFileSelectionMode(JFileChooser.FILES_ONLY);
		this.setDialogTitle("Выберите картинку");
	}
}
