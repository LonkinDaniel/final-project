package by.itstep.homework.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import by.itstep.homework.listener.albuminfo.SearchAlbumButtonClickListener;

// Панель для поиска альбома
public class SearchAlbumPanel extends Panel {

	private static final long serialVersionUID = 9169568092643049313L;
	private AlbumInfoPanel albumInfoPanel;
	private JTextField albumNameSearchTextField; // Поле для ввода названия альбома

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
		buildAlbumNameSearchLabel();
		buildAlbumNameSearchTextField();
		buildSearchAlbumButton();
	}

	public boolean isSearchFieldEmpty() {
		return albumNameSearchTextField.getText().isEmpty();
	}

	private void buildAlbumNameSearchLabel() {
		JLabel albumNameSearchLabel = new JLabel("Название альбома:");
		albumNameSearchLabel.setFont(new Font("Arial", Font.BOLD, 12));
		albumNameSearchLabel.setBounds(10, 11, 113, 22);
		this.add(albumNameSearchLabel);
	}

	private void buildAlbumNameSearchTextField() {
		albumNameSearchTextField = new JTextField();
		albumNameSearchTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		albumNameSearchTextField.setBounds(127, 13, 344, 20);
		albumNameSearchTextField.setColumns(10);
		this.add(albumNameSearchTextField);
	}

	private void buildSearchAlbumButton() {
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

	public JTextField getAlbumNameSearchTextField() {
		return albumNameSearchTextField;
	}

	public void setAlbumNameSearchTextField(JTextField albumNameSearchTextField) {
		this.albumNameSearchTextField = albumNameSearchTextField;
	}

}
