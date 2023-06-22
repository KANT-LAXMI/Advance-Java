package dao;

import pojos.Address;
import pojos.Employee;

public interface AddressDao {
	String assignedAddressToAnEmployee(Address adr,long empId);
	Address getAddressDetailsByEmpId(long empId);
}
