package com.israeldago.idBanking.backend.domain.entities;

import com.israeldago.idBanking.backend.common.helpers.AppSerializer;
import lombok.*;
import javax.persistence.*;
import java.time.*;
import java.util.Collection;

@Entity
@Table(name = "USERS")
@Data @ToString(exclude = "rolesCollection")
@Builder
public class UserDB implements java.io.Serializable {
    private static final long serialVersionUID = AppSerializer.serialVersionUID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
    @Column(name = "IDENTITY_CARD_NUMBER")
    private String identityCardNumber;
    private String username;
    private String password;
    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;
    @OneToMany(mappedBy = "user")
    private Collection<RoleDB> rolesCollection;
}
