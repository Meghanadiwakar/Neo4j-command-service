package com.stackroute.graph.model;

import lombok.Data;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
public class Person {
    @Id
    private int born;
    private String name;
    @Relationship(type = "ACTED_IN")
    private List<Movie> moviesActedIn = new ArrayList<>();
}
