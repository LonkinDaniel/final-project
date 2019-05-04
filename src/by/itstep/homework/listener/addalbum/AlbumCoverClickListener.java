package by.itstep.homework.listener.addalbum;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import by.itstep.homework.gui.AddAlbumPanel;
import by.itstep.homework.gui.ContentPane;

public class AlbumCoverClickListener implements MouseListener {

	private ContentPane contentPane;
	private AddAlbumPanel addAlbumPanel;
	private int aproveSelection;

	public AlbumCoverClickListener(AddAlbumPanel addAlbumPanel) {
		this.addAlbumPanel = addAlbumPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		aproveSelection = addAlbumPanel.getCoverAlbumChooserDialog().showOpenDialog(addAlbumPanel);
		if (this.aproveSelection == JFileChooser.APPROVE_OPTION) {
			File file = addAlbumPanel.getCoverAlbumChooserDialog().getSelectedFile();
			BufferedImage image = null;
			try {
				image = ImageIO.read(file);
			} catch (IOException exception) {
			}
			Image resizedImage = image.getScaledInstance(addAlbumPanel.albumCoverAddAlbumLabel.getWidth(),
					addAlbumPanel.albumCoverAddAlbumLabel.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(resizedImage);
			addAlbumPanel.albumCoverAddAlbumLabel.setIcon(imageIcon);

		}
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
