package dao;

import pojos.Employee;

public interface EmployeeDao {
	String addEmployeeInDepartment(Employee emp,long deptid);
	String deleteEmployeeFromDepartment(String EmpEmail,String deptName);
}
