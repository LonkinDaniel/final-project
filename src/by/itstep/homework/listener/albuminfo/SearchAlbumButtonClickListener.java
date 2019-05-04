package by.itstep.homework.listener.albuminfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import by.itstep.homework.gui.AlbumInfoPanel;
import by.itstep.homework.gui.ContentPane;
import by.itstep.homework.gui.GUI;
import by.itstep.homework.gui.SearchAlbumPanel;
import by.itstep.homework.model.Database;

// Слушатель для кнопки поиска альбома
public class SearchAlbumButtonClickListener implements ActionListener {

	private AlbumInfoPanel albumInfoPanel;
	private ContentPane contentPane;
	private String searchedAlbumName = null;
	private String albumName = null;
	private String artist = null;
	private String genre = null;
	private Icon albumCover = null;
	private boolean isLoved;

	public SearchAlbumButtonClickListener(AlbumInfoPanel albumInfoPanel) {
		this.albumInfoPanel = albumInfoPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!albumInfoPanel.searchAlbumPanel.albumNameSearchTextField.getText().isEmpty()) {
			if (contentPane.database.isAlbumAdded(albumInfoPanel.searchAlbumPanel.albumNameSearchTextField.getText())) {
				searchedAlbumName = albumInfoPanel.searchAlbumPanel.albumNameSearchTextField.getText();
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

				albumInfoPanel.infoPanel.showAlbumInfo(true);
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

}
