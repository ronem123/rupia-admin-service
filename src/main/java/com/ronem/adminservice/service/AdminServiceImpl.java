/**
 * Author: Ram Mandal
 * Created on @System: Apple M1 Pro
 * User:rammandal
 * Date:28/01/2026
 * Time:10:16
 */


package com.ronem.adminservice.service;

import com.ronem.adminservice.model.request.client.CreateUserRequest;
import com.ronem.adminservice.model.response.ApiResponse;
import com.ronem.adminservice.model.response.CreateUserResponse;
import com.ronem.adminservice.service.client.AuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final AuthClient authClient;


    @Override
    public CreateUserResponse createAdmin(CreateUserRequest request) {

        ApiResponse<CreateUserResponse> response = authClient.createUser(request);
        if(!response.isSuccess()){
            throw new RuntimeException("User creation failed with " + response.getMessage());
        }
        return response.getData();
    }
}