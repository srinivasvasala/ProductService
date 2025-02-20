package com.srinivas.productservice.Security;

import com.srinivas.productservice.DTOs.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class JWTObject {
    private String email;
    private Long userId;
    private Date expiryAt;
    private Date createdAt;
    private List<Role> roles;
}
