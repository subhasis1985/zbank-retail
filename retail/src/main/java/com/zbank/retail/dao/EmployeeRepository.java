package com.zbank.retail.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zbank.retail.entity.EmployingOrganization;

public interface EmployeeRepository extends JpaRepository<EmployingOrganization, String> {

}