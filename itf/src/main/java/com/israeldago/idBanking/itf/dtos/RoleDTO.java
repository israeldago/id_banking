package com.israeldago.idBanking.itf.dtos;

import com.israeldago.idBanking.common.enums.ApplicationRole;
import lombok.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Value
public class RoleDTO implements java.io.Serializable{
    private int id;
    private ApplicationRole applicationRole;
    private UserDTO user;
}
