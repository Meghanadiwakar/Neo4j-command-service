package com.stackroute.graph.repository;

import com.stackroute.graph.model.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface MovieRepository extends Neo4jRepository<Movie, Integer> {
    Long deleteByReleased(int released);


//    Long  getAllMovies();

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(u:Person) RETURN m")
    Collection<Movie> getAllMovies();

}
