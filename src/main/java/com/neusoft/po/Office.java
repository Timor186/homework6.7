package com.neusoft.po;

import java.util.List;

public class Office {
	private int id;
	private String office;
	private String officeinfo;
	private List<Doctor> doctors;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getOfficeinfo() {
		return officeinfo;
	}
	public void setOfficeinfo(String officeinfo) {
		this.officeinfo = officeinfo;
	}
	public List<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
}
