package com.eduardo.manangementperson.domain.service.impl;

import com.eduardo.manangementperson.domain.entity.Address;
import com.eduardo.manangementperson.domain.repository.AddressRepository;
import com.eduardo.manangementperson.domain.service.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Transactional
    public Address updateAddress(Integer id, Address updatedAddress) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
        if(updatedAddress.getStreet() != null){
            address.setStreet(updatedAddress.getStreet());
        }
        if(updatedAddress.getZipCode() != null){
            address.setZipCode(updatedAddress.getZipCode());
        }
        if(updatedAddress.getNumberAddress() != null){
            address.setNumberAddress(updatedAddress.getNumberAddress());
        }
        if(updatedAddress.getCity() != null){
            address.setCity(updatedAddress.getCity());
        }
        if(updatedAddress.getStateAddress() != null){
            address.setStateAddress(updatedAddress.getStateAddress());
        }
        if(updatedAddress.getPerson() != null){
            address.setPerson(updatedAddress.getPerson());
        }
        address.setPrincipal(updatedAddress.isPrincipal());
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return addressRepository.findById(id);
    }


}