package com.customer.customerManagement.controller;

import com.customer.customerManagement.model.AuthDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.customer.customerManagement.service.LoginService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthDetails loginDetails){

         return (loginService.validateUser(loginDetails.getLoginId(), loginDetails.getPassword()));

    }
}
