package by.itstep.homework.listener.albuminfo;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import by.itstep.homework.gui.ContentPane;
import by.itstep.homework.gui.InfoPanel;

public class AlbumLovedRadioButtonSelectedListener implements ItemListener {

	private InfoPanel infoPanel;
	private ContentPane contentPane;

	public AlbumLovedRadioButtonSelectedListener(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			infoPanel.getSelectedAlbum().setIsLoved(true);
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
			infoPanel.getSelectedAlbum().setIsLoved(false);
		}
	}

	public ContentPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(ContentPane contentPane) {
		this.contentPane = contentPane;
	}

}
