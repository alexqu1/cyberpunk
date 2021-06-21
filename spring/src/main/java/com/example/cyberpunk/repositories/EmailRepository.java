package com.example.cyberpunk.repositories;

import com.example.cyberpunk.entities.Email;
import com.example.cyberpunk.entities.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmailRepository extends JpaRepository<Email, Long > {
}
