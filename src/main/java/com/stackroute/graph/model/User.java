package com.stackroute.graph.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private int userId;
    private String userName;
    private int reputation;
//    @Relationship(type = "ASKED", direction= Relationship.INCOMING)
//    private List<Question> questions;

}
