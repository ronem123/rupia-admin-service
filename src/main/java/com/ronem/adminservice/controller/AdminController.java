package com.ronem.adminservice.controller;

import com.ronem.adminservice.model.request.client.CreateUserRequest;
import com.ronem.adminservice.model.response.ApiResponse;
import com.ronem.adminservice.model.response.CreateUserResponse;
import com.ronem.adminservice.service.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/admin")
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


    @PostMapping("/create")
    ResponseEntity<CreateUserResponse> createAdmin(@RequestBody CreateUserRequest request) {
        log.info("Admin Controller UserRequest body : {}", request);
        CreateUserResponse createUserResponse = adminService.createAdmin(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse);
    }

    @PutMapping("/activate/{userId}")
    ResponseEntity<CreateUserResponse> approveAdmin(@PathVariable Long userId) {
        CreateUserResponse createUserResponse = adminService.approveAdmin(userId);
        return ResponseEntity.status(HttpStatus.OK).body(createUserResponse);
    }

    @PutMapping("/approve/customer/{userId}")
    ResponseEntity<ApiResponse<Boolean>> approveCustomer(@PathVariable Long userId) {
        Boolean activated = adminService.approveCustomer(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "approved", activated));
    }
}
