package k2019.Playlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	
	//unique, primary key value
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	//other attributes
	@NotNull
	@Size(min=2, max=30)
	private String name, artist, album;
	
	@NotNull
	@Size(min=3, max=5)
	private String length;
	
	@NotNull
	@Min(1900)
	private int year;
	
	//
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="styleid")
	private Style style;
	
	public Song() {}
	
	public Song(String name, String artist, String album, String length, int year, Style style) {
		super();
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.length = length;
		this.year = year;
		this.style = style;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@Override
	public String toString() {
		if (this.style != null)
			return "Playlist [id=" + id + ", name=" + name + ", artist=" + artist + ", album=" + album + ", length="
					+ length + ", year=" + year + " style =" + this.getStyle() + "]";
		else
			return "Playlist [id=" + id + ", name=" + name + ", artist=" + artist + ", album=" + album + ", length="
				+ length + ", year=" + year + "]";
	}
}
