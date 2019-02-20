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
public class Question {

    @Id
    private int QuestionId;
    private String QuestionString;
    private int Timestamp;
    private int upVote;
    private int downVote;

}
