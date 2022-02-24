package com.kilo.gram.dao;

import com.kilo.gram.pojo.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends Neo4jRepository<Person,Long> {
    Person findByName(String name);
}
