package by.itstep.homework.view;

import java.awt.Color;

import javax.swing.border.LineBorder;

// Панель для отображения информации альбома и поиска альбома
public class AlbumInfoPanel extends Panel {

	private SearchAlbumPanel searchAlbumPanel; // Панель поиска альбома
	private InfoPanel infoPanel; // Панель информации альбома

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
		buildSearchAlbumPanel();
		buildInfoPanel();
	}

	public SearchAlbumPanel getSearchAlbumPanel() {
		return searchAlbumPanel;
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}

	public void setSearchAlbumPanel(SearchAlbumPanel searchAlbumPanel) {
		this.searchAlbumPanel = searchAlbumPanel;
	}

	public void setInfoPanel(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	private void buildSearchAlbumPanel() {
		searchAlbumPanel = new SearchAlbumPanel(this);
		this.add(searchAlbumPanel);
	}

	private void buildInfoPanel() {
		infoPanel = new InfoPanel(this);
		this.add(infoPanel);
	}

}
