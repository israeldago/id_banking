package com.israeldago.idBanking.dao.repositories;

import com.israeldago.idBanking.domain.entities.RoleDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RoleDB, Integer> {}
