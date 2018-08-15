package com.israeldago.idBanking.backend.itf.services;

import com.israeldago.idBanking.backend.common.enums.ApplicationRole;
import com.israeldago.idBanking.backend.itf.dtos.UserDTO;
import java.util.Set;

public interface AuthenticationService {
    UserDTO getUserBy(String username);
    UserDTO authenticateBy(String username, String password);
    Set<ApplicationRole> getUserRoles(String username);
}
