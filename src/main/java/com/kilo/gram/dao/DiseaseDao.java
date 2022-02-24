package com.kilo.gram.dao;

import com.kilo.gram.pojo.Disease;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DiseaseDao extends Neo4jRepository<Disease, Long> {

    @Query("match (n:桥梁病害 {name:{0}}), (m:桥梁病害 {name:{2}}) create (n)-[:病害层级关系{relation:{1}}]->(m)")
    void createRelationWithDisease(String from, String relation, String to);

    Disease findByName(String name);

}
