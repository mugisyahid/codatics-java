package com.codatics.projectionDTO;

import org.springframework.data.rest.core.config.Projection;

import com.codatics.dto.accountservices.User;

@Projection(name = "UserDTO", types = User.class)
public interface UserDTO {

}
