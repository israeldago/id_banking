package com.israeldago.idBanking.itf.dtos;

import lombok.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.*;

@XmlRootElement
@Value
@Builder
public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String identityCardNumber;
    private String username;
    private String password;
    private LocalDateTime registrationDate;
}
