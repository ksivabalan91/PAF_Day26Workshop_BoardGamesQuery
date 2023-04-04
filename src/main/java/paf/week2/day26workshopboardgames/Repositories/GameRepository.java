package paf.week2.day26workshopboardgames.Repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import paf.week2.day26workshopboardgames.Models.Game;

@Repository
public class GameRepository {

    @Autowired
    private MongoTemplate template;

    public Document findOneDoc(){
        return template.findOne(new Query(), Document.class,"games");
    }
    public Game findOneGame(){
        return template.findOne(new Query(), Game.class,"games");
    }
    /* db.games.aggregate([
        {$project:{gid:1,name:1, _id:0}},
        {$skip:5},
        {$limit:5}])
    */
    public List<Game> getGames(int limit, int offset) {

        //! operations
        ProjectionOperation dataFilter = Aggregation.project("gid","name").andExclude("_id");
        SkipOperation skip = Aggregation.skip(offset);
        LimitOperation limitby = Aggregation.limit(limit);

        //! build pipeline
        Aggregation pipeline = Aggregation.newAggregation(dataFilter, skip, limitby);

        //! execute query
        AggregationResults<Game> results = template.aggregate(pipeline, "games", Game.class);

        return results.getMappedResults();
    }
    public List<Game> getGamesSortByRank(int limit, int offset) {

        //! operations
        SkipOperation skip = Aggregation.skip(offset);
        LimitOperation limitby = Aggregation.limit(limit);
        SortOperation sortby = Aggregation.sort(Direction.ASC, "ranking");
        ProjectionOperation dataFilter = Aggregation.project("gid","name").andExclude("_id");

        //! build pipeline
        Aggregation pipeline = Aggregation.newAggregation(skip, limitby, sortby,dataFilter);

        //! execute query
        AggregationResults<Game> results = template.aggregate(pipeline, "games", Game.class);

        return results.getMappedResults();
    }
    public int getTotalGames() {
        int count = (int)template.count(new Query(), "games");
        return count;
    }
    
}
