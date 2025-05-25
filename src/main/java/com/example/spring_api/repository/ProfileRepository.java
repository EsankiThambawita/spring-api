package com.example.spring_api.repository;

import com.example.spring_api.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile,Long>{
    Optional<Profile> findByUserId(Long userId);
}
