package com.example.zoo.repositories;

import com.example.zoo.domain.Tiger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TigerRepository extends JpaRepository<Tiger,Long> {
}
