package com.kilo.gram.controller;

import com.kilo.gram.pojo.CustomLink;
import com.kilo.gram.pojo.CustomNode;
import com.kilo.gram.pojo.Movie;
import com.kilo.gram.pojo.Person;
import com.kilo.gram.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/{name}")
    public CustomNode findByName(@PathVariable("name") String name){
//        return personService.findByName(name);
        Person person = personService.findByName(name);
        return new CustomNode(person.getName(),1, person);
    }

    //  查询所拍摄的电影
    @GetMapping("/queryRelationship/{name}")
    public List<CustomNode> getActedByName(@PathVariable("name") String name){
        Person person = personService.findByName(name);
        List<CustomNode> customNodes = new ArrayList<>();
        Set<Movie> movieSet = personService.getMoviesByRelationship(person);

        for(Movie movie : movieSet){
            customNodes.add(new CustomNode(movie.getTitle(),2, movie));
            //customLinks.add(new CustomLink(person.getName(),movie.getTitle(),5));
        }
        return customNodes;
    }

    @GetMapping("/link/{name}")
    public List<CustomLink> getAct(@PathVariable("name") String name){
        Person person = personService.findByName(name);
        List<CustomLink> customLinks = new ArrayList<>();
        Set<Movie> movieSet = personService.getMoviesByRelationship(person);

        for(Movie movie : movieSet){
//            customNodes.add(new CustomNode(movie.getTitle(),2, movie));
            customLinks.add(new CustomLink(person.getName(),movie.getTitle(),5));
        }
        return customLinks;
    }
//
    @GetMapping("/all")
    public List<CustomNode> findAll(){
        Iterable<Person> personIterable = personService.findAll();
        List<CustomNode> customNodes = new ArrayList<>();
        for(Person person : personIterable){
            customNodes.add(new CustomNode(person.getName(),1, person));
        }
        return customNodes;
    }

}
