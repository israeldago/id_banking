package com.israeldago.idBanking.itf.mappers;

import com.israeldago.idBanking.domain.entities.UserDB;
import com.israeldago.idBanking.itf.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO mapToDTO(UserDB userDB){
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

    public UserDB mapToDB(UserDTO userDTO){
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
