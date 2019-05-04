package by.itstep.homework.listener.addalbum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.Icon;

import by.itstep.homework.exceptions.AlbumExistsException;
import by.itstep.homework.gui.AddAlbumPanel;
import by.itstep.homework.gui.ContentPane;
import by.itstep.homework.gui.GUI;
import by.itstep.homework.model.Album;
import by.itstep.homework.model.Artist;
import by.itstep.homework.model.Genre;

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
	private File albumCoverImage = null;
	private final String PIC_FOLDER_PATH = "/MusicLibrary/pic";

	public AddAlbumButtonClickListener(AddAlbumPanel addAlbumPanel) {
		this.addAlbumPanel = addAlbumPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!addAlbumPanel.areFieldsEmpty()) {
			albumName = addAlbumPanel.albumNameAddAlbumTextField.getText();
			genreName = addAlbumPanel.genreAddAlbumTextField.getText();
			artistName = addAlbumPanel.artistNameAddAlbumTextField.getText();
			albumCover = addAlbumPanel.albumCoverAddAlbumLabel.getIcon();

			artist = new Artist(artistName);
			genre = new Genre(genreName);
			album = new Album(albumName, artist, genre, albumCover);

			try {
				contentPane.database.addAlbum(album);
				contentPane.database.addArtist(artist);
				contentPane.database.addGenre(genre);
				album.setAlbumCover(albumCover);

			} catch (AlbumExistsException exception) {
				exception.showMessage();
			}
		} else {
			GUI.showError("Заполните все поля!", "Пустые поля");
		}

		if (contentPane.database.albums.contains(album)) {
//			try {
//				copyFileUsingStream(albumCoverImage, PIC_FOLDER_PATH);
//			} catch (IOException exception) {
//				exception.printStackTrace();
//			}
			showAlbumAddedMessage();
			addAlbumPanel.showPanel(false);
			contentPane.albumInfoPanel.showPanel(true);
		}
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

//	private void copyFileUsingStream(File sourceFile, String destination) throws IOException {
//		InputStream inputStream = null;
//		OutputStream outputStream = null;
//		byte[] buffer = new byte[1024];
//		int fileLength;
//		try {
//			inputStream = new FileInputStream(sourceFile);
//			outputStream = new FileOutputStream(destination);
//			while ((fileLength = inputStream.read(buffer)) > 0) {
//				outputStream.write(buffer, 0, fileLength);
//			}
//		} finally {
//			inputStream.close();
//			outputStream.close();
//		}
//	}

	private void showAlbumAddedMessage() {
		GUI.showMessage("Альбом добавлен", "Успех");
	}

}
