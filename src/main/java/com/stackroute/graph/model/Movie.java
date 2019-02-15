package com.stackroute.graph.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
public class Movie {
    @Id
    private int released;
    private String title;
    @JsonIgnoreProperties
    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    private List<Role> rolesheacted = new ArrayList<>();
}
