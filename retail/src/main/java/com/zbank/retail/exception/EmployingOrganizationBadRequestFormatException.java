package com.zbank.retail.exception;

public class EmployingOrganizationBadRequestFormatException extends RuntimeException {

	public EmployingOrganizationBadRequestFormatException(String orgCodeParam, String orgCodeRequestBody) {
		super(String.format("OrgCode in url %s and in request %s does not match", orgCodeParam, orgCodeRequestBody));
	}
}