package AngajatiApp.validator;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;

public class EmployeeValidator {

	public EmployeeValidator(){
		//should be empty because is a constructor without parameters
	}

	public boolean isValid(Employee employee) {
		return isFirstNameValid(employee) 
				&& isLastNameValid(employee) 
				&& isCnpValid(employee) 
				&& isFunctionValid(employee) 
				&& isSalaryValid(employee)
				&& isEmployeeIdValid(employee);
	}

	private boolean isEmployeeIdValid(Employee employee) {
		if(employee.getEmployeeId() != null) {
			return employee.getEmployeeId() > 0;
		}
		return false;
	}

	private boolean isSalaryValid(Employee employee) {
		return employee.getSalary() > 0;
	}

	private boolean isFunctionValid(Employee employee) {
		return employee.getFunction().equals(DidacticFunction.ASISTENT)
				|| employee.getFunction().equals(DidacticFunction.LECTURER) 
				|| employee.getFunction().equals(DidacticFunction.TEACHER) 
				|| employee.getFunction().equals(DidacticFunction.CONFERENTIAR);
	}

	private boolean isCnpValid(Employee employee) {
		return employee.getCnp().matches("[0-9]+") && (employee.getCnp().length() == 13);
	}

	private boolean isLastNameValid(Employee employee) {
		return employee.getLastName().matches("[a-zA-Z]+") && (employee.getLastName().length() > 2);
	}

	private boolean isFirstNameValid(Employee employee) {
		return employee.getFirstName().matches("[a-zA-Z]+") && (employee.getFirstName().length() > 2);
	}
	
}
