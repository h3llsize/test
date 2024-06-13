package com.company.bstcrm.app;

import com.company.bstcrm.dto.AvitoEmployeeDTO;
import com.company.bstcrm.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AvitoRequestService {

    private final RestTemplate restTemplate;

    public AvitoRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void addEmployee(User user) {
        AvitoEmployeeDTO avitoEmployeeDTO = new AvitoEmployeeDTO();
        avitoEmployeeDTO.setActive(user.getAvitoAccount());
        avitoEmployeeDTO.setId(user.getId());
        avitoEmployeeDTO.setName(user.getFirstName());
        avitoEmployeeDTO.setPhoneNumber(user.getPhoneNumber());

        restTemplate.postForObject("http://localhost:8081/api/vk/add-employee", avitoEmployeeDTO, String.class);
    }
}