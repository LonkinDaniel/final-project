package by.itstep.homework.listener.addalbum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import by.itstep.homework.exceptions.AlbumExistsException;
import by.itstep.homework.model.Album;
import by.itstep.homework.model.Artist;
import by.itstep.homework.model.Genre;
import by.itstep.homework.view.AddAlbumPanel;
import by.itstep.homework.view.ContentPane;
import by.itstep.homework.view.GUI;

// Слушатель для кнопки добавления альбома
public class AddAlbumButtonClickListener implements ActionListener {

	private AddAlbumPanel addAlbumPanel;
	private Album album;
	private Artist artist;
	private Genre genre;
	private ContentPane contentPane;
	private String albumName = null;
	private String genreName = null;
	private String artistName = null;
	private Icon albumCover = null;
	private DefaultListModel<Album> listModel = new DefaultListModel<>();

	public AddAlbumButtonClickListener(AddAlbumPanel addAlbumPanel) {
		this.addAlbumPanel = addAlbumPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!addAlbumPanel.areFieldsEmpty()) {
			albumName = addAlbumPanel.getAlbumNameAddAlbumTextField().getText();
			genreName = addAlbumPanel.getGenreAddAlbumTextField().getText();
			artistName = addAlbumPanel.getArtistNameAddAlbumTextField().getText();
			albumCover = addAlbumPanel.getAlbumCoverAddAlbumLabel().getIcon();

			artist = new Artist(artistName);
			genre = new Genre(genreName);
			album = new Album(albumName, artist, genre, albumCover);

			addInfoToDatabase(artist, genre, album);
		} else {
			GUI.showError("Заполните все поля!", "Пустые поля");
		}

		if (contentPane.getDatabase().isAlbumAdded(album.getName())) {
			addItemToAlbumsComboBox(album);
			addAlbumToAllAlbumList(album);
			showAlbumAddedMessage();
			addAlbumPanel.showPanel(false);
			contentPane.getAlbumInfoPanel().showPanel(true);
			contentPane.getAlbumInfoPanel().getInfoPanel().showAlbumInfo(false);
		}
	}

	private void addAlbumToAllAlbumList(Album album) {
		if (!listModel.contains(album)) {
			listModel.addElement(album);
			contentPane.getAllAlbumsPanel().getAllAlbumsList().setModel(listModel);
		}
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

	private void addInfoToDatabase(Artist artist, Genre genre, Album album) {
		try {
			contentPane.database.addAlbum(album);
			contentPane.database.addArtist(artist);
			contentPane.database.addGenre(genre);
			album.setAlbumCover(albumCover);

		} catch (AlbumExistsException exception) {
			exception.showMessage();
		}
	}

	private void addItemToAlbumsComboBox(Album album) {
		contentPane.getAlbumInfoPanel().getInfoPanel().getAlbumsComboBox().addItem(album);
	}

	private void showAlbumAddedMessage() {
		GUI.showMessage("Альбом добавлен", "Успех");
	}

}
