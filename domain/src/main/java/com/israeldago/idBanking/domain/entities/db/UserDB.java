package com.israeldago.idBanking.domain.entities.db;

import lombok.*;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.*;
import java.util.Collection;

@Entity
@Table(name = "USERS")
@XmlRootElement
@Data
@Builder
@NoArgsConstructor
public class UserDB implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
    @Column(name = "IDENTITY_CARD_NUMBER")
    private String identityCardNumber;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;
    @OneToMany(mappedBy = "user")
    private Collection<RoleDB> rolesCollection;
}
