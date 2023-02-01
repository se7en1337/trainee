package org.example.demo.service;

import org.example.demo.dto.PersonDTO;
import org.example.demo.entity.PersonEntity;
import org.example.demo.exception.PersonNotFoundException;
import org.example.demo.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PersonService {
    @Autowired
    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public PersonDTO findPersonById(Long id){
        PersonEntity person = personRepo.findById(id).orElseThrow(()->new PersonNotFoundException());
        LocalDate birthDate = person.getDateOfBirthday();
        LocalDate now = LocalDate.now();
        int age = calculateAge(birthDate,now);

        PersonDTO personDTO = new PersonDTO();
        personDTO.setAge(age);
        personDTO.setId(id);
        personDTO.setFirstname(person.getFirstname());
        personDTO.setSurname(person.getSurname());
        return personDTO;
    }
    public static Integer calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return null;
        }
    }
}
