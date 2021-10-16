package AngajatiApp.repository;

import java.io.IOException;
import java.util.List;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;

public interface EmployeeRepositoryInterface {

	boolean addEmployee(Employee employee) throws IOException;
	void modifyEmployeeFunction(Employee employee, DidacticFunction newFunction);
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeByCriteria();
	Employee findEmployeeById(int idOldEmployee);

}
