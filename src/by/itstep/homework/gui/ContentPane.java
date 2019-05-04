package by.itstep.homework.gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import by.itstep.homework.model.Database;

public class ContentPane extends JPanel {

	public final MainButtonsPanel mainButtonsPanel = new MainButtonsPanel(this);
	public final AllAlbumsPanel allAlbumsPanel = new AllAlbumsPanel(this);
	public final LovedAlbumsPanel lovedAlbumsPanel = new LovedAlbumsPanel(this);
	public final AlbumInfoPanel albumInfoPanel = new AlbumInfoPanel(this);
	public final AddAlbumPanel addAlbumPanel = new AddAlbumPanel(this);
	public final Database database = new Database();

	private static final long serialVersionUID = 3125527054862962247L;

	public ContentPane() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.build();
	}

	public void build() {
		this.add(mainButtonsPanel);
		this.add(allAlbumsPanel);
		this.add(lovedAlbumsPanel);
		this.add(albumInfoPanel);
		this.add(addAlbumPanel);
	}

	public MainButtonsPanel getMainButtonsPanel() {
		return mainButtonsPanel;
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

}
