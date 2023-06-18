package com.zbank.retail.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employing-organization",schema = "data")
public class EmployingOrganization {

	private @Id @GeneratedValue(strategy = GenerationType.UUID) String orgCode;
	private String orgName;
	private String orgNote;

	EmployingOrganization() {
	}

	public EmployingOrganization(String orgCode, String orgName, String orgNote) {

		this.orgCode = orgCode;
		this.orgName = orgName;
		this.orgNote = orgNote;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgNote() {
		return orgNote;
	}

	public void setOrgNote(String orgNote) {
		this.orgNote = orgNote;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof EmployingOrganization))
			return false;
		EmployingOrganization empOrg = (EmployingOrganization) o;
		return Objects.equals(this.orgCode, empOrg.orgCode) && Objects.equals(this.orgName, empOrg.orgName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.orgCode, this.orgName);
	}

	@Override
	public String toString() {
		return "Employee{" + "orgCode=" + this.orgCode + ", orgName='" + this.orgName+'}';
	}
}