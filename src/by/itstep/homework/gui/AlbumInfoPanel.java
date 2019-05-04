package by.itstep.homework.gui;

import java.awt.Color;

import javax.swing.border.LineBorder;

// Панель для отображения информации альбома и поиска альбома
public class AlbumInfoPanel extends Panel {

	public final SearchAlbumPanel searchAlbumPanel = new SearchAlbumPanel(this); // Панель поиска альбома
	public final InfoPanel infoPanel = new InfoPanel(this); // Панель информации альбома

	private static final long serialVersionUID = 6263979991600619523L;

	public AlbumInfoPanel(ContentPane contentPane) {
		this();
		this.contentPane = contentPane;
		this.build();
	}

	public AlbumInfoPanel() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setBounds(10, 108, 600, 301);
		this.setLayout(null);
	}

	@Override
	public void showPanel(Boolean flag) {
		this.setVisible(flag);
	}

	@Override
	public void build() {
		this.add(searchAlbumPanel);
		this.add(infoPanel);
	}

	public SearchAlbumPanel getSearchAlbumPanel() {
		return searchAlbumPanel;
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}

}
