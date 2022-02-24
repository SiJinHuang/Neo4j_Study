package com.kilo.gram;

import com.kilo.gram.dao.PersonDao;
import com.kilo.gram.dao.RelationShipDao;
import com.kilo.gram.dao.DiseaseDao;
import com.kilo.gram.pojo.Person;
import com.kilo.gram.pojo.RelationShip;
import com.kilo.gram.pojo.Disease;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DpApplicationTests {

    @Autowired
    PersonDao personDao;

    @Autowired
    RelationShipDao relationShipDao;

    @Autowired
    DiseaseDao diseaseDao;

    @Test
    void contextLoads() {
//        Optional<Person> byId = personDao.findById(23L);
//        System.out.println(byId);
//        byId.orElse(null);

//        Person testOne = new Person("TestOne", "2020");
//        personDao.save(testOne);
//        Person testTwo = new Person("TestTwo", "2022");
//        personDao.save(testTwo);
        Person tO = personDao.findByName("TestOne");
        Person tT = personDao.findByName("TestTwo");

        RelationShip relationShip = new RelationShip();
        relationShip.setParent(tO);
        relationShip.setChild(tT);
        relationShip.setRelation("测试关系创建");
        relationShipDao.save(relationShip);

    }


    @Test
    public void Test_() {
        relationShipDao.createRelation("TestOne", "REL", "TestTwo");
    }

    @Test
    public void Test__() {
//        Disease test = diseaseDao.findByName("铆钉损失");
//        System.out.println(test);
        diseaseDao.createRelationWithDisease("梁体位移", "梁给铆", "铆钉损失");
    }

}
