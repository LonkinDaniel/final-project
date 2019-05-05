package by.itstep.homework.exceptions;

import by.itstep.homework.view.GUI;

// Исключение "Альбом уже добавлен"
public class AlbumExistsException extends Exception {

	private static final long serialVersionUID = -6471732111162437133L;

	public AlbumExistsException() {
		this.showMessage();
	}

	public void showMessage() {
		String errorMessage = "Альбом уже добавлен. Измените имя в поле, чтобы добавить другой альбом";
		GUI.showError(errorMessage, "Альбом уже добавлен");
	}

}
