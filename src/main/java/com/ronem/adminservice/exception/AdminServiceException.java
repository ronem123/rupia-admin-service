/**
 * Author: Ram Mandal
 * Created on @System: Apple M1 Pro
 * User:rammandal
 * Date:16/02/2026
 * Time:15:25
 */


package com.ronem.adminservice.exception;

import org.springframework.http.HttpStatus;

public class AdminServiceException extends RuntimeException {
    private HttpStatus status;

    public AdminServiceException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}