package by.itstep.homework.view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import by.itstep.homework.model.Database;

public class ContentPane extends JPanel {

	public Database database;
	public MainButtonsPanel mainButtonsPanel;
	public AllAlbumsPanel allAlbumsPanel;
	public LovedAlbumsPanel lovedAlbumsPanel;
	public AlbumInfoPanel albumInfoPanel;
	public AddAlbumPanel addAlbumPanel;

	private static final long serialVersionUID = 3125527054862962247L;

	public ContentPane() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		database = new Database();
		this.build();
	}

	public void build() {
		buildMainButtonPanel();
		buildAllAlbumsPanel();
		buildLovedAlbumsPanel();
		buildAlbumInfoPanel();
		buildAddAlbumPanel();
	}

	public AllAlbumsPanel getAllAlbumsPanel() {
		return allAlbumsPanel;
	}

	public LovedAlbumsPanel getLovedAlbumsPanel() {
		return lovedAlbumsPanel;
	}

	public AlbumInfoPanel getAlbumInfoPanel() {
		return albumInfoPanel;
	}

	public AddAlbumPanel getAddAlbumPanel() {
		return addAlbumPanel;
	}

	public Database getDatabase() {
		return database;
	}

	private void buildAddAlbumPanel() {
		addAlbumPanel = new AddAlbumPanel(this);
		this.add(addAlbumPanel);
	}

	private void buildAlbumInfoPanel() {
		albumInfoPanel = new AlbumInfoPanel(this);
		this.add(albumInfoPanel);
	}

	private void buildLovedAlbumsPanel() {
		lovedAlbumsPanel = new LovedAlbumsPanel(this);
		this.add(lovedAlbumsPanel);
	}

	private void buildAllAlbumsPanel() {
		allAlbumsPanel = new AllAlbumsPanel(this);
		this.add(allAlbumsPanel);
	}

	private void buildMainButtonPanel() {
		mainButtonsPanel = new MainButtonsPanel(this);
		this.add(mainButtonsPanel);
	}

	public MainButtonsPanel getMainButtonsPanel() {
		return mainButtonsPanel;
	}

}
