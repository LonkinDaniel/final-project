package by.itstep.homework.listener.lovedalbums;

import javax.swing.Icon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import by.itstep.homework.gui.ContentPane;
import by.itstep.homework.gui.LovedAlbumsPanel;
import by.itstep.homework.model.Database;

// Слушатель при выборе альбома из списка 
public class ListItemSelectListener implements ListSelectionListener {

	private LovedAlbumsPanel lovedAlbumsPanel;
	private ContentPane contentPane;
	private String searchedAlbumName = null;
	private String albumName = null;
	private String artist = null;
	private String genre = null;
	private Icon albumCover = null;
	private Boolean isLoved;

	public ListItemSelectListener(LovedAlbumsPanel lovedAlbumsPanel) {
		this.lovedAlbumsPanel = lovedAlbumsPanel;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		contentPane.lovedAlbumsPanel.showPanel(false);
		contentPane.albumInfoPanel.showPanel(true);

		contentPane.albumInfoPanel.infoPanel.showAlbumInfo(true);

		searchedAlbumName = contentPane.lovedAlbumsPanel.lovedAlbumsList.getSelectedValue().getName();
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
