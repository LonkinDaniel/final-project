package by.itstep.homework.gui;

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

	public final JLabel albumCoverAddAlbumLabel = new JLabel("Кликайте здесь для выбора обложки альбома");
	public final JTextField artistNameAddAlbumTextField = new JTextField(); // Поле для ввода имени исполнителя или
																			// группы
	public final JTextField albumNameAddAlbumTextField = new JTextField(); // Поле для ввода названия альбома
	public final JTextField genreAddAlbumTextField = new JTextField(); // Поле для ввода названия жанра

	private CoverAlbumChooserDialog coverAlbumChooserDialog = new CoverAlbumChooserDialog(this);
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
		JLabel instructionsAddAlbumLabel = new JLabel("Заполните все поля и нажмите кнопку \"Добавить\":");
		instructionsAddAlbumLabel.setFont(new Font("Arial", Font.BOLD, 13));
		instructionsAddAlbumLabel.setBounds(10, 11, 349, 22);
		this.add(instructionsAddAlbumLabel);

		albumCoverAddAlbumLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		albumCoverAddAlbumLabel.setBounds(20, 44, 150, 150);
		albumCoverAddAlbumLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AlbumCoverClickListener albumCoverClickListener = new AlbumCoverClickListener(this);
		albumCoverClickListener.setContentPane(contentPane);
		albumCoverAddAlbumLabel.addMouseListener(albumCoverClickListener);
		this.add(albumCoverAddAlbumLabel);

		JLabel artistNameAddAlbumLabel = new JLabel("Группа:");
		artistNameAddAlbumLabel.setFont(new Font("Arial", Font.BOLD, 12));
		artistNameAddAlbumLabel.setBounds(180, 64, 57, 14);
		this.add(artistNameAddAlbumLabel);

		artistNameAddAlbumTextField.setBounds(247, 60, 286, 20);
		artistNameAddAlbumTextField.setColumns(10);
		this.add(artistNameAddAlbumTextField);

		JLabel albumNameAddAlbumLabel = new JLabel("Альбом:");
		albumNameAddAlbumLabel.setFont(new Font("Arial", Font.BOLD, 12));
		albumNameAddAlbumLabel.setBounds(180, 142, 57, 14);
		this.add(albumNameAddAlbumLabel);

		albumNameAddAlbumTextField.setColumns(10);
		albumNameAddAlbumTextField.setBounds(247, 140, 286, 20);
		this.add(albumNameAddAlbumTextField);

		JLabel genreAddAlbumLabel = new JLabel("Жанр:");
		genreAddAlbumLabel.setFont(new Font("Arial", Font.BOLD, 12));
		genreAddAlbumLabel.setBounds(180, 220, 57, 14);
		this.add(genreAddAlbumLabel);

		genreAddAlbumTextField.setColumns(10);
		genreAddAlbumTextField.setBounds(247, 220, 286, 20);
		this.add(genreAddAlbumTextField);

		JButton addButton = new JButton("Добавить");
		addButton.setBounds(20, 244, 122, 46);
		AddAlbumButtonClickListener addAlbumButtonClickListener = new AddAlbumButtonClickListener(this);
		addAlbumButtonClickListener.setContentPane(contentPane);
		addButton.addActionListener(addAlbumButtonClickListener);
		this.add(addButton);
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

}
