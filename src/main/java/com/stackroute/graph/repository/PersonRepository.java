package com.stackroute.graph.repository;

import com.stackroute.graph.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, Integer> {
}
