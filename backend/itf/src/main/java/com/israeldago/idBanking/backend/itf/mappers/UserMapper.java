package com.israeldago.idBanking.backend.itf.mappers;

import com.israeldago.idBanking.backend.domain.entities.UserDB;
import com.israeldago.idBanking.backend.itf.dtos.UserDTO;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO mapToDTO(@NonNull UserDB userDB){
        return UserDTO.builder()
                .id(userDB.getId())
                .firstName(userDB.getFirstName())
                .lastName(userDB.getLastName())
                .dateOfBirth(userDB.getDateOfBirth())
                .identityCardNumber(userDB.getIdentityCardNumber())
                .username(userDB.getUsername())
                .password(userDB.getPassword())
                .registrationDate(userDB.getRegistrationDate())
                .build();
    }

    public UserDB mapToDB(@NonNull UserDTO userDTO){
        return UserDB.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .dateOfBirth(userDTO.getDateOfBirth())
                .identityCardNumber(userDTO.getIdentityCardNumber())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .registrationDate(userDTO.getRegistrationDate())
                .build();
    }
}
