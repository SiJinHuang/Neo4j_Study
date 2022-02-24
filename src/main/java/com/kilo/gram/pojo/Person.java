package com.kilo.gram.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @Property
    private String name;

    private String born;


    @Relationship(type = "制片人")
    private Set<Movie> actedInMovie = new HashSet<>();

//    @Relationship(type = "PRODUCED", direction = Relationship.OUTGOING)
//    private Set<Movie> producedMovie = new HashSet<>();
//
//    @Relationship(type = "DIRECTED", direction = Relationship.OUTGOING)
//    private Set<Movie> directedMovie = new HashSet<>();
//
//    @Relationship(type = "WROTE", direction = Relationship.OUTGOING)
//    private Set<Movie> wroteMovie = new HashSet<>();
//
//    @Relationship(type = "REVIEWED", direction = Relationship.OUTGOING)
//    private Set<Movie> reviewedMovie = new HashSet<>();





    public Person(String name, String born) {
        this.name = name;
        this.born = born;
    }


}
