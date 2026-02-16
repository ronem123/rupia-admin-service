/**
 * Author: Ram Mandal
 * Created on @System: Apple M1 Pro
 * User:rammandal
 * Date:16/02/2026
 * Time:15:14
 */


package com.ronem.adminservice.service.client;

import com.ronem.adminservice.exception.AdminServiceException;
import com.ronem.adminservice.model.response.ApiErrorResponse;
import com.ronem.adminservice.model.response.ApiResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CustomerClient {
    private WebClient customerWebClient;

    public CustomerClient(@Qualifier("rupia-customer-service") WebClient webClient) {
        this.customerWebClient = webClient;
    }

    /**
     * Update Customer status
     * incoming from rupia-admin-service, during customer approval
     */
    public ApiResponse<Boolean> verifyCustomer(Long userId) {
        return customerWebClient
                .put()
                .uri("internal/customers/" + userId + "/ekyc/verify")
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        clientResponse ->
                                clientResponse
                                        .bodyToMono(ApiErrorResponse.class)
                                        .flatMap(error ->
                                                Mono.error(
                                                        new AdminServiceException(HttpStatus.valueOf(clientResponse.statusCode().value()), error.message())
                                                )
                                        ))
                .bodyToMono(new ParameterizedTypeReference<ApiResponse<Boolean>>() {
                })
                .block();
    }
}