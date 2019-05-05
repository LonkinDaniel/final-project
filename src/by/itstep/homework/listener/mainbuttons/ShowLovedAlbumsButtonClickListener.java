package by.itstep.homework.listener.mainbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.itstep.homework.view.ContentPane;
import by.itstep.homework.view.MainButtonsPanel;

// Слушатель для кнопки отображения панели списка избранных альбомов
public class ShowLovedAlbumsButtonClickListener implements ActionListener {

	private MainButtonsPanel mainButtonsPanel;
	private ContentPane contentPane;

	public ShowLovedAlbumsButtonClickListener(MainButtonsPanel mainButtonsPanel) {
		this.mainButtonsPanel = mainButtonsPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		contentPane.getAlbumInfoPanel().setVisible(false);
		contentPane.getAllAlbumsPanel().setVisible(false);
		contentPane.getLovedAlbumsPanel().setVisible(true);
		contentPane.getAddAlbumPanel().setVisible(false);
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
