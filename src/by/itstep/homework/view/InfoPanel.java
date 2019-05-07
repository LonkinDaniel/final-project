package by.itstep.homework.view;

import java.awt.Color;
import java.awt.Font;

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

	private JLabel albumCoverLabel; // Обложка альбома
	private JLabel artistNameLabel; // Название группы или имя исполнителя
	private JTextPane albumNameTextPane; // Название альбома
	private JLabel genreLabel; // Жанр
	private JRadioButton isLovedAlbumRadioButton; // Переключатель добавления в избранные
	private JComboBox<Album> albumsComboBox; // Список для выбора отображения альбома
	private JSeparator separator;
	private DefaultComboBoxModel<Album> comboBoxModel;
	private AlbumInfoPanel albumInfoPanel;
	private static final long serialVersionUID = 4508696292131641074L;

	public InfoPanel(AlbumInfoPanel albumInfoPanel) {
		this();
		this.contentPane = albumInfoPanel.contentPane;
		this.setAlbumInfoPanel(albumInfoPanel);
		this.build();
	}

	public InfoPanel() {
		this.setLayout(null);
		this.setBounds(2, 66, 597, 231);
	}

	@Override
	public void build() {
		buildAlbumCoverLabel();
		buildArtistNameLabel();
		buildAlbumNameTextPane();
		buildSeparator();
		buildGenreLabel();
		buildIsLovedAlbumRadioButton();
		buildAlbumsComboBox();
		showAlbumInfo(false);
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

	public void setAlbumCoverLabel(JLabel albumCoverLabel) {
		this.albumCoverLabel = albumCoverLabel;
	}

	public JLabel getArtistNameLabel() {
		return artistNameLabel;
	}

	public void setArtistNameLabel(JLabel artistNameLabel) {
		this.artistNameLabel = artistNameLabel;
	}

	public JTextPane getAlbumNameTextPane() {
		return albumNameTextPane;
	}

	public void setAlbumNameTextPane(JTextPane albumNameTextPane) {
		this.albumNameTextPane = albumNameTextPane;
	}

	public JLabel getGenreLabel() {
		return genreLabel;
	}

	public void setGenreLabel(JLabel genreLabel) {
		this.genreLabel = genreLabel;
	}

	public JRadioButton getIsLovedAlbumRadioButton() {
		return isLovedAlbumRadioButton;
	}

	public void setIsLovedAlbumRadioButton(JRadioButton isLovedAlbumRadioButton) {
		this.isLovedAlbumRadioButton = isLovedAlbumRadioButton;
	}

	public JComboBox<Album> getAlbumsComboBox() {
		return albumsComboBox;
	}

	public void setAlbumsComboBox(JComboBox<Album> albumsComboBox) {
		this.albumsComboBox = albumsComboBox;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public void setSeparator(JSeparator separator) {
		this.separator = separator;
	}

	public DefaultComboBoxModel<Album> getComboBoxModel() {
		return comboBoxModel;
	}

	public void setComboBoxModel(DefaultComboBoxModel<Album> comboBoxModel) {
		this.comboBoxModel = comboBoxModel;
	}

	public AlbumInfoPanel getAlbumInfoPanel() {
		return albumInfoPanel;
	}

	public void setAlbumInfoPanel(AlbumInfoPanel albumInfoPanel) {
		this.albumInfoPanel = albumInfoPanel;
	}

	private void buildAlbumCoverLabel() {
		albumCoverLabel = new JLabel();
		albumCoverLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		albumCoverLabel.setBounds(10, 49, 150, 150);
		this.add(albumCoverLabel);
	}

	private void buildArtistNameLabel() {
		artistNameLabel = new JLabel();
		artistNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		artistNameLabel.setBounds(170, 137, 406, 14);
		this.add(artistNameLabel);
	}

	private void buildAlbumNameTextPane() {
		albumNameTextPane = new JTextPane();
		albumNameTextPane.setFont(new Font("Arial Black", Font.BOLD, 18));
		albumNameTextPane.setBounds(170, 49, 416, 67);
		albumNameTextPane.setEditable(false);
		this.add(albumNameTextPane);
	}

	private void buildSeparator() {
		separator = new JSeparator();
		separator.setBounds(170, 127, 416, 2);
		this.add(separator);
	}

	private void buildGenreLabel() {
		genreLabel = new JLabel("Жанр: ");
		genreLabel.setFont(new Font("Arial", Font.BOLD, 14));
		genreLabel.setBounds(170, 174, 406, 14);
		this.add(genreLabel);
	}

	private void buildIsLovedAlbumRadioButton() {
		isLovedAlbumRadioButton = new JRadioButton("Избранный");

		isLovedAlbumRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		isLovedAlbumRadioButton.setForeground(Color.RED);
		isLovedAlbumRadioButton.setFont(new Font("Arial Black", Font.BOLD, 13));
		isLovedAlbumRadioButton.setBounds(10, 206, 154, 23);

		AlbumLovedRadioButtonSelectedListener albumLovedRadioButtonSelectedListener = new AlbumLovedRadioButtonSelectedListener(
				this);
		albumLovedRadioButtonSelectedListener.setContentPane(contentPane);
		isLovedAlbumRadioButton.addItemListener(albumLovedRadioButtonSelectedListener);

		this.add(isLovedAlbumRadioButton);
	}

	private void buildAlbumsComboBox() {
		albumsComboBox = new JComboBox<>();
		albumsComboBox.setToolTipText("Список альбомов");
		albumsComboBox.setBounds(10, 11, 576, 27);
		albumsComboBox.setSelectedItem(null);

		comboBoxModel = new DefaultComboBoxModel<>();

		AlbumSelectedComboBoxItemListener albumSelectedComboBoxItemListener = new AlbumSelectedComboBoxItemListener(
				this);
		albumSelectedComboBoxItemListener.setContentPane(contentPane);
		albumsComboBox.addItemListener(albumSelectedComboBoxItemListener);

		this.add(albumsComboBox);
	}

}
