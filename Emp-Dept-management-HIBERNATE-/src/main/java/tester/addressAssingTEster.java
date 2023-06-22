package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDaoImpl;
import pojos.Address;
public class addressAssingTEster {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in)) {
			AddressDaoImpl dao=new AddressDaoImpl();
			System.out.println("enter address details:adrLine1,adrLine2,city,state,country,zipCode");
			System.out.println("enter the empId");
			
			dao.assignedAddressToAnEmployee(new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next()), sc.nextLong());
			System.out.println("address assigned");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
