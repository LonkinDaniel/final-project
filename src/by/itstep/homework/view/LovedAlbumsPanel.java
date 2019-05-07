package by.itstep.homework.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import by.itstep.homework.listener.lovedalbums.ListItemSelectListener;
import by.itstep.homework.model.Album;

// Панель отображения избранных альбомов
public class LovedAlbumsPanel extends Panel {

	private JList<Album> lovedAlbumsList; // Список избранных альбомов
	private JScrollPane scrollPane;
	private static final long serialVersionUID = -7808895581304581562L;

	public LovedAlbumsPanel(ContentPane contentPane) {
		this();
		this.contentPane = contentPane;
		this.build();
	}

	public LovedAlbumsPanel() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setBounds(10, 108, 600, 301);
		this.setLayout(new BorderLayout(0, 0));
		this.setVisible(false);
	}

	public void showPanel(Boolean flag) {
		this.setVisible(flag);
	}

	@Override
	public void build() {
		buildLovedAlbumsList();
		buildScrollPane();
	}

	public JList<Album> getLovedAlbumsList() {
		return lovedAlbumsList;
	}

	public void setLovedAlbumsList(JList<Album> lovedAlbumsList) {
		this.lovedAlbumsList = lovedAlbumsList;
	}

	private void buildLovedAlbumsList() {
		lovedAlbumsList = new JList<>();
		lovedAlbumsList.setFont(new Font("Arial Black", Font.PLAIN, 14));

		createListModel();

		ListItemSelectListener listItemSelectListener = new ListItemSelectListener(this);
		listItemSelectListener.setContentPane(contentPane);
		lovedAlbumsList.addListSelectionListener(listItemSelectListener);
	}

	private void createListModel() {
		DefaultListModel<Album> listModel = new DefaultListModel<>();
		for (int i = 0; i < contentPane.getDatabase().getAlbums().size(); i++) {
			listModel.addElement(contentPane.getDatabase().getAllLovedAlbums()[i]);
		}
		lovedAlbumsList.setModel(listModel);
	}

	private void buildScrollPane() {
		scrollPane = new JScrollPane();
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(lovedAlbumsList);
	}

}
