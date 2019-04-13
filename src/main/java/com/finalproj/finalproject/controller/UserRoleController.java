package com.finalproj.finalproject.controller;

import com.finalproj.finalproject.model.UserRole;
import com.finalproj.finalproject.service.UserRoleServiceMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user-role")
@CrossOrigin
public class UserRoleController {

    @Autowired
    private UserRoleServiceMethods userRoleService;

    @PostMapping
    public ResponseEntity saveUserRole(@RequestBody @Valid UserRole userRole) throws Exception {
       return userRoleService.saveNewUserRole(userRole);
    }

    @GetMapping
    public ResponseEntity getAllUserRoles(){
       return userRoleService.getAllUserRoles();
    }

}
