package com.finalproj.finalproject.service;

import com.finalproj.finalproject.model.UserRole;
import org.springframework.http.ResponseEntity;

public interface UserRoleServiceMethods {

    ResponseEntity saveNewUserRole (UserRole userRole) throws Exception;

    ResponseEntity getAllUserRoles ();
}
