package com.eduardo.manangementperson.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {
    private Integer id;
    private String street;
    private String zipCode;
    private Integer numberAddress;
    private String city;
    private String stateAddress;
    private boolean principal;
    private Integer personId;
}
