package com.israeldago.idBanking.business.services;

import com.israeldago.idBanking.common.enums.ErrorCode;
import com.israeldago.idBanking.common.exceptions.BusinessException;
import com.israeldago.idBanking.dao.repositories.UsersRepository;
import com.israeldago.idBanking.domain.entities.UserDB;
import com.israeldago.idBanking.itf.dtos.UserDTO;
import com.israeldago.idBanking.itf.mappers.UserMapper;
import com.israeldago.idBanking.itf.services.AuthenticationService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;

public class AuthenticationServiceImpl  implements AuthenticationService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserMapper userMapper;
    @Value("${users.api}")
    private String usersApi;

    @Override
    public UserDTO getUserBy(@NonNull String username) {
        UserDB userDB = usersRepository.findByUsername(username);
        if (userDB != null){
            return userMapper.mapToDTO(userDB);
        }
        UserDTO userDTO = restTemplate.getForEntity(usersApi + username, UserDTO.class).getBody();
        usersRepository.saveAndFlush(userMapper.mapToDB(userDTO));
        return userDTO;
    }

    @Override
    public UserDTO authenticateBy(@NonNull String username, @NonNull String password) {
        return Optional.ofNullable(getUserBy(username))
                .filter(userDTO -> Objects.equals(userDTO.getPassword(), password))
                .orElseThrow(() -> new BusinessException(ErrorCode.BAD_CREDENTIALS,"Wrong username or password"));
    }
}
