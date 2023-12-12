package com.adeo.postgreCrud.repositories;

import com.adeo.postgreCrud.models.Foucom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoucomRepository extends JpaRepository<Foucom, Long> {
}
