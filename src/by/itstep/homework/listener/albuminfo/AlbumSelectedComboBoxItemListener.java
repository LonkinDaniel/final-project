package by.itstep.homework.listener.albuminfo;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;

import by.itstep.homework.view.ContentPane;
import by.itstep.homework.view.InfoPanel;

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
		albumCover = infoPanel.getSelectedAlbum().getAlbumCover();
		albumName = infoPanel.getSelectedAlbum().getName();
		artistName = infoPanel.getSelectedAlbum().getArtist().getName();
		genre = infoPanel.getSelectedAlbum().getGenre().getName();
		isLoved = infoPanel.getSelectedAlbum().getIsLoved().booleanValue();

		setAlbumInfo(albumCover, albumName, artistName, genre, isLoved);

		infoPanel.showAlbumInfo(true);
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

	private void setAlbumInfo(Icon albumCover, String albumName, String artistName, String genre, Boolean isLoved) {
		infoPanel.getAlbumCoverLabel().setIcon(albumCover);
		infoPanel.getAlbumNameTextPane().setText(albumName);
		infoPanel.getArtistNameLabel().setText(artistName);
		infoPanel.getGenreLabel().setText(genre);
		infoPanel.getIsLovedAlbumRadioButton().setSelected(isLoved);
	}

}
