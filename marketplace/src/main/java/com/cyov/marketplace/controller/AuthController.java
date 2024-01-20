package com.cyov.marketplace.controller;

import com.cyov.marketplace.model.dto.LoginResponseDTO;
import com.cyov.marketplace.model.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/auth")
public class AuthController {
    @Autowired

    @PostMapping("/login")
    public ResponseEntity<Response<LoginResponseDTO>> login() {
        return ResponseEntity.ok(new Response<LoginResponseDTO>(Response.SUCCESS, "Login successful", new LoginResponseDTO()));
    }
    @PostMapping("/register")
    public String register() {
        return "register";
    }
}
