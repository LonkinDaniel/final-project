package by.itstep.homework.listener.albuminfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import by.itstep.homework.view.AlbumInfoPanel;
import by.itstep.homework.view.ContentPane;
import by.itstep.homework.view.GUI;

// Слушатель для кнопки поиска альбома
public class SearchAlbumButtonClickListener implements ActionListener {

	private AlbumInfoPanel albumInfoPanel;
	private ContentPane contentPane;
	private String searchedAlbumName = null;
	private String albumName = null;
	private String artistName = null;
	private String genre = null;
	private Icon albumCover = null;
	private boolean isLoved;

	public SearchAlbumButtonClickListener(AlbumInfoPanel albumInfoPanel) {
		this.albumInfoPanel = albumInfoPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		searchedAlbumName = albumInfoPanel.getSearchAlbumPanel().getAlbumNameSearchTextField().getText();

		if (!albumInfoPanel.getSearchAlbumPanel().isSearchFieldEmpty()) {
			if (isAlbumFound(searchedAlbumName)) {
				albumName = contentPane.getDatabase().getAlbumByName(searchedAlbumName).getName();
				artistName = contentPane.getDatabase().getAlbumByName(albumName).getArtist().getName();
				genre = contentPane.getDatabase().getAlbumByName(albumName).getGenre().getName();
				albumCover = contentPane.getDatabase().getAlbumByName(albumName).getAlbumCover();
				isLoved = contentPane.getDatabase().getAlbumByName(albumName).getIsLoved();

				setAlbumInfo(albumCover, albumName, artistName, genre, isLoved);

				albumInfoPanel.getInfoPanel().showAlbumInfo(true);
			} else {
				GUI.showError("Альбом не найден.", "Ошибка");
			}
		} else {
			GUI.showError("Вы ничего не ввели. Заполните поле названием альбома и нажмите \"Поиск\"", "Поле пустое");
		}
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

	private void setAlbumInfo(Icon albumCover, String albumName, String artistName, String genre, boolean isLoved) {
		contentPane.albumInfoPanel.getInfoPanel().getAlbumCoverLabel().setIcon(albumCover);
		contentPane.albumInfoPanel.getInfoPanel().getAlbumNameTextPane().setText(albumName);
		contentPane.albumInfoPanel.getInfoPanel().getArtistNameLabel().setText(artistName);
		contentPane.albumInfoPanel.getInfoPanel().getGenreLabel().setText("Жанр: " + genre);
		contentPane.albumInfoPanel.getInfoPanel().getIsLovedAlbumRadioButton().setSelected(isLoved);
	}

	private boolean isAlbumFound(String albumName) {
		return contentPane.getDatabase().isAlbumAdded(albumName);
	}

}
