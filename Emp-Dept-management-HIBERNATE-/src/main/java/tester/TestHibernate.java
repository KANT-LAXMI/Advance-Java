package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

public class TestHibernate {

	public static void main(String[] args) {
 
		//cls loading --> static init block --> configure : entire hib frmwork loaded
		try(SessionFactory sf=getFactory()){
			System.out.println("hib up n running !!!! "+sf);
		} //sf.close() --> cleaning up DBCP (db conn pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
