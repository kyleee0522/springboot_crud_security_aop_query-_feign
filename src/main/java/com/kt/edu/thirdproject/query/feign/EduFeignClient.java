package com.kt.edu.thirdproject.query.feign;

import com.kt.edu.thirdproject.query.repository.entity.EmployeeEntity;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="edu", url="${api.edu.url}")
//@FeignClient(name="edu", url="https://jsonplaceholder.typicode.com",configuration = FeignConfig.class)
public interface EduFeignClient {

    @GetMapping(path = "/users", produces = "application/json")
    public String getUsers();

    @PostMapping(path = "/api/v1/employees", consumes = "application/json")
    public ResponseEntity<EmployeeEntity> EmployeeCreate(@RequestBody EmployeeEntity employeeEntity);


}