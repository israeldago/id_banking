package com.israeldago.idBanking.itf.services;

import com.israeldago.idBanking.itf.dtos.UserDTO;

public interface AuthenticationService {
    UserDTO getUserBy(String username);
    UserDTO authenticateBy(String username, String password);
}
