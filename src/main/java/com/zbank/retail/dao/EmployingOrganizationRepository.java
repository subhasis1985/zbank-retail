package com.zbank.retail.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zbank.retail.entity.EmployingOrganization;

public interface EmployingOrganizationRepository extends JpaRepository<EmployingOrganization, String> {

}