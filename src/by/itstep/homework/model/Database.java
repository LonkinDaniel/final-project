package by.itstep.homework.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.itstep.homework.exceptions.AlbumExistsException;

public class Database {

	public final List<Artist> artists = new ArrayList<>(); // Список исполнителей или групп
	public final List<Album> albums = new ArrayList<>(); // Список альбомов
	public final Set<Album> lovedAlbums = new HashSet<>(); // Список избранных альбомов
	public final Set<Genre> genres = new HashSet<>(); // Список жанров

	// Добавление альбома
	public void addAlbum(Album album) throws AlbumExistsException {
		if (isAlbumAdded(album.getName()) & isArtistAdded(album.getArtist().getName())) {
			throw new AlbumExistsException();
		} else {
			this.albums.add(album);
		}
	}

	// Добавление исполнителя
	public void addArtist(Artist artist) {
		if (!isArtistAdded(artist.getName())) {
			artists.add(artist);
		}
	}

	// Добавление жанра
	public void addGenre(Genre genre) {
		genres.add(genre);
	}

	// Проверка на наличие альбома
	public boolean isAlbumAdded(String albumName) {
		return albums.stream().anyMatch(album -> album.getName().equalsIgnoreCase(albumName));
	}

	// Проверка на наличие исполнителя
	private boolean isArtistAdded(String artistName) {
		return artists.stream().anyMatch(artist -> artist.getName().equalsIgnoreCase(artistName));
	}

	// Проверка на наличие избранного альбома
	private boolean isLovedAlbumAdded(String albumName) {
		return lovedAlbums.stream().anyMatch(album -> album.getName().equals(albumName));
	}

	// Получить альбом по имени
	public Album getAlbumByName(String albumName) {
		return (Album) albums.stream().map(album -> album.getName().equalsIgnoreCase(albumName));
	}

	// Получить все альбомы
	public Album[] getAllAlbums() {
		return albums.toArray(new Album[albums.size()]);
	}

	// Получить все избранные альбомы
	public Album[] getAllLovedAlbums() {
		return lovedAlbums.toArray(new Album[lovedAlbums.size()]);
	}

	// Добавить в избранные
	public void addToLovedAlbums(Album album) throws AlbumExistsException {
		if (isLovedAlbumAdded(album.getName())) {
			throw new AlbumExistsException();
		} else {
			this.lovedAlbums.add(album);
		}
	}

	public String[] getAlbumList() {
		String[] albums = new String[this.albums.size()];
		for (int i = 0; i < this.albums.size(); i++) {
			albums[i] = String.format("%s", getAllAlbums()[i].getName());
		}
		return albums;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public Set<Album> getLovedAlbums() {
		return lovedAlbums;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albums == null) ? 0 : albums.hashCode());
		result = prime * result + ((artists == null) ? 0 : artists.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((lovedAlbums == null) ? 0 : lovedAlbums.hashCode());
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
		Database other = (Database) obj;
		if (albums == null) {
			if (other.albums != null)
				return false;
		} else if (!albums.equals(other.albums))
			return false;
		if (artists == null) {
			if (other.artists != null)
				return false;
		} else if (!artists.equals(other.artists))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (lovedAlbums == null) {
			if (other.lovedAlbums != null)
				return false;
		} else if (!lovedAlbums.equals(other.lovedAlbums))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Database [artists=" + artists + ", albums=" + albums + ", lovedAlbums=" + lovedAlbums + ", genres="
				+ genres + "]";
	}

}
