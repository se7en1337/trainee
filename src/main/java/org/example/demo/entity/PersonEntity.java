package org.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name="firstname",nullable = false)
    @JsonProperty("firstname")
    private String firstname;

    @Column(name="surname",nullable = false)
    @JsonProperty("surname")
    private String surname;

    @Column(name="dateofbirthday",nullable = false)
    @JsonProperty("dateOfBirthday")
    private LocalDate dateOfBirthday;
}
