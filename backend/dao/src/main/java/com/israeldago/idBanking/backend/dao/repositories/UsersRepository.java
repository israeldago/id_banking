package com.israeldago.idBanking.backend.dao.repositories;

import com.israeldago.idBanking.backend.domain.entities.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserDB, Integer> {
    UserDB findByUsername(String username);
}
