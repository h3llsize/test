package org.bst.avito.service;

import org.bst.avito.dto.AvitoEmployeeDTO;
import org.bst.avito.entity.EmployeeEntity;
import org.bst.avito.repo.EmployeeRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("employeeService")
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity getById(UUID id) {
        return employeeRepository.findByCrmId(id);
    }

    public EmployeeEntity updateEntity(AvitoEmployeeDTO avitoEmployeeDTO) {
        EmployeeEntity entity = getById(avitoEmployeeDTO.getId());

        if(entity == null) {
            EmployeeEntity employee = new EmployeeEntity();
            employee.setCrmId(avitoEmployeeDTO.getId());
            employee.setName(avitoEmployeeDTO.getName());
            employee.setIsActive(avitoEmployeeDTO.getActive());
            employee.setPhoneNumber(avitoEmployeeDTO.getPhoneNumber());

            return employeeRepository.save(employee);
        } else {
            entity.setPhoneNumber(avitoEmployeeDTO.getPhoneNumber());
            entity.setName(avitoEmployeeDTO.getName());
            entity.setIsActive(avitoEmployeeDTO.getActive());
            entity.setCrmId(avitoEmployeeDTO.getId());

            return employeeRepository.save(entity);
        }
    }
}
