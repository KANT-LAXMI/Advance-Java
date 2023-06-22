package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;
import pojos.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public String launchDepartment(Department dept) {
		String mesg="Launching of department failed";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(dept);
			tx.commit();
			mesg="department added successfully";
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
				throw e;
		}
		return mesg;
	}

	@Override
	public String deleteDepartmentDetails(String Name) {
		String mesg="deletion failed";
		String jpql="select d from Department d where d.departmentName=:dm";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Department dept = session.createQuery(jpql, Department.class).setParameter("dm", Name).getSingleResult();
			session.delete(dept);
			tx.commit();
			mesg="deletion successfull";
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
				throw e;
		}
		return mesg;
	
	}

	@Override
	public Department getDepartmentDetails(String Name) {
		
		Department dept=null;
		String jpql="select d from Department d left join fetch d.empList where d.departmentName=:dm";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			dept = session.createQuery(jpql, Department.class).setParameter("dm", Name).getSingleResult();
			
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
				throw e;
		}
		return dept;
	}
}
