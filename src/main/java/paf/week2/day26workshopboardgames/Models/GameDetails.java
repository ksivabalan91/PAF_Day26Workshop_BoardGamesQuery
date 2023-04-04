package paf.week2.day26workshopboardgames.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDetails {
    private float gid;
    private String name;
    private float year;
    private float ranking;
    private float average;
    private float users_rated;
    private String url;
    private String thumbnail;
    private String timestamp;
    
}
