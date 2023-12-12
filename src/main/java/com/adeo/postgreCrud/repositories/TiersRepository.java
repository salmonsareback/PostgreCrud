package com.adeo.postgreCrud.repositories;

import com.adeo.postgreCrud.models.Tiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiersRepository extends JpaRepository<Tiers, Long> {
}
