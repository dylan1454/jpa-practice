package com.example.jpapractice.service;


import com.example.jpapractice.dao.PersonRepository;
import com.example.jpapractice.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    public Person findByNameAndAddress(String name, String address) {
        return personRepository.findByNameAndAddress(name, address);
    }

    public Person savePerson(Person p) {
        return personRepository.saveAndFlush(p);
    }

    public List<Person> findAll() {
        return personRepository.findAll(new Sort(Direction.ASC, "id"));
    }

    public Page<Person> page(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public Page<Person> findByAuto(Person person, Pageable pageable) {
        return personRepository.findByAuto(person, pageable);
    }
}
