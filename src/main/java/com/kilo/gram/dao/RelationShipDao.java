package com.kilo.gram.dao;

import com.kilo.gram.pojo.RelationShip;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;


public interface RelationShipDao extends Neo4jRepository<RelationShip, Long> {

    @Query("match (n:Person {name:{0}}), (m:Person {name:{2}}) create (n)-[:关系测试{relation:{1}}]->(m)")
    void createRelation(String from, String relation, String to);



}
