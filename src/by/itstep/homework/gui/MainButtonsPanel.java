package by.itstep.homework.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import by.itstep.homework.listener.mainbuttons.ShowAddAlbumPanelButtonClickListener;
import by.itstep.homework.listener.mainbuttons.ShowAllAlbumsButtonClickListener;
import by.itstep.homework.listener.mainbuttons.ShowLovedAlbumsButtonClickListener;

// Панель кнопок перехода по панелям
public class MainButtonsPanel extends Panel {

	public final JButton showAllAlbumsButton = new JButton("Показать все альбомы");
	public final JButton showLovedAlbumsButton = new JButton("Избранные");
	public final JButton addAlbumButton = new JButton("Добавить альбом");

	private static final long serialVersionUID = 5603888107555761996L;

	public MainButtonsPanel() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setBounds(10, 11, 600, 86);
		this.setLayout(null);
	}

	public MainButtonsPanel(ContentPane contentPane) {
		this();
		this.contentPane = contentPane;
		this.build();
	}

	@Override
	public void build() {
		showAllAlbumsButton.setBounds(31, 11, 158, 64);
		ShowAllAlbumsButtonClickListener showAllAlbumsButtonClickListener = new ShowAllAlbumsButtonClickListener(this);
		showAllAlbumsButtonClickListener.setContentPane(contentPane);
		showAllAlbumsButton.addActionListener(showAllAlbumsButtonClickListener);
		this.add(showAllAlbumsButton);

		showLovedAlbumsButton.setBounds(220, 11, 158, 64);
		ShowLovedAlbumsButtonClickListener showLovedAlbumsButtonClickListener = new ShowLovedAlbumsButtonClickListener(
				this);
		showLovedAlbumsButtonClickListener.setContentPane(contentPane);
		showLovedAlbumsButton.addActionListener(showLovedAlbumsButtonClickListener);
		this.add(showLovedAlbumsButton);

		addAlbumButton.setBounds(409, 11, 158, 64);
		ShowAddAlbumPanelButtonClickListener showAddAlbumPanelButtonClickListener = new ShowAddAlbumPanelButtonClickListener(
				this);
		showAddAlbumPanelButtonClickListener.setContentPane(contentPane);
		addAlbumButton.addActionListener(showAddAlbumPanelButtonClickListener);
		this.add(addAlbumButton);
	}

	@Override
	public void showPanel(Boolean flag) {

	}
}
