package tester;

import java.util.Scanner;
import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

import dao.AddressDaoImpl;
import pojos.Address;

public class addressDetailByEmpIdTester {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in)) {
			
			AddressDaoImpl dao=new AddressDaoImpl();
			System.out.println("enter emp id");
			System.out.println(dao.getAddressDetailsByEmpId(sc.nextLong()));
			
		} catch (Exception e) {
			e.printStackTrace();
		

	}
	}
}
