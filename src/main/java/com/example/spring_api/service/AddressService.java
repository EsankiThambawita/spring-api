package com.example.spring_api.service;

import com.example.spring_api.model.Address;
import com.example.spring_api.model.User;
import com.example.spring_api.repository.AddressRepository;
import com.example.spring_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepo;
    private final UserRepository userRepo;

    public AddressService(AddressRepository a, UserRepository u) {
        this.addressRepo = a;
        this.userRepo = u;
    }

    public List<Address> getAllByUserId(Long userId) {
        return addressRepo.findByUserId(userId);
    }

    public Address create(Long userId, Address address) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        address.setUser(user);
        return addressRepo.save(address);
    }

    public Address update(Long id, Address address) {
        Address existing = addressRepo.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
        existing.setStreet(address.getStreet());
        existing.setCity(address.getCity());
        existing.setState(address.getState());
        existing.setZipCode(address.getZipCode());
        return addressRepo.save(existing);
    }

    public void delete(Long id) {
        addressRepo.deleteById(id);
    }
}

