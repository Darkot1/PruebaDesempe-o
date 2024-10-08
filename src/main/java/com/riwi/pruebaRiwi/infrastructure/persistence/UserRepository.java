package com.riwi.pruebaRiwi.infrastructure.persistence;

import com.riwi.pruebaRiwi.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByNameOrEmail(String username, String email);

}
