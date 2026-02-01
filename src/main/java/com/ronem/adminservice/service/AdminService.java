package com.ronem.adminservice.service;


import com.ronem.adminservice.model.request.client.CreateUserRequest;
import com.ronem.adminservice.model.response.CreateUserResponse;

/**
 * Author: Ram Mandal
 * Created on @System: Apple M1 Pro
 * User:rammandal
 * Date:28/01/2026
 * Time:10:08
 */

public interface AdminService {
    CreateUserResponse createAdmin(CreateUserRequest request);

}
