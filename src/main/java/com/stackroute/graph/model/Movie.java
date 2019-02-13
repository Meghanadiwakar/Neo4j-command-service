package com.stackroute.graph.model;

import lombok.Data;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
public class Movie {
    @Id
    private int released;
    private String title;
//    @JsonIgnoreProperties
//    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
//    private List<Role> rolesheacted = new ArrayList<>();
}
