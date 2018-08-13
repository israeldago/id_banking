package com.israeldago.idBanking.backend.itf.dtos;

import com.israeldago.idBanking.backend.common.enums.ApplicationRole;
import com.israeldago.idBanking.backend.common.helpers.AppSerializer;
import lombok.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Value
public class RoleDTO implements java.io.Serializable{
    private static final long serialVersionUID = AppSerializer.serialVersionUID;

    private int id;
    private ApplicationRole applicationRole;
    private UserDTO user;
}
