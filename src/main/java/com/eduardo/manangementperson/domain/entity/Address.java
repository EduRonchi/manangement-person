package com.eduardo.manangementperson.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "number_address")
    private Integer numberAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state_address")
    private String stateAddress;

    @Column(name = "principal")
    private boolean principal;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}


