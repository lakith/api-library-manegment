package com.finalproj.finalproject.configuration;

import com.finalproj.finalproject.model.UserRole;
import com.finalproj.finalproject.repository.UserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserRoleEventListner {

    @Autowired
    UserRoleRepository userRoleRepository;

    private static final Logger logger =  LoggerFactory.getLogger(UserRoleEventListner.class);

    @EventListener
    public void seed(ContextRefreshedEvent event){
        try {
            saveAllUserRoles();
            logger.info("Event-Listner - Entered To Seed - User Roles");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void saveAllUserRoles(){
        boolean flag = false;
        List<UserRole> userRoleList = userRoleRepository.findAll();
        if(userRoleList.isEmpty()){
            try {
                createUserRoles();
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(userRoleList.size() != 3){
            try {
                createUserRoles();
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(userRoleList.size() == 3){
            for(UserRole role : userRoleList){
                if(role.getRoleId() == 1){
                    if(!role.getRoleType().equals("ADMIN")){
                        if(!flag){
                            try {
                                createUserRoles();
                                flag = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else if(role.getRoleId() == 2){
                    if(!role.getRoleType().equals("LOCAL")){
                        if(!flag){
                            try {
                                createUserRoles();
                                flag = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else if(role.getRoleId() == 3){
                    if(!role.getRoleType().equals("FOREIGN")){
                        if(!flag){
                            try {
                                createUserRoles();
                                flag = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

    }

    private void createUserRoles(){
        UserRole userRole = new UserRole();
        userRole.setRoleType("ADMIN");
        try {
            userRoleRepository.save(userRole);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserRole userRole1 = new UserRole();
        userRole1.setRoleType("LOCAL");
        try {
            userRoleRepository.save(userRole1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserRole userRole2 = new UserRole();
        userRole2.setRoleType("FOREIGN");
        try {
            userRoleRepository.save(userRole2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
