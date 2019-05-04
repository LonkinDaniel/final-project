package by.itstep.homework.listener.mainbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import by.itstep.homework.gui.ContentPane;
import by.itstep.homework.gui.MainButtonsPanel;
import by.itstep.homework.model.Album;
import by.itstep.homework.model.Database;

// Слушатель для кнопки отображения панели списка избранных альбомов
public class ShowLovedAlbumsButtonClickListener implements ActionListener {

	private MainButtonsPanel mainButtonsPanel;
	private ContentPane contentPane;

	public ShowLovedAlbumsButtonClickListener(MainButtonsPanel mainButtonsPanel) {
		this.mainButtonsPanel = mainButtonsPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Database database = new Database();
		DefaultListModel<Album> listModel = new DefaultListModel<>();
		for (int i = 0; i < database.getAllLovedAlbums().length; i++) {
			listModel.addElement(database.getAllLovedAlbums()[i]);
		}
		contentPane.lovedAlbumsPanel.lovedAlbumsList.setModel(listModel); // Null

		contentPane.albumInfoPanel.setVisible(false);
		contentPane.allAlbumsPanel.setVisible(false);
		contentPane.lovedAlbumsPanel.setVisible(true);
		contentPane.addAlbumPanel.setVisible(false);
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
