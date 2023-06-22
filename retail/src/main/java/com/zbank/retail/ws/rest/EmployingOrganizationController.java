package com.zbank.retail.ws.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zbank.retail.entity.EmployingOrganization;
import com.zbank.retail.dao.EmployingOrganizationRepository;
import com.zbank.retail.exception.EmployingOrganizationBadRequestFormatException;
import com.zbank.retail.exception.EmployingOrganizationNotFoundException;

@RestController
public class EmployingOrganizationController {

	private final EmployingOrganizationRepository repository;

	EmployingOrganizationController(EmployingOrganizationRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/emporgs")
	List<EmployingOrganization> all() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]

	@PostMapping("/emporgs")
	EmployingOrganization newEmpOrg(@RequestBody EmployingOrganization empOrg) {
		return repository.save(empOrg);
	}

	// Single item

	@GetMapping("/emporgs/{orgCode}")
	EmployingOrganization one(@PathVariable String orgCode) {

		return repository.findById(orgCode).orElseThrow(() -> new EmployingOrganizationNotFoundException(orgCode));
	}

	@PutMapping("/emporgs/{orgCode}")
	EmployingOrganization replaceEmployingOrg(@RequestBody EmployingOrganization newEmpOrg,
			@PathVariable String orgCode) {
		if (!orgCode.equals(newEmpOrg.getOrgCode())) {
			throw new EmployingOrganizationBadRequestFormatException(orgCode, newEmpOrg.getOrgCode());
		}
		return repository.findById(orgCode).map(empOrg -> {
			empOrg.setOrgName(newEmpOrg.getOrgName());
			empOrg.setOrgNote(newEmpOrg.getOrgName());
			return repository.save(empOrg);
		}).orElseGet(() -> {
			newEmpOrg.setOrgCode(orgCode);
			return repository.save(newEmpOrg);
		});
	}

	@DeleteMapping("/emporgs/{orgCode}")
	void deleteEmployingOrg(@PathVariable String orgCode) {
		repository.deleteById(orgCode);
	}
}