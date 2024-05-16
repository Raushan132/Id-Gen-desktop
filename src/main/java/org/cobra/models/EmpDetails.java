package org.cobra.models;

public class EmpDetails {
    String name;
    String fatherName;
    String address;
    String designation;
    String regNo;
    String dob;
    String bloodGroup;
    String joiningDate;
    String photoUrl;


    @Override
	public String toString() {
		return "EmpDetails [name=" + name + ", fatherName=" + fatherName + ", address=" + address + ", designation="
				+ designation + ", regNo=" + regNo + ", dob=" + dob + ", bloodGroup=" + bloodGroup + ", joiningDate="
				+ joiningDate + ", photoUrl=" + photoUrl + "]";
	}
    
    public String[] getValues() {
    	return new String[] {name,fatherName,address,dob ,regNo,designation, joiningDate,bloodGroup,photoUrl};
    }
     
    public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

}
