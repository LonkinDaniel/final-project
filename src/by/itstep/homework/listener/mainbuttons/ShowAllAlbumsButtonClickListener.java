package by.itstep.homework.listener.mainbuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

import by.itstep.homework.gui.ContentPane;
import by.itstep.homework.gui.MainButtonsPanel;
import by.itstep.homework.model.Album;
import by.itstep.homework.model.Database;

//Слушатель для кнопки отображения панели списка всех альбомов
public class ShowAllAlbumsButtonClickListener implements ActionListener {

	private MainButtonsPanel mainButtonsPanel;
	private ContentPane contentPane;

	public ShowAllAlbumsButtonClickListener(MainButtonsPanel mainButtonsPanel) {
		this.mainButtonsPanel = mainButtonsPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		contentPane.albumInfoPanel.setVisible(false);
		contentPane.allAlbumsPanel.setVisible(true);
		contentPane.lovedAlbumsPanel.setVisible(false);
		contentPane.addAlbumPanel.setVisible(false);

		this.showAllAlbums();
	}

	private void showAllAlbums() {
		Database database = new Database();
		DefaultListModel<Album> listModel = new DefaultListModel<>();
		for (int i = 0; i < database.getAllAlbums().length; i++) {
			listModel.addElement(database.getAllAlbums()[i]);
		}
		contentPane.allAlbumsPanel.allAlbumsList.setModel(listModel);
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
