package com.kilo.gram.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "桥梁病害")
@Data
@NoArgsConstructor
public class Disease {


    @Id
    @GeneratedValue
    private Long id;
    @Property
    private String name;
    @Property
    private String label;

}
