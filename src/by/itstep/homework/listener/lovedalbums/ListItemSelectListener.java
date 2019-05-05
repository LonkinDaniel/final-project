package by.itstep.homework.listener.lovedalbums;

import javax.swing.Icon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import by.itstep.homework.view.ContentPane;
import by.itstep.homework.view.LovedAlbumsPanel;

// Слушатель при выборе альбома из списка 
public class ListItemSelectListener implements ListSelectionListener {

	private LovedAlbumsPanel lovedAlbumsPanel;
	private ContentPane contentPane;
	private String albumName = null;
	private String artistName = null;
	private String genre = null;
	private Icon albumCover = null;
	private Boolean isLoved;

	public ListItemSelectListener(LovedAlbumsPanel lovedAlbumsPanel) {
		this.lovedAlbumsPanel = lovedAlbumsPanel;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {

		showSelectedAlbum();

		albumName = contentPane.getLovedAlbumsPanel().getLovedAlbumsList().getSelectedValue().getName();
		artistName = contentPane.getLovedAlbumsPanel().getLovedAlbumsList().getSelectedValue().getArtist().getName();
		genre = contentPane.getLovedAlbumsPanel().getLovedAlbumsList().getSelectedValue().getGenre().getName();
		albumCover = contentPane.getLovedAlbumsPanel().getLovedAlbumsList().getSelectedValue().getAlbumCover();
		isLoved = contentPane.getLovedAlbumsPanel().getLovedAlbumsList().getSelectedValue().getIsLoved();

		clearFields();
		setAlbumInfo(albumCover, albumName, artistName, genre, isLoved);
	}

	private void showSelectedAlbum() {
		contentPane.lovedAlbumsPanel.showPanel(false);
		contentPane.albumInfoPanel.showPanel(true);
		contentPane.albumInfoPanel.getInfoPanel().showAlbumInfo(true);
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
