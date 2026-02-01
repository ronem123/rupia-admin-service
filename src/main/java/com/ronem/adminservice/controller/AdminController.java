package com.ronem.adminservice.controller;

import com.ronem.adminservice.model.request.client.CreateUserRequest;
import com.ronem.adminservice.model.response.CreateUserResponse;
import com.ronem.adminservice.service.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {
    private final AdminServiceImpl adminService;

    @GetMapping(value = "/greet")
    ResponseEntity<HashMap<String, String>> greet() {
        HashMap<String, String> body = new HashMap<>();
        body.put("Status", "success");
        body.put("Message", "Welcome to microservice");
        return new ResponseEntity<>(body, HttpStatus.OK);
    }


    @PostMapping("")
    ResponseEntity<CreateUserResponse> createAdmin(CreateUserRequest request) {
        CreateUserResponse createUserResponse = adminService.createAdmin(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse);
    }
}
