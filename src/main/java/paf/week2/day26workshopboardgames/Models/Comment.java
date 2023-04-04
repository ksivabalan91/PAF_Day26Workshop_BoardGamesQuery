package paf.week2.day26workshopboardgames.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private String _id;
    private String c_id;
    private String user;
    private Float rating;
    private String c_text;
    private Float gid;    
}
