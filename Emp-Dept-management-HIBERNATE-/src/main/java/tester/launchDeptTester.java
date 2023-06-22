package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDaoImpl;
import pojos.Department;
public class launchDeptTester {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in)){
			DepartmentDaoImpl dao=new DepartmentDaoImpl();
			System.out.println("enter the dept details:departmentName,location");
			dao.launchDepartment(new Department(sc.next(), sc.next()));
		}

	}

}
