package org.bst.avito.service;

import jakarta.annotation.PostConstruct;
import org.bst.avito.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

@Component
public class EmployeeQueue {
    private final EmployeeService employeeService;

    public EmployeeQueue(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private Queue<EmployeeEntity> employeeEntities;

    @PostConstruct
    private void loadQueue() {
        employeeEntities = Collections.asLifoQueue(new LinkedList<>(employeeService.getEmployees()));
    }

    public EmployeeEntity get() {
        EmployeeEntity entity = employeeEntities.poll();
        if (entity != null) {
            employeeEntities.offer(entity);
        };

        return entity;
    }
}
