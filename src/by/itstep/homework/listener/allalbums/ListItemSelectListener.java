package by.itstep.homework.listener.allalbums;

import javax.swing.Icon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import by.itstep.homework.view.AllAlbumsPanel;
import by.itstep.homework.view.ContentPane;

// Слушатель при выборе альбома из списка
public class ListItemSelectListener implements ListSelectionListener {

	private AllAlbumsPanel allAlbumsPanel;
	private ContentPane contentPane;
	private String albumName = null;
	private String artistName = null;
	private String genre = null;
	private Icon albumCover = null;
	private Boolean isLoved;

	public ListItemSelectListener(AllAlbumsPanel allAlbumsPanel) {
		this.allAlbumsPanel = allAlbumsPanel;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		showSelectedAlbum();

		albumName = contentPane.getAllAlbumsPanel().getAllAlbumsList().getSelectedValue().getName();
		artistName = contentPane.getAllAlbumsPanel().getAllAlbumsList().getSelectedValue().getArtist().getName();
		genre = contentPane.getAllAlbumsPanel().getAllAlbumsList().getSelectedValue().getGenre().getName();
		albumCover = contentPane.getAllAlbumsPanel().getAllAlbumsList().getSelectedValue().getAlbumCover();
		isLoved = contentPane.getAllAlbumsPanel().getAllAlbumsList().getSelectedValue().getIsLoved();

		clearFields();
		setAlbumInfo(albumCover, albumName, artistName, genre, isLoved);
	}

	private void showSelectedAlbum() {
		contentPane.getAllAlbumsPanel().showPanel(false);
		contentPane.getAlbumInfoPanel().showPanel(true);
		contentPane.getAlbumInfoPanel().getInfoPanel().showAlbumInfo(true);
	}

	private void setAlbumInfo(Icon albumCover, String albumName, String artistName, String genre, Boolean isLoved) {
		contentPane.getAlbumInfoPanel().getInfoPanel().getAlbumCoverLabel().setIcon(albumCover);
		contentPane.getAlbumInfoPanel().getInfoPanel().getAlbumNameTextPane().setText(albumName);
		contentPane.getAlbumInfoPanel().getInfoPanel().getArtistNameLabel().setText(artistName);
		contentPane.getAlbumInfoPanel().getInfoPanel().getGenreLabel().setText("Жанр: " + genre);
		contentPane.getAlbumInfoPanel().getInfoPanel().getIsLovedAlbumRadioButton().setSelected(isLoved);
	}

	private void clearFields() {
		contentPane.getAlbumInfoPanel().getInfoPanel().getAlbumCoverLabel().setIcon(null);
		contentPane.getAlbumInfoPanel().getInfoPanel().getAlbumNameTextPane().setText("");
		contentPane.getAlbumInfoPanel().getInfoPanel().getArtistNameLabel().setText("");
		contentPane.getAlbumInfoPanel().getInfoPanel().getGenreLabel().setText("Жанр: ");
		contentPane.getAlbumInfoPanel().getInfoPanel().getIsLovedAlbumRadioButton().setSelected(false);
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
