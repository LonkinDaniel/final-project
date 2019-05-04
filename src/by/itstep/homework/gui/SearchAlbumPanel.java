package by.itstep.homework.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import by.itstep.homework.listener.albuminfo.SearchAlbumButtonClickListener;

// Панель для поиска альбома
public class SearchAlbumPanel extends Panel {

	public final JTextField albumNameSearchTextField = new JTextField(); // Поле для ввода названия альбома

	private static final long serialVersionUID = 9169568092643049313L;
	private AlbumInfoPanel albumInfoPanel;

	public SearchAlbumPanel(AlbumInfoPanel albumInfoPanel) {
		this();
		this.albumInfoPanel = albumInfoPanel;
		this.build();
	}

	public SearchAlbumPanel() {
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(10, 11, 580, 44);
		this.setLayout(null);
	}

	@Override
	public void build() {
		JLabel albumNameSearchLabel = new JLabel("Название альбома:");
		albumNameSearchLabel.setFont(new Font("Arial", Font.BOLD, 12));
		albumNameSearchLabel.setBounds(10, 11, 113, 22);
		this.add(albumNameSearchLabel);

		albumNameSearchTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		albumNameSearchTextField.setBounds(127, 13, 344, 20);
		albumNameSearchTextField.setColumns(10);
		this.add(albumNameSearchTextField);

		JButton searchAlbumButton = new JButton("Поиск");
		searchAlbumButton.setBounds(481, 12, 89, 23);
		SearchAlbumButtonClickListener searchAlbumButtonClickListener = new SearchAlbumButtonClickListener(
				albumInfoPanel);
		searchAlbumButtonClickListener.setContentPane(contentPane);
		searchAlbumButton.addActionListener(searchAlbumButtonClickListener);
		this.add(searchAlbumButton);
	}

	@Override
	public void showPanel(Boolean flag) {

	}
}
