package com.stackroute.graph.repository;

import com.stackroute.graph.model.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie, Integer> {
}
