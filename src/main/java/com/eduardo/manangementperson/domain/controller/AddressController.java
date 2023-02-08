package com.eduardo.manangementperson.domain.controller;

import com.eduardo.manangementperson.domain.dto.AddressDTO;
import com.eduardo.manangementperson.domain.entity.Address;
import com.eduardo.manangementperson.domain.entity.Person;
import com.eduardo.manangementperson.domain.repository.AddressRepository;
import com.eduardo.manangementperson.domain.repository.PersonRepository;
import com.eduardo.manangementperson.domain.service.impl.AddressServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/address")
public class AddressController {


    @Autowired
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressServiceImpl addressService;

    public AddressController(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Address> findById(final @PathVariable("id") Integer id) {
        return addressService.findById(id);
    }

    @GetMapping("/person/{personId}")
    public List<AddressDTO> getAddressesByPerson(@PathVariable Integer personId) {
        Optional<Person> person = personRepository.findById(personId);
        List<Address> addresses = addressRepository.findByPerson(person);
        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        address = addressRepository.save(address);
        return modelMapper.map(address, AddressDTO.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable("id") Integer id, @RequestBody Address address) {
        return ResponseEntity.ok(addressService.updateAddress(id, address));
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressRepository.deleteById(id);
    }

}
