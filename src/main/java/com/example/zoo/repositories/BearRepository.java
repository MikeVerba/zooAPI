package com.example.zoo.repositories;

import com.example.zoo.domain.Bear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BearRepository extends JpaRepository<Bear,Long> {
}
