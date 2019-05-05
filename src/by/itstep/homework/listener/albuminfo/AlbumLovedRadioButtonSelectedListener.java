package by.itstep.homework.listener.albuminfo;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultListModel;

import by.itstep.homework.model.Album;
import by.itstep.homework.view.ContentPane;
import by.itstep.homework.view.InfoPanel;

public class AlbumLovedRadioButtonSelectedListener implements ItemListener {

	private InfoPanel infoPanel;
	private ContentPane contentPane;
	private DefaultListModel<Album> listModel = new DefaultListModel<>();

	public AlbumLovedRadioButtonSelectedListener(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Album album = contentPane.getDatabase().getAlbumByName(infoPanel.getAlbumNameTextPane().getText());
		if (e.getStateChange() == ItemEvent.SELECTED) {
			album.setIsLoved(true);
			if (!listModel.contains(album)) {
				listModel.addElement(album);
				contentPane.getLovedAlbumsPanel().getLovedAlbumsList().setModel(listModel);
			}
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
			album.setIsLoved(false);
			if (listModel.contains(album)) {
				listModel.removeElement(album);
				contentPane.getLovedAlbumsPanel().getLovedAlbumsList().setModel(listModel);
			}
		}
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
