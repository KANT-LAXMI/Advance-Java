package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department extends BaseEntity {
	@Column(name="department_name",length = 30,unique = true)
	private String departmentName;
	@Column(length = 50)
	private String location;
	// Department 1---->* Emps
	@OneToMany(mappedBy = "assignedDepartment",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Employee>empList=new ArrayList<>();
	

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String departmentName, String location) {
		super();
		this.departmentName = departmentName;
		this.location = location;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void addEmployee(Employee emp) {
		empList.add(emp);
		emp.setAssignedDepartment(this);
	}

	public void removeEmployee(Employee emp) {
		empList.remove(emp);
		emp.setAssignedDepartment(null);
	}
	// Project tip :
	// DO NOT add any association fields in toString (to avoid recursion)
	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", location=" + location + "]";
	}
	
	//project tip : add helper methods
 

}
