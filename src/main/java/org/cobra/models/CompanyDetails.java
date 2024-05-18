package org.cobra.models;

public class CompanyDetails {

	String companyName;
	String companyLocation;
	String companyMob;
	String companyReg;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public String getCompanyMob() {
		return companyMob;
	}

	public void setCompanyMob(String companyMob) {
		this.companyMob = companyMob;
	}

	public String getCompanyReg() {
		return companyReg;
	}

	public void setCompanyReg(String companyReg) {
		this.companyReg = companyReg;
	}

	@Override
	public String toString() {
		return "CompanyDetails [companyName=" + companyName + ", companyLocation=" + companyLocation + ", companyMob="
				+ companyMob + ", companyReg=" + companyReg + "]";
	}

}
