package com.stackroute.graph.repository;

import com.stackroute.graph.model.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface PersonRepository extends Neo4jRepository<Person, Integer> {
    Long deleteByName(String name);

//    Long getAllPersons();

    @Query("MATCH (p:Person) -[:ACTED_IN]-(m:Movie) RETURN p")
    Collection<Person> getAllPersons();


//    MATCH (a:Actor)-[:ACTS_IN]->(m:Movie)
//
//    RETURN a, count(*)
//
//    ORDER BY count(*) DESC LIMIT 10;


//    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(u:Person) RETURN m")
}
