package com.israeldago.idBanking.backend.itf.dtos;

import com.israeldago.idBanking.backend.common.helpers.AppSerializer;
import lombok.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.*;
import java.util.Set;

@XmlRootElement
@Value @ToString(exclude = "rolesList")
@Builder
public class UserDTO implements java.io.Serializable{
    private static final long serialVersionUID = AppSerializer.serialVersionUID;

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String identityCardNumber;
    private String username;
    private String password;
    private LocalDateTime registrationDate;
    private Set<RoleDTO> rolesList;
}
