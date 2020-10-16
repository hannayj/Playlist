package k2019.Playlist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Style {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long styleid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "style")
	private List<Song> songs;
	
	public Style() {}
	
	public Style(String name) {
		super();
		this.name = name;
	}
	
	public long getStyleid() {
		return styleid;
	}

	public void setStyleid(long styleid) {
		this.styleid = styleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Style [styleid=" + styleid + ", name=" + name + "]";
	}
	
	
}
