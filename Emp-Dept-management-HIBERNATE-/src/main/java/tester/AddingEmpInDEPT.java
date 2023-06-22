package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;
public class AddingEmpInDEPT {


public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in)){
			EmployeeDaoImpl dao=new EmployeeDaoImpl();
			System.out.println("enter the employee details");
			System.out.println("firstName,lastName,email,password,confirmPassword,\r\n"
					+ "	joinDate,type,salary");
			System.out.println("enter deptid::::");
			dao.addEmployeeInDepartment(new Employee(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),LocalDate.parse(sc.next()),EmploymentType.valueOf(sc.next().toUpperCase()), sc.nextDouble()),sc.nextLong());
		}

	}

}
