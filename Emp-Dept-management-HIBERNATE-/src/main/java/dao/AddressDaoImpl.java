package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;
import pojos.Address;
import pojos.Employee;

public class AddressDaoImpl implements AddressDao{

	@Override
	public String assignedAddressToAnEmployee(Address adr, long empId) {
		String mesg="Assinging failed";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Employee emp = session.get(Employee.class, empId);
			if(emp!=null) {
				adr.setAssignedEmp(emp);
				session.persist(adr);
			}
			tx.commit();
			mesg="assigned success";
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
				throw e;
		}
		return mesg;
	}

	@Override
	public Address getAddressDetailsByEmpId(long empId) {
		Address adr =null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			adr = session.get(Address.class, empId);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
				throw e;
		}
		return adr;
	}


}
