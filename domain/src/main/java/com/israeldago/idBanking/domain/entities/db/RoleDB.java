package com.israeldago.idBanking.domain.entities.db;

import com.israeldago.idBanking.domain.enums.ApplicationRole;
import lombok.Data;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ROLES")
@XmlRootElement
@Data
public class RoleDB implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Integer id;
    @Column(name = "ROLE_NAME")
    private ApplicationRole applicationRole;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private UserDB user;
}
