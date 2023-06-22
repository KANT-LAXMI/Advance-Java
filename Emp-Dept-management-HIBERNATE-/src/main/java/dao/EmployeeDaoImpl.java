package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

import pojos.Department;
import pojos.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String addEmployeeInDepartment(Employee emp, long deptid) {
		String mesg="adding failed";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Department dept = session.get(Department.class, deptid);
			dept.addEmployee(emp);
			tx.commit();
			mesg="adding done";
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
				throw e;
		}
		return mesg;
	}

	@Override
	public String deleteEmployeeFromDepartment(String EmpEmail,String deptName) {
		
		String mesg="Deletion failed";
		String djpql="select d from Department d where d.departmentName=:nm";
		String Ejpql="select e from Employee e where e.email=:em";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			
			Department dept = session.createQuery(djpql,Department.class).setParameter("nm",deptName ).getSingleResult();
			Employee emp = session.createQuery(Ejpql,Employee.class).setParameter("em",EmpEmail ).getSingleResult();
			dept.removeEmployee(emp);
			tx.commit();
			mesg="deleted successfully";
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
				throw e;
		}
		return mesg;
	}
		
	}


