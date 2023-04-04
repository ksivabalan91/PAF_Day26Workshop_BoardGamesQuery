package paf.week2.day26workshopboardgames.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import paf.week2.day26workshopboardgames.Utils;
import paf.week2.day26workshopboardgames.Models.Game;
import paf.week2.day26workshopboardgames.Repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepo;

    public JsonObject getGames(int limit, int offset) {

        List<Game> gameArr = gameRepo.getGames(limit, offset);
        JsonArray jsonGameArr = Utils.toJsonArray(gameArr);
        int gameCount = gameRepo.getTotalGames();        
        LocalDateTime timenow = LocalDateTime.now();
        
        JsonObject jsonObject = Json.createObjectBuilder()
            .add("games", jsonGameArr)
            .add("offset", offset)
            .add("limit", limit)
            .add("total", gameCount)
            .add("timestamp", timenow.toString())
            .build();

        return jsonObject;       

    }
    
}
