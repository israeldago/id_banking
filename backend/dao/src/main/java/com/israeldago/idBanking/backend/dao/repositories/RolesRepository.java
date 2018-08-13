package com.israeldago.idBanking.backend.dao.repositories;

import com.israeldago.idBanking.backend.domain.entities.RoleDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RoleDB, Integer> {}
