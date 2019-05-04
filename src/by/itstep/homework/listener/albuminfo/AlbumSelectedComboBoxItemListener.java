package by.itstep.homework.listener.albuminfo;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;

import by.itstep.homework.gui.ContentPane;
import by.itstep.homework.gui.InfoPanel;

public class AlbumSelectedComboBoxItemListener implements ItemListener {

	private InfoPanel infoPanel;
	private ContentPane contentPane;
	private Icon albumCover = null;
	private String albumName = null;
	private String artistName = null;
	private String genre = null;
	private Boolean isLoved;

	public AlbumSelectedComboBoxItemListener(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		infoPanel.showAlbumInfo(true);

		albumCover = infoPanel.getSelectedAlbum().getAlbumCover();
		albumName = infoPanel.getSelectedAlbum().getName();
		artistName = infoPanel.getSelectedAlbum().getArtist().getName();
		genre = infoPanel.getSelectedAlbum().getGenre().getName();
		isLoved = infoPanel.getSelectedAlbum().getIsLoved().booleanValue();

		infoPanel.albumCoverLabel.setIcon(albumCover);
		infoPanel.albumNameTextPane.setText(albumName);
		infoPanel.artistNameLabel.setText(artistName);
		infoPanel.genreLabel.setText(genre);
		infoPanel.isLovedAlbumRadioButton.setSelected(isLoved);
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
