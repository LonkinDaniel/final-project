package by.itstep.homework.listener.mainbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import by.itstep.homework.gui.ContentPane;
import by.itstep.homework.gui.MainButtonsPanel;

// Слушатель для кнопки отображения панели добавления нового альбома
public class ShowAddAlbumPanelButtonClickListener implements ActionListener {

	private MainButtonsPanel mainButtonsPanel;
	private ContentPane contentPane;

	public ShowAddAlbumPanelButtonClickListener(MainButtonsPanel mainButtonsPanel) {
		this.mainButtonsPanel = mainButtonsPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		contentPane.albumInfoPanel.showPanel(false);
		contentPane.allAlbumsPanel.showPanel(false);
		contentPane.lovedAlbumsPanel.showPanel(false);
		contentPane.addAlbumPanel.showPanel(true);

		contentPane.addAlbumPanel.albumNameAddAlbumTextField.setText("");
		contentPane.addAlbumPanel.artistNameAddAlbumTextField.setText("");
		contentPane.addAlbumPanel.genreAddAlbumTextField.setText("");
		contentPane.addAlbumPanel.albumCoverAddAlbumLabel.setIcon(null);
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
