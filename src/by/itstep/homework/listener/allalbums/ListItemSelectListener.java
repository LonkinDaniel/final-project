package by.itstep.homework.listener.allalbums;

import javax.swing.Icon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import by.itstep.homework.gui.AllAlbumsPanel;
import by.itstep.homework.gui.ContentPane;

// Слушатель при выборе альбома из списка
public class ListItemSelectListener implements ListSelectionListener {

	private AllAlbumsPanel allAlbumsPanel;
	private ContentPane contentPane;
	private String searchedAlbumName = null;
	private String albumName = null;
	private String artist = null;
	private String genre = null;
	private Icon albumCover = null;
	private Boolean isLoved;

	public ListItemSelectListener(AllAlbumsPanel allAlbumsPanel) {
		this.allAlbumsPanel = allAlbumsPanel;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		contentPane.allAlbumsPanel.showPanel(false);
		contentPane.albumInfoPanel.showPanel(true);

		contentPane.albumInfoPanel.infoPanel.showAlbumInfo(true);

		searchedAlbumName = contentPane.allAlbumsPanel.allAlbumsList.getSelectedValue().getName();
		albumName = contentPane.database.getAlbumByName(searchedAlbumName).getName();
		artist = contentPane.database.getAlbumByName(albumName).getArtist().getName();
		genre = contentPane.database.getAlbumByName(albumName).getGenre().getName();
		albumCover = contentPane.database.getAlbumByName(albumName).getAlbumCover();
		isLoved = contentPane.database.getAlbumByName(albumName).getIsLoved();

		contentPane.albumInfoPanel.infoPanel.albumCoverLabel.setIcon(albumCover);
		contentPane.albumInfoPanel.infoPanel.albumNameTextPane.setText(albumName);
		contentPane.albumInfoPanel.infoPanel.artistNameLabel.setText(artist);
		contentPane.albumInfoPanel.infoPanel.genreLabel
				.setText(contentPane.albumInfoPanel.infoPanel.genreLabel.getText() + " " + genre);
		contentPane.albumInfoPanel.infoPanel.isLovedAlbumRadioButton.setSelected(isLoved);
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
