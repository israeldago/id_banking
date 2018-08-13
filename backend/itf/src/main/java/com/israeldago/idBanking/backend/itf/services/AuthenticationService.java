package com.israeldago.idBanking.backend.itf.services;

import com.israeldago.idBanking.backend.itf.dtos.UserDTO;

public interface AuthenticationService {
    UserDTO getUserBy(String username);
    UserDTO authenticateBy(String username, String password);
}
