package by.itstep.homework.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import by.itstep.homework.listener.addalbum.AddAlbumButtonClickListener;
import by.itstep.homework.listener.addalbum.AlbumCoverClickListener;

// Панель добавления альбомов
public class AddAlbumPanel extends Panel {

	private JLabel albumCoverAddAlbumLabel; // Обложка альбома
	private JTextField artistNameAddAlbumTextField; // Поле для ввода имени исполнителя или группы
	private JTextField albumNameAddAlbumTextField; // Поле для ввода названия альбома
	private JTextField genreAddAlbumTextField; // Поле для ввода названия жанра
	private CoverAlbumChooserDialog coverAlbumChooserDialog;
	private static final long serialVersionUID = 4224154358328433604L;

	public AddAlbumPanel(ContentPane contentPane) {
		this();
		this.contentPane = contentPane;
		this.build();
	}

	public AddAlbumPanel() {
		this.setVisible(false);
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		this.setBounds(10, 108, 600, 301);
		this.setLayout(null);
	}

	@Override
	public void build() {

		buildInstructionsLabel();
		buildAlbumCoverLabel();
		buildArtistNameLabel();
		buildArtistNameTextField();
		buildAlbumNameLabel();
		buildAlbumNameTextField();
		buildGenreLabel();
		buildGenreTextField();
		buildAddButton();

		coverAlbumChooserDialog = new CoverAlbumChooserDialog(this);
	}

	@Override
	public void showPanel(Boolean flag) {
		this.setVisible(flag);
	}

	public boolean areFieldsEmpty() {
		if (albumNameAddAlbumTextField.getText().isEmpty()) {
			return true;
		} else if (artistNameAddAlbumTextField.getText().isEmpty()) {
			return true;
		} else if (genreAddAlbumTextField.getText().isEmpty()) {
			return true;
		} else if (albumCoverAddAlbumLabel.getIcon() == null) {
			return true;
		}
		return false;
	}

	public CoverAlbumChooserDialog getCoverAlbumChooserDialog() {
		return coverAlbumChooserDialog;
	}

	public void setCoverAlbumChooserDialog(CoverAlbumChooserDialog coverAlbumChooserDialog) {
		this.coverAlbumChooserDialog = coverAlbumChooserDialog;
	}

	public JLabel getAlbumCoverAddAlbumLabel() {
		return albumCoverAddAlbumLabel;
	}

	public JTextField getArtistNameAddAlbumTextField() {
		return artistNameAddAlbumTextField;
	}

	public JTextField getAlbumNameAddAlbumTextField() {
		return albumNameAddAlbumTextField;
	}

	public JTextField getGenreAddAlbumTextField() {
		return genreAddAlbumTextField;
	}

	public void setAlbumCoverAddAlbumLabel(JLabel albumCoverAddAlbumLabel) {
		this.albumCoverAddAlbumLabel = albumCoverAddAlbumLabel;
	}

	public void setArtistNameAddAlbumTextField(JTextField artistNameAddAlbumTextField) {
		this.artistNameAddAlbumTextField = artistNameAddAlbumTextField;
	}

	public void setAlbumNameAddAlbumTextField(JTextField albumNameAddAlbumTextField) {
		this.albumNameAddAlbumTextField = albumNameAddAlbumTextField;
	}

	public void setGenreAddAlbumTextField(JTextField genreAddAlbumTextField) {
		this.genreAddAlbumTextField = genreAddAlbumTextField;
	}

	private void buildAlbumCoverLabel() {
		albumCoverAddAlbumLabel = new JLabel("Кликайте здесь для выбора обложки альбома");
		albumCoverAddAlbumLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		albumCoverAddAlbumLabel.setBounds(20, 44, 150, 150);
		albumCoverAddAlbumLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AlbumCoverClickListener albumCoverClickListener = new AlbumCoverClickListener(this);
		albumCoverClickListener.setContentPane(contentPane);
		albumCoverAddAlbumLabel.addMouseListener(albumCoverClickListener);
		this.add(albumCoverAddAlbumLabel);
	}

	private void buildArtistNameLabel() {
		JLabel artistNameAddAlbumLabel = new JLabel("Группа:");
		artistNameAddAlbumLabel.setFont(new Font("Arial", Font.BOLD, 12));
		artistNameAddAlbumLabel.setBounds(180, 64, 57, 14);
		this.add(artistNameAddAlbumLabel);
	}

	private void buildArtistNameTextField() {
		artistNameAddAlbumTextField = new JTextField();
		artistNameAddAlbumTextField.setBounds(247, 60, 286, 20);
		artistNameAddAlbumTextField.setColumns(10);
		this.add(artistNameAddAlbumTextField);
	}

	private void buildAlbumNameLabel() {
		JLabel albumNameAddAlbumLabel = new JLabel("Альбом:");
		albumNameAddAlbumLabel.setFont(new Font("Arial", Font.BOLD, 12));
		albumNameAddAlbumLabel.setBounds(180, 142, 57, 14);
		this.add(albumNameAddAlbumLabel);
	}

	private void buildAlbumNameTextField() {
		albumNameAddAlbumTextField = new JTextField();
		albumNameAddAlbumTextField.setColumns(10);
		albumNameAddAlbumTextField.setBounds(247, 140, 286, 20);
		this.add(albumNameAddAlbumTextField);
	}

	private void buildGenreLabel() {
		JLabel genreAddAlbumLabel = new JLabel("Жанр:");
		genreAddAlbumLabel.setFont(new Font("Arial", Font.BOLD, 12));
		genreAddAlbumLabel.setBounds(180, 220, 57, 14);
		this.add(genreAddAlbumLabel);
	}

	private void buildInstructionsLabel() {
		JLabel instructionsAddAlbumLabel = new JLabel("Заполните все поля и нажмите кнопку \"Добавить\":");
		instructionsAddAlbumLabel.setFont(new Font("Arial", Font.BOLD, 13));
		instructionsAddAlbumLabel.setBounds(10, 11, 349, 22);
		this.add(instructionsAddAlbumLabel);
	}

	private void buildAddButton() {
		JButton addButton = new JButton("Добавить");
		addButton.setBounds(20, 244, 122, 46);
		AddAlbumButtonClickListener addAlbumButtonClickListener = new AddAlbumButtonClickListener(this);
		addAlbumButtonClickListener.setContentPane(contentPane);
		addButton.addActionListener(addAlbumButtonClickListener);
		this.add(addButton);
	}

	private void buildGenreTextField() {
		genreAddAlbumTextField = new JTextField();
		genreAddAlbumTextField.setColumns(10);
		genreAddAlbumTextField.setBounds(247, 220, 286, 20);
		this.add(genreAddAlbumTextField);
	}

}
