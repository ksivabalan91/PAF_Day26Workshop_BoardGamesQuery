package paf.week2.day26workshopboardgames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import paf.week2.day26workshopboardgames.Repositories.GameRepository;

@SpringBootApplication
public class Day26WorkshopBoardgamesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Day26WorkshopBoardgamesApplication.class, args);
	}

	@Autowired
	GameRepository gameRepo;

	@Bean
	public CommonsRequestLoggingFilter log(){
	CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
	logger.setIncludeClientInfo(true);
	logger.setIncludeQueryString(true);
	return logger;
}
	@Override
	public void run(String... args) throws Exception {
		System.out.println(">>> DOCUMENT:\n"+gameRepo.findOneDoc().toJson());
		System.out.println(">>> DOC to JSON_OBJ:\n"+Utils.docToJsonObject(gameRepo.findOneDoc()).toString());
		System.out.println(">>> MODEL:\n"+gameRepo.findOneGame().toString());
	}

}
