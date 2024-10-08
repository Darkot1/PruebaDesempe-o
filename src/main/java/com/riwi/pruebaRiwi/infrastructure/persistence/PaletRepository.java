package com.riwi.pruebaRiwi.infrastructure.persistence;

import com.riwi.pruebaRiwi.domain.model.Palet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaletRepository extends JpaRepository<Palet,Long> {
}
