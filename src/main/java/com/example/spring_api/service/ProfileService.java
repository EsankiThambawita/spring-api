package com.example.spring_api.service;

import com.example.spring_api.model.Profile;
import com.example.spring_api.model.User;
import com.example.spring_api.repository.ProfileRepository;
import com.example.spring_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public Profile createOrUpdateProfile(Long userId, Profile profileData) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Profile> existingProfileOpt = profileRepository.findByUserId(userId);

        Profile profileToSave;

        if (existingProfileOpt.isPresent()) {
            // Update existing profile
            profileToSave = existingProfileOpt.get();
            profileToSave.setFullName(profileData.getFullName());
            profileToSave.setAddress(profileData.getAddress());
            profileToSave.setPhone(profileData.getPhone());
        } else {
            // Create new profile
            profileToSave = profileData;
            profileToSave.setUser(user);
        }

        return profileRepository.save(profileToSave);
    }


    public Profile getProfileByUserId(Long userId) {
        return profileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }
}
