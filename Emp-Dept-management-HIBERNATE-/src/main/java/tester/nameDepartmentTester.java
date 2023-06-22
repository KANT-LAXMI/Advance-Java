package tester;

import java.util.Scanner;
import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

import dao.DepartmentDaoImpl;
import pojos.Department;

public class nameDepartmentTester {


public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in)){
			DepartmentDaoImpl dao=new DepartmentDaoImpl();
			System.out.println("enter the department name");
			Department dept = dao.getDepartmentDetails(sc.next());
			System.out.println(dept);
		}

	}
}
