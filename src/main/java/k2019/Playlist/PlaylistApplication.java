package k2019.Playlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k2019.Playlist.domain.User;
import k2019.Playlist.domain.Song;
import k2019.Playlist.domain.SongRepository;
import k2019.Playlist.domain.Style;
import k2019.Playlist.domain.StyleRepository;
import k2019.Playlist.domain.UserRepository;

@SpringBootApplication
public class PlaylistApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistApplication.class, args);
	}

	/**@Bean
	public CommandLineRunner demo(SongRepository repository, StyleRepository srepository, UserRepository urepository) {
		return (args) -> {
			//demo data into database
			srepository.save(new Style("Pop"));
			srepository.save(new Style("Rock"));
			srepository.save(new Style("Heavy"));
			
			repository.save(new Song("Your Song", "Rita Ora", "Your Song", "3:01", 2017, srepository.findByName("Pop").get(0)));
			repository.save(new Song("Trouble", "CLMD", "Trouble", "2:50", 2018, srepository.findByName("Pop").get(0)));
			repository.save(new Song("Anywhere", "Sigma", "Anywhere", "3:25", 2018, srepository.findByName("Pop").get(0)));
			
			//repository.save(s1);
			//repository.save(s2);
			//repository.save(s3);
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}*/
}

