package by.itstep.homework.listener.addalbum;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import by.itstep.homework.view.AddAlbumPanel;
import by.itstep.homework.view.ContentPane;

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

			int labelWidth = addAlbumPanel.getAlbumCoverAddAlbumLabel().getWidth();
			int labelHeight = addAlbumPanel.getAlbumCoverAddAlbumLabel().getHeight();
			ImageIcon imageIcon = new ImageIcon(resizeImage(labelWidth, labelHeight, image));

			addAlbumPanel.getAlbumCoverAddAlbumLabel().setIcon(imageIcon);

		}
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

	// Изменение размера выбранной картинки к размеру надписи
	private Image resizeImage(int width, int height, BufferedImage image) {
		Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return resizedImage;
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
