/**
 * Author: Ram Mandal
 * Created on @System: Apple M1 Pro
 * User:rammandal
 * Date:28/01/2026
 * Time:15:51
 */


package com.ronem.adminservice.model.request.client;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    private String email;
    private String mobileNumber;
    private String userRole;
}