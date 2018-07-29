package com.israeldago.idBanking.dao.repositories;

import com.israeldago.idBanking.domain.entities.db.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserDB, Integer> {}
