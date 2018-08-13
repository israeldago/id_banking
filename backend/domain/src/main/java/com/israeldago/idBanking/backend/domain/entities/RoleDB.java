package com.israeldago.idBanking.backend.domain.entities;

import com.israeldago.idBanking.backend.common.enums.ApplicationRole;
import com.israeldago.idBanking.backend.common.helpers.AppSerializer;
import lombok.Data;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ROLES")
@XmlRootElement
@Data
public class RoleDB implements java.io.Serializable {
    private static final long serialVersionUID = AppSerializer.serialVersionUID;

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
