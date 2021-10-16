package AngajatiApp.repository;

import java.util.ArrayList;
import java.util.List;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import AngajatiApp.validator.EmployeeValidator;

public class EmployeeMock implements EmployeeRepositoryInterface {

	private List<Employee> employeeList;
	private EmployeeValidator employeeValidator;
	
	public EmployeeMock() {
		employeeValidator = new EmployeeValidator();
		employeeList = new ArrayList<Employee>();
		final String cnpValue = "1234567890876";
		
		Employee Ionel = new Employee("Marius", "Pacuraru", cnpValue, DidacticFunction.ASISTENT, 2500d);
		Employee Mihai = new Employee("Ion", "Dumitrescu", cnpValue, DidacticFunction.LECTURER, 2500d);
		Employee Ionela = new Employee("Gicu", "Ionescu", cnpValue, DidacticFunction.LECTURER, 2500d);
		Employee Mihaela = new Employee("Dodel", "Pacuraru", cnpValue, DidacticFunction.ASISTENT, 2500d);
		Employee Vasile = new Employee("Dorel", "Georgescu", cnpValue, DidacticFunction.TEACHER, 2500d);
		Employee Marin   = new Employee("Larson", "Puscas", cnpValue, DidacticFunction.TEACHER,  2500d);
		
		employeeList.add(Ionel);
		employeeList.add(Mihai);
		employeeList.add(Ionela);
		employeeList.add(Mihaela);
		employeeList.add(Vasile);
		employeeList.add(Marin);
	}

	/**
	 * adauga un angajat in repository
	 * @param employee - un angajat cu atributele id, nlastName, firstName, cnp,
	 *                 function, salary;
	 * @return boolean - false daca employee nu este valid
	 */
	@Override
	public boolean addEmployee(Employee employee) {
		if ( employeeValidator.isValid(employee)) {
			employeeList.add(employee);
			return true;
		}
		return false;
	}

	/**
	 * Modifica atributul 'functia didactica' pentru un angajat dat
	 * @param employee - anagajtul eptnru care se modifica atributul 'functia didactica'
	 * @param newFunction - noua functie didactica (ASISTENT, LECTURER, TEACHER, CONFERENTIAR)
	 */
	@Override
	public void modifyEmployeeFunction(Employee employee, DidacticFunction newFunction) {

		if (employee!=null) {
			int i = 0;
			while (i < employeeList.size()) {
				if (employeeList.get(i).getEmployeeId() == employee.getEmployeeId())
					employeeList.get(i).setFunction(newFunction);
				i++;
			}
		}
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployeeById(int idOldEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

}
