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
    private Integer id;
    @Column(name = "APP_ROLE")
    @Enumerated(EnumType.STRING)
    private ApplicationRole applicationRole;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UserDB user;
}
