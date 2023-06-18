package com.dal.model;

import java.io.Serializable;
import java.util.Comparator;


public class Employee implements Serializable {
	private int empno;
	private String ename;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + "]";
	}
	@Override
	public int compareTo(Employee emp) {
		return this.empno - emp.empno;
	}

	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp1.getEname().compareTo(emp2.getEname());
		}
	};
}