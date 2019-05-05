package by.itstep.homework.model;

import javax.swing.Icon;

public class Album {

	private String name; // Название альбома
	private Artist artist; // Исполнитель альбома
	private Genre genre; // Жанр
	private Icon albumCover; // Обложка
	private Boolean isLoved = false; // Избранный или нет

	public Album(String name) {
		this.name = name;
	}

	public Album(String name, Artist artist, Genre genre, Icon albumCover) {
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.albumCover = albumCover;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Icon getAlbumCover() {
		return albumCover;
	}

	public void setAlbumCover(Icon albumCover) {
		this.albumCover = albumCover;
	}

	public Boolean getIsLoved() {
		return isLoved;
	}

	public void setIsLoved(Boolean isLoved) {
		this.isLoved = isLoved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albumCover == null) ? 0 : albumCover.hashCode());
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((isLoved == null) ? 0 : isLoved.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (albumCover == null) {
			if (other.albumCover != null)
				return false;
		} else if (!albumCover.equals(other.albumCover))
			return false;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (isLoved == null) {
			if (other.isLoved != null)
				return false;
		} else if (!isLoved.equals(other.isLoved))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return artist.getName() + " - " + name;
	}

}
