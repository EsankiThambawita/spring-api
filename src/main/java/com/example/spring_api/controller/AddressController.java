package com.example.spring_api.controller;

import com.example.spring_api.model.Address;
import com.example.spring_api.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService service) {
        this.addressService = service;
    }

    @GetMapping("/users/{userId}/addresses")
    public List<Address> getAll(@PathVariable Long userId) {
        return addressService.getAllByUserId(userId);
    }

    @PostMapping("/users/{userId}/addresses")
    public Address create(@PathVariable Long userId, @RequestBody Address address) {
        return addressService.create(userId, address);
    }

    @PutMapping("/addresses/{id}")
    public Address update(@PathVariable Long id, @RequestBody Address address) {
        return addressService.update(id, address);
    }

    @DeleteMapping("/addresses/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}

