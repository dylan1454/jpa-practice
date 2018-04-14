package com.example.jpapractice.controller;

import com.example.jpapractice.entity.Person;
import com.example.jpapractice.service.PersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/jpa/save")
    public Person save(
            /*@RequestParam(name = "name", required = false) */String name,
            /*@RequestParam(name = "age", required = false)*/ Integer age,
            /*@RequestParam(name = "address", required = false)*/ String address) {
        Person p = personService.savePerson(new Person(null, name, age, address));
        return p;
        //return ResponseEntity.ok().body(p);
    }

    @GetMapping("/jpa/q")
    public List<Person> queryByName(String name) {
        List<Person> p = personService.findByName(name);
        return Optional.ofNullable(p).orElse(null);
    }

    @GetMapping("/jpa/q1")
    public Person queryByNameAndAddress(String name, String address) {
        Person p = personService.findByNameAndAddress(name, address);
        return Optional.ofNullable(p).orElse(null);
    }

    @GetMapping("/jpa/sort")
    public List<Person> sort() {
        List<Person> p = personService.findAll();
        return Optional.ofNullable(p).orElse(null);
    }

    @GetMapping("/jpa/page")
    public Page<Person> page(Pageable pageable) {
        Page<Person> p = personService.page(pageable);
        return Optional.ofNullable(p).orElse(null);
    }

    @RequestMapping("/auto")
    public Page<Person> auto(Person person, Pageable pageable) {
        return personService.findByAuto(person, pageable);
    }
}
