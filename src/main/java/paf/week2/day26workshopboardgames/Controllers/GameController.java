package paf.week2.day26workshopboardgames.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonObject;
import paf.week2.day26workshopboardgames.Services.GameService;

@RestController
public class GameController {

    @Autowired
    private GameService gameSvc;

    @GetMapping(path="/games")
    public ResponseEntity<String> gameDetails(@RequestParam(name="limit", required = false) Integer inputLimit, @RequestParam(name="offset", required = false) Integer inputOffset){
        
        int offset = inputOffset != null ? inputOffset : 0;
        int limit = inputLimit != null ? inputLimit : 25;
        System.out.println("offset:"+offset+" , limit:"+limit);
        JsonObject gameObj= gameSvc.getGames(limit, offset);
        
        return ResponseEntity.ok().body(gameObj.toString());
    }
    @GetMapping(path="/games/rank")
    public ResponseEntity<String> gameDetailsByRank(@RequestParam(name="limit", required = false) Integer inputLimit, @RequestParam(name="offset", required = false) Integer inputOffset){
        
        int offset = inputOffset != null ? inputOffset : 0;
        int limit = inputLimit != null ? inputLimit : 25;
        System.out.println("offset:"+offset+" , limit:"+limit);
        JsonObject gameObj= gameSvc.getGamesByRank(limit, offset);
        
        return ResponseEntity.ok().body(gameObj.toString());
    }
    
}
