package AngajatiApp.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import AngajatiApp.model.AgeCriteria;
import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import AngajatiApp.validator.EmployeeException;
import AngajatiApp.validator.EmployeeValidator;
import AngajatiApp.model.SalaryCriteria;

public class EmployeeImpl implements EmployeeRepositoryInterface {

	private static final String ERROR_WHILE_READING_MSG = "Error while reading: ";
	private final String employeeDBFile = "employeeDB/employees.txt";
	private EmployeeValidator employeeValidator = new EmployeeValidator();
	private List<Employee> employeeList = new ArrayList<>();
	
	public EmployeeImpl() {
		employeeList = loadEmployeesFromFile();
	}

	@Override
	public boolean addEmployee(Employee employee) throws IOException {
		employee.setEmployeeId(employeeList.size());
		if (employeeValidator.isValid(employee)) {
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(employeeDBFile, true));
				bw.write(employee.toString());
				bw.newLine();
				bw.close();
				employeeList.add(employee);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
			bw.close();
		}
		return false;

	}

	@Override
	public void modifyEmployeeFunction(Employee oldEmployee, DidacticFunction newFunction) {
		oldEmployee.setFunction(newFunction);
	}
	
	private List<Employee> loadEmployeesFromFile() {
		final List<Employee> employeeList = new ArrayList<Employee>();
		try (BufferedReader br = new BufferedReader(new FileReader(employeeDBFile));){
			String line;
			int counter = 0;
			while ((line = br.readLine()) != null) {
				extracted(employeeList, line, counter);
			}
		} catch (IOException e) {
			System.err.println(ERROR_WHILE_READING_MSG + e);
		} 
		return employeeList;
	}

	private void extracted(List<Employee> employeeList, String line, int counter) {
		try {
			final Employee employee = Employee.getEmployeeFromString(line, counter);
			employeeList.add(employee);
		} catch (EmployeeException ex) {
			System.err.println(ERROR_WHILE_READING_MSG + ex.toString());
		}
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByCriteria() {
		List<Employee> employeeSortedList = new ArrayList<Employee>(employeeList);
		Collections.copy(employeeSortedList, employeeList);
		Collections.sort(employeeSortedList, new AgeCriteria());
		Collections.sort(employeeSortedList, new SalaryCriteria());
		return employeeSortedList;
	}

	@Override
	public Employee findEmployeeById(int idOldEmployee) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == idOldEmployee) {
				return employee;
			}
		}
		return null;
	}

}
