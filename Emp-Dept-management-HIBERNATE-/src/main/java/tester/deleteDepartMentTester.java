package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDaoImpl;;

public class deleteDepartMentTester {

	public static void main(String[] args) {

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			DepartmentDaoImpl dao=new DepartmentDaoImpl();
			System.out.println("enter the department name");
			dao.deleteDepartmentDetails(sc.next());

		}

	}

}
