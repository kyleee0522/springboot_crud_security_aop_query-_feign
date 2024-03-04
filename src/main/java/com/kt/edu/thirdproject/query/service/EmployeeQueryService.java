package com.kt.edu.thirdproject.query.service;

import com.kt.edu.thirdproject.common.exception.ResourceNotFoundException;
import com.kt.edu.thirdproject.query.repository.EmployeeQueryRepository;
import com.kt.edu.thirdproject.query.repository.entity.EmployeeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeQueryService {
    @Autowired
    private EmployeeQueryRepository employeeQueryRepository;

    @Transactional(readOnly = true)
    public List<EmployeeEntity> getEmployeeList() {
        log.info("#####QUERY###### Request to get all Employees");
        List<EmployeeEntity> employeeList = new ArrayList<>();
        employeeQueryRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }

    // 플러시를 생략해서 dirty checking등을 하지 않으므로 약간의 성능 향상
    @Transactional(readOnly = true)
    public EmployeeEntity getEmployee(Long id) {
        log.info("#####QUERY###### Request to get Employee : {}", id);
        return employeeQueryRepository.findById(id).get();
    }
}
