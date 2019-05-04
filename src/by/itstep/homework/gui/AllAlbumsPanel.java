package by.itstep.homework.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListDataListener;

import by.itstep.homework.listener.allalbums.ListItemSelectListener;
import by.itstep.homework.model.Album;

// Панель отображения всех альбомов
public class AllAlbumsPanel extends Panel {

	public final JList<Album> allAlbumsList = new JList<>(); // Список всех альбомов

	private static final long serialVersionUID = -7935133261706085345L;

	public AllAlbumsPanel(ContentPane contentPane) {
		this();
		this.contentPane = contentPane;
		this.build();
	}

	public AllAlbumsPanel() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setBounds(10, 108, 600, 301);
		this.setLayout(new BorderLayout(0, 0));
		this.setVisible(false);
	}

	@Override
	public void showPanel(Boolean flag) {
		this.setVisible(flag);
	}

	@Override
	public void build() {
		JScrollPane scrollPane = new JScrollPane();
		this.add(scrollPane, BorderLayout.CENTER);

		allAlbumsList.setFont(new Font("Arial Black", Font.PLAIN, 14));
		DefaultListModel<Album> listModel = new DefaultListModel<>();
		for (int i = 0; i < contentPane.getDatabase().getAlbumList().length; i++) {
			listModel.addElement(contentPane.getDatabase().getAllAlbums()[i]);
		}
		allAlbumsList.setModel(listModel);
		ListItemSelectListener listItemSelectListener = new ListItemSelectListener(this);
		listItemSelectListener.setContentPane(contentPane);
		allAlbumsList.addListSelectionListener(listItemSelectListener);

		scrollPane.setViewportView(allAlbumsList);
	}

	public JList<Album> getAllAlbumslist() {
		return allAlbumsList;
	}

}
