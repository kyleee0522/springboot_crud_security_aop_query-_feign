package com.kt.edu.thirdproject.query.repository;



import com.kt.edu.thirdproject.query.repository.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeQueryRepository extends CrudRepository<EmployeeEntity, Long> {

}
