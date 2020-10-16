package k2019.Playlist.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k2019.Playlist.domain.Song;
import k2019.Playlist.domain.SongRepository;
import k2019.Playlist.domain.StyleRepository;

// Define as Controller class
@Controller
public class SongController {
	
	//Use existing repositories
	@Autowired
	private SongRepository repository;
	
	@Autowired
	private StyleRepository srepository;
	
	//Login
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	// Make a list of all the songs in the playlist
	@GetMapping("/playlist")
	public String playlist(Model model) {
		model.addAttribute("songs", repository.findAll());
		return "playlist";
	}
	
	// Add a new song to playlist
	@GetMapping("/add")
	public String addSong(Model model) {
		model.addAttribute("song", new Song());
		model.addAttribute("styles", srepository.findAll());
		return "addsong";
	}
	
	//Save the added song to playlist with validation
	@PostMapping("/save")
	public String save (@Valid Song song, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("styles", srepository.findAll());
            return "addsong";
        }
		repository.save(song);
		return "redirect:playlist";
	}
	
	//Edit song in the playlist
	@GetMapping("/edit/{id}")
	public String editSong(@PathVariable("id") Long songId, Model model) {
		model.addAttribute("song", repository.findById(songId));
		model.addAttribute("styles", srepository.findAll());
		return "editsong";
	}
	
	//Save the edited song to playlist, with validation
	@PostMapping("/saveedited")
	public String saveedited (@Valid Song song, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("styles", srepository.findAll());
            return "editsong";
        }
		repository.save(song);
		return "redirect:playlist";
	}
	
	//Delete song from playlist, read id from path variable
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long songId, Model model){
			repository.deleteById(songId);
			return "redirect:../playlist";
	}
}
