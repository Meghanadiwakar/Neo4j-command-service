package com.stackroute.graph.model;

import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type = "ACTED_IN")
@Data
public class Role {
    @Id
    private int roleId;
    private List<String> roles = new ArrayList<>();
    @StartNode
    private Person person;
    @EndNode
    private Movie movie;
}
