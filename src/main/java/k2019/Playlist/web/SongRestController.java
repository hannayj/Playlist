package k2019.Playlist.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import k2019.Playlist.domain.Song;
import k2019.Playlist.domain.SongRepository;

@RestController
public class SongRestController {
	@Autowired
	private SongRepository repository;
	
	
	// RESTful service to get student by id ("/api/songs" made automatically) 
	@GetMapping("/song/{id}")
	public @ResponseBody Optional<Song> findSongRest(@PathVariable("id") Long SongId){
		return repository.findById(SongId);
	}
	
}
