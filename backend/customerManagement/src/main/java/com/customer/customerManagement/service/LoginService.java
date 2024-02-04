package com.customer.customerManagement.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    public ResponseEntity<String> validateUser(String loginId,String password) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"login_id\" :" + loginId+",\"password\" :"+password+"}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        String url = "https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                String.class);

        return response;
    }
}
