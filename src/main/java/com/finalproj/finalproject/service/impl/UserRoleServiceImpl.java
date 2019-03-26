package com.finalproj.finalproject.service.impl;

import com.finalproj.finalproject.model.ResponseModel;
import com.finalproj.finalproject.model.UserRole;
import com.finalproj.finalproject.repository.UserRoleRepository;
import com.finalproj.finalproject.service.UserRoleServiceMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleServiceMethods {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public ResponseEntity saveNewUserRole (UserRole userRole) throws Exception {
        try{
            userRoleRepository.save(userRole);
            userRole.setRoleType(userRole.getRoleType().toUpperCase());
            return new ResponseEntity(new ResponseModel("User Role Added Successfully",true), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public ResponseEntity getAllUserRoles () {
        try{
            List<UserRole> userRoles = userRoleRepository.findAll();
            return new ResponseEntity(userRoles,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(new ResponseModel("Something went wrong", false),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
