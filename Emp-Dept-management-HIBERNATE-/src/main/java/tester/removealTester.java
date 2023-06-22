package tester;

import java.util.Scanner;

import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;

public class removealTester {


public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in)){
			EmployeeDaoImpl dao=new EmployeeDaoImpl();
			System.out.println("email and deptname");
			dao.deleteEmployeeFromDepartment(sc.next(), sc.next());
		}

	}

}
