package dao;

import pojos.Department;

public interface DepartmentDao {
	String launchDepartment(Department dept);
	String deleteDepartmentDetails(String Name);
	Department getDepartmentDetails(String Name);
}
