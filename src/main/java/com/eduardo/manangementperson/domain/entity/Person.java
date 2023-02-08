package com.eduardo.manangementperson.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "born_date")
    @Temporal(TemporalType.DATE)
    private LocalDate bornDate;

    @Column(name = "address_principal_id")
    private Integer addressPrincipalId;

}