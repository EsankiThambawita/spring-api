package com.example.spring_api.controller;

import com.example.spring_api.model.Profile;
import com.example.spring_api.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // Create new profile
    @PostMapping("/{userId}")
    public ResponseEntity<Profile> createProfile(@PathVariable Long userId, @Valid @RequestBody Profile profile) {
        Profile savedProfile = profileService.createOrUpdateProfile(userId, profile); // Still safe
        return ResponseEntity.ok(savedProfile);
    }

    // Update existing profile
    @PutMapping("/{userId}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long userId, @Valid @RequestBody Profile profile) {
        Profile updatedProfile = profileService.createOrUpdateProfile(userId, profile); // Same method
        return ResponseEntity.ok(updatedProfile);
    }

    // Get profile by user ID
    @GetMapping("/{userId}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long userId) {
        Profile profile = profileService.getProfileByUserId(userId);
        return ResponseEntity.ok(profile);
    }
}
