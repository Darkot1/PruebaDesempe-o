package com.riwi.pruebaRiwi.infrastructure.persistence;

import com.riwi.pruebaRiwi.domain.model.LoadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadEntityRepository extends JpaRepository<LoadEntity,Long> {
}
