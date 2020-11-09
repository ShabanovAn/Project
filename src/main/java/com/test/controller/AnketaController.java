package com.test.controller;

import com.test.entity.*;
import com.test.repository.AnketaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/new")
@AllArgsConstructor
public class AnketaController {
    AnketaRepository anketaRepository;

    @GetMapping("/all")
    List<AnketaDTO> getAllAnketa() {
        return anketaRepository.getAllAnketa();
    }

    @GetMapping("/city/{city}")
    List<Anketa> findAllByCity(@PathVariable String city) {
        return anketaRepository.findAllByCity(city);
   }

    @GetMapping("/id/{id}")
    Anketa findById(@PathVariable int id) {
        return anketaRepository.findById(id);
    }

    @GetMapping("/{serial}/{number}")
    List<Anketa> findBySerialAndNumber(@PathVariable int serial, @PathVariable int number) {
        return anketaRepository.findBySerialAndNumber(serial, number);
    }

    @GetMapping("/key/{city}")
    List<Anketa> findByCity(@PathVariable String city) {
        return anketaRepository.findTop3ByCity(city);
    }

    @GetMapping("/number/{number}")
    List<Anketa> findByNumber(@PathVariable int number) {
        return anketaRepository.findByNumber(number);
    }


    @GetMapping("/city")
    List<AnketaDTOCity> getCity() {
        return anketaRepository.getCity();
    }

    @GetMapping("/group/city")
    List<AnketaDTOCityNumberSum> getCityGroup() {
        return anketaRepository.groupCity();
    }

    @GetMapping("/join")
    Object[] joinPerson() {
        return anketaRepository.joinPerson();
    }

    @GetMapping("/seach/number/{number}")
    List<AnketaDTOListCount> numberCity(@PathVariable int number) {
        return anketaRepository.numberCity(number);
    }


}
