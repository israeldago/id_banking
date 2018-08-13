package com.israeldago.idBanking.backend.business.services;

import com.israeldago.idBanking.backend.common.exceptions.BusinessException;
import com.israeldago.idBanking.backend.dao.repositories.UsersRepository;
import com.israeldago.idBanking.backend.domain.entities.UserDB;
import com.israeldago.idBanking.backend.itf.dtos.UserDTO;
import com.israeldago.idBanking.backend.itf.mappers.UserMapper;
import com.israeldago.idBanking.backend.itf.services.AuthenticationService;
import lombok.NonNull;
import org.springframework.web.client.RestTemplate;
import java.util.Objects;
import java.util.Optional;
import static com.israeldago.idBanking.backend.common.enums.ErrorCode.*;

public class AuthenticationServiceImpl  implements AuthenticationService {
    private final UsersRepository USERS_REPOSITORY;
    private final RestTemplate REST_TEMPLATE;
    private final UserMapper USER_MAPPER;
    private final String USERS_API;

    public AuthenticationServiceImpl(@NonNull UsersRepository usersRepository, @NonNull RestTemplate restTemplate,
                                     @NonNull UserMapper userMapper, @NonNull String usersApi) {
        this.USERS_REPOSITORY = usersRepository;
        this.REST_TEMPLATE = restTemplate;
        this.USER_MAPPER = userMapper;
        this.USERS_API = usersApi;
    }

    @Override
    public UserDTO getUserBy(@NonNull String username) {
        UserDB userDB = USERS_REPOSITORY.findByUsername(username);
        if (userDB != null){
            return USER_MAPPER.mapToDTO(userDB);
        }
        UserDTO userDTO = Optional.ofNullable(REST_TEMPLATE.getForEntity(USERS_API + username, UserDTO.class).getBody())
                            .orElseThrow(() -> new BusinessException(USER_NOT_FOUND, "No user found with the given username"));
        USERS_REPOSITORY.saveAndFlush(USER_MAPPER.mapToDB(userDTO));
        return userDTO;
    }

    @Override
    public UserDTO authenticateBy(@NonNull String username, @NonNull String password) {
        return Optional.ofNullable(getUserBy(username))
                .filter(userDTO -> Objects.equals(userDTO.getPassword(), password))
                .orElseThrow(() -> new BusinessException(BAD_CREDENTIALS,"Wrong username or password"));
    }
}
