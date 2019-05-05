package by.itstep.homework.listener.mainbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.itstep.homework.view.ContentPane;
import by.itstep.homework.view.MainButtonsPanel;

// Слушатель для кнопки отображения панели добавления нового альбома
public class ShowAddAlbumPanelButtonClickListener implements ActionListener {

	private MainButtonsPanel mainButtonsPanel;
	private ContentPane contentPane;

	public ShowAddAlbumPanelButtonClickListener(MainButtonsPanel mainButtonsPanel) {
		this.mainButtonsPanel = mainButtonsPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		showAddAlbumPanel();
		clearFields();
	}

	private void showAddAlbumPanel() {
		contentPane.getAlbumInfoPanel().showPanel(false);
		contentPane.getAllAlbumsPanel().showPanel(false);
		contentPane.getLovedAlbumsPanel().showPanel(false);
		contentPane.getAddAlbumPanel().showPanel(true);
	}

	private void clearFields() {
		contentPane.getAddAlbumPanel().getAlbumNameAddAlbumTextField().setText("");
		contentPane.getAddAlbumPanel().getArtistNameAddAlbumTextField().setText("");
		contentPane.getAddAlbumPanel().getGenreAddAlbumTextField().setText("");
		contentPane.getAddAlbumPanel().getAlbumCoverAddAlbumLabel().setIcon(null);
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
