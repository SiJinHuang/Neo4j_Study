package com.kilo.gram.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String tagline;

    private Long released;

}
