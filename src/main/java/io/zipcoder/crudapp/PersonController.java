package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person/")
    public  ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personService.create(p), HttpStatus.CREATED);
    }
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id){
        return new ResponseEntity<>(personService.show(id),HttpStatus.OK);
    }
    @GetMapping("/people/")
    public ResponseEntity<Iterable<Person>> getPersonList() {
        return new ResponseEntity<>(personService.readAll(), HttpStatus.OK);
    }
    @PutMapping("/person/{person_id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer person_id, @RequestBody Person p) {
       return new ResponseEntity<>(personService.update(person_id,p),HttpStatus.OK);
    }
    @DeleteMapping("/person/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Integer id) {
        return new ResponseEntity<>(personService.delete(id), HttpStatus.NOT_FOUND);
    }


}
