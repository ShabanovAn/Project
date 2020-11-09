package com.test.controller;

import com.test.entity.*;
import com.test.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
   private PersonRepository personRepository;

    @GetMapping
    List<Person> findAll() {
        return personRepository.findAllByName("Ivan");
    }

    @GetMapping("/sql")
    List<IPersonDTOAddressAge> findAllSQL() {
        return personRepository.findAddressAgeByNameSQL("Ivan");
    }

    @GetMapping("/jpql")
    List<PersonDTOAddressAge> findAllJPQL() {
        return personRepository.findAddressAgeByNameJPQL("Ivan");
    }

    @GetMapping("/avg")
    List<DTOPersonAddressAvgAge> avgAge() {
        return personRepository.dtoAddressAvg();
    }

    @GetMapping("/age")
    List<DTOPersonAvgSQL> addressAvg() {
        return personRepository.addressAvg();
    }

    @GetMapping("/join")
    List<IPersonAnketaDTONameAddressCity> iPersonAnketaDTONameAddressCity() {
        return personRepository.iPersonAnketaDTONameAddressCity();
    }

    @GetMapping("dto")
    List<PersonAnketaDTONameAddress> personAnketaDTONameAddress() {
        return personRepository.personAnketaDTONameAddress();
    }
}
