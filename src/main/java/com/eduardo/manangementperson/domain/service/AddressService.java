package com.eduardo.manangementperson.domain.service;

import com.eduardo.manangementperson.domain.entity.Address;

import java.util.Optional;

public interface AddressService {
    Optional<Address> findById(Integer id);
}