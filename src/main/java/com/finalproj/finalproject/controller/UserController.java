package com.finalproj.finalproject.controller;

import com.finalproj.finalproject.dto.LoginDTO;
import com.finalproj.finalproject.dto.UserDTO;
import com.finalproj.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/staffUser")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public ResponseEntity testFirst() {
        String name = "I am lakith Muthugala";
        return new ResponseEntity(name, HttpStatus.OK);
    }

    @PostMapping("/addNewUser")
    public ResponseEntity saveNewUser(@RequestBody @Valid UserDTO userDTO, Principal principal) throws Exception {
        return userService.saveNewUser(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody @Valid LoginDTO loginDTO) {
        return userService.userLogin(loginDTO);
    }

    @GetMapping(path = "/activate/{userId}")
    public ResponseEntity activateAuser(@PathVariable @Valid int userId){
        return userService.activateAUser(userId);
    }

    @GetMapping("/active-users")
    public ResponseEntity activeUsers(){
        return userService.getAllActivateUsers();
    }

    @GetMapping("/deactivated-users")
    public ResponseEntity deactivatedUsers(){
        return userService.getAllDeactivateUsers();
    }

    //https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/

}
