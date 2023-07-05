package com.zbank.retail.exception;

public class EmployingOrganizationNotFoundException extends RuntimeException {

	public EmployingOrganizationNotFoundException(String orgCode) {
		super("Could not find employing organization : " + orgCode);
	}
}