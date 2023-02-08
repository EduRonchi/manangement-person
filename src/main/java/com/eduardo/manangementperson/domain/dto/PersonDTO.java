package com.eduardo.manangementperson.domain.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {
    private Integer id;
    private String personName;
    private LocalDate bornDate;
    private Integer addressPrincipalId;
}