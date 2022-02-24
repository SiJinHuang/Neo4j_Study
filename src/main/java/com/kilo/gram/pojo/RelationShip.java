package com.kilo.gram.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity
@NoArgsConstructor
public class RelationShip {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Person parent;

    @EndNode
    private Person child;

    @Property
    private String relation;



}
