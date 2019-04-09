package com.example.zoo.repositories;

import com.example.zoo.domain.Wolf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WolfRepository extends JpaRepository<Wolf,Long> {
}
