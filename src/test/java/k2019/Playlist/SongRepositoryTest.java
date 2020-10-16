package k2019.Playlist;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import k2019.Playlist.domain.Song;
import k2019.Playlist.domain.SongRepository;
import k2019.Playlist.domain.Style;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SongRepositoryTest {
	
	@Autowired
	private SongRepository repository;
	
		
	@Test
	public void addNewSong () {
		Song song = new Song ("The Outside", "Taylor Swift", "Taylor Swift", "3:27", 2006, new Style("Country"));
		repository.save(song);
		assertThat(song.getId()).isNotNull();
		
	}

}
