package org.bst.avito.controller;

import org.bst.avito.dto.AvitoEmployeeDTO;
import org.bst.avito.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vk")
public class AvitoCRMController {

    private final EmployeeService employeeService;

    public AvitoCRMController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add-employee")
    public void addEmployee(@RequestBody AvitoEmployeeDTO avitoEmployeeDTO) {
        employeeService.updateEntity(avitoEmployeeDTO);
    }
}
