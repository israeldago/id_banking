package com.israeldago.idBanking.backend.itf.mappers;

import com.israeldago.idBanking.backend.domain.entities.RoleDB;
import com.israeldago.idBanking.backend.itf.dtos.RoleDTO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    @Autowired
    private UserMapper userMapper;

    public RoleDTO mapToDTO(@NonNull RoleDB roleDB){
        return new RoleDTO(roleDB.getId(),roleDB.getApplicationRole(), userMapper.mapToDTO(roleDB.getUser()));
    }

    public RoleDB mapToDB(@NonNull RoleDTO roleDTO){
        RoleDB roleDB = new RoleDB();
        roleDB.setApplicationRole(roleDTO.getApplicationRole());
        roleDB.setUser(userMapper.mapToDB(roleDTO.getUser()));
        return roleDB;
    }
}
