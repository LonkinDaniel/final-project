package by.itstep.homework.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import by.itstep.homework.listener.albuminfo.AlbumLovedRadioButtonSelectedListener;
import by.itstep.homework.listener.albuminfo.AlbumSelectedComboBoxItemListener;
import by.itstep.homework.model.Album;

// Панель информации альбома
public class InfoPanel extends Panel {

	public final JLabel albumCoverLabel = new JLabel(""); // Обложка альбома
	public final JLabel artistNameLabel = new JLabel("artist/band"); // Название группы или имя исполнителя
	public final JTextPane albumNameTextPane = new JTextPane(); // Название альбома
	public final JLabel genreLabel = new JLabel("Жанр: "); // Жанр
	public final JRadioButton isLovedAlbumRadioButton = new JRadioButton("Избранный"); // Переключатель добавления в
																						// избранные
	public final JComboBox<Album> albumsComboBox = new JComboBox<>(); // Список для выбора отображения альбома
	public final JSeparator separator = new JSeparator();
	public final DefaultComboBoxModel<Album> comboBoxModel = new DefaultComboBoxModel<>(contentPane.getDatabase().getAllAlbums());

	private AlbumInfoPanel albumInfoPanel;
	private static final long serialVersionUID = 4508696292131641074L;

	public InfoPanel(AlbumInfoPanel albumInfoPanel) {
		this();
		this.setAlbumInfoPanel(albumInfoPanel);
		this.build();
	}

	public InfoPanel() {
		this.setLayout(null);
		this.setBounds(2, 66, 597, 231);
	}

	@Override
	public void build() {
		albumCoverLabel.setVisible(false);
		albumCoverLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		albumCoverLabel.setBounds(10, 49, 150, 150);

		this.add(albumCoverLabel);

		artistNameLabel.setVisible(false);
		artistNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		artistNameLabel.setBounds(170, 137, 406, 14);

		this.add(artistNameLabel);

		albumNameTextPane.setVisible(false);
		albumNameTextPane.setText("album name");
		albumNameTextPane.setFont(new Font("Arial Black", Font.BOLD, 18));
		albumNameTextPane.setBackground(SystemColor.menu);
		albumNameTextPane.setBounds(170, 49, 416, 67);

		this.add(albumNameTextPane);

		separator.setVisible(false);
		separator.setBounds(170, 127, 416, 2);
		this.add(separator);

		genreLabel.setVisible(false);
		genreLabel.setFont(new Font("Arial", Font.BOLD, 14));
		genreLabel.setBounds(170, 174, 406, 14);

		this.add(genreLabel);

		isLovedAlbumRadioButton.setVisible(false);
		isLovedAlbumRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		isLovedAlbumRadioButton.setForeground(Color.RED);
		isLovedAlbumRadioButton.setFont(new Font("Arial Black", Font.BOLD, 13));
		isLovedAlbumRadioButton.setBounds(10, 206, 154, 23);
		AlbumLovedRadioButtonSelectedListener albumLovedRadioButtonSelectedListener = new AlbumLovedRadioButtonSelectedListener(
				this);
		albumLovedRadioButtonSelectedListener.setContentPane(contentPane);
		isLovedAlbumRadioButton.addItemListener(albumLovedRadioButtonSelectedListener);
		this.add(isLovedAlbumRadioButton);

		albumsComboBox.setToolTipText("Список альбомов");
		albumsComboBox.setBounds(10, 11, 576, 27);
		if (!contentPane.getDatabase().getAlbums().isEmpty()) {
			albumsComboBox.setModel(comboBoxModel);
		}
		AlbumSelectedComboBoxItemListener albumSelectedComboBoxItemListener = new AlbumSelectedComboBoxItemListener(
				this);
		albumSelectedComboBoxItemListener.setContentPane(contentPane);
		albumsComboBox.addItemListener(albumSelectedComboBoxItemListener);
		this.add(albumsComboBox);
	}

	public void showAlbumInfo(Boolean flag) {
		albumCoverLabel.setVisible(flag);
		artistNameLabel.setVisible(flag);
		albumNameTextPane.setVisible(flag);
		separator.setVisible(flag);
		genreLabel.setVisible(flag);
		isLovedAlbumRadioButton.setVisible(flag);
	}

	@Override
	public void showPanel(Boolean flag) {

	}

	public Album getSelectedAlbum() {
		return (Album) albumsComboBox.getSelectedItem();
	}

	public JLabel getAlbumCoverLabel() {
		return albumCoverLabel;
	}

	public JLabel getArtistNameLabel() {
		return artistNameLabel;
	}

	public JTextPane getAlbumNameTextPane() {
		return albumNameTextPane;
	}

	public JLabel getGenreLabel() {
		return genreLabel;
	}

	public JRadioButton getIsLovedAlbumRadioButton() {
		return isLovedAlbumRadioButton;
	}

	public JComboBox<Album> getAlbumsComboBox() {
		return albumsComboBox;
	}

	public AlbumInfoPanel getAlbumInfoPanel() {
		return albumInfoPanel;
	}

	public void setAlbumInfoPanel(AlbumInfoPanel albumInfoPanel) {
		this.albumInfoPanel = albumInfoPanel;
	}

}
