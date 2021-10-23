package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {
    private Employee employee;
    private EmployeeMock employeeMock;
    int employeesNumber;

    @BeforeEach
    void setUpEmployee() {  //inainte de orice functie de testare, se cheama functia setUp()
        employee = new Employee();
        employeeMock = new EmployeeMock();
        employee.setEmployeeId(1);
        employee.setFirstName("Mihai");
        employee.setLastName("Popescu");
        employee.setCnp("1871201335470");
        employee.setFunction(DidacticFunction.ASISTENT);
        employee.setSalary(3500d);
        employeesNumber = employeeMock.getEmployeeList().size();
        System.out.println("setup made");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void addEmployeeTC1() {
        try{
            assert (true);
            assertEquals(true, employeeMock.addEmployee(employee));
            assertEquals(employeesNumber + 1, employeeMock.getEmployeeList().size());
        }catch(Exception e){
            assert (false);
        }
    }

    @Test
    void addEmployeeTC2() {
        try {
            employee.setEmployeeId(2);
            employee.setSalary(-1.0);
            assertEquals(false, employeeMock.addEmployee(employee));
            assert(true);
        } catch(Exception e) {
            assert (false);
            assertEquals(employeesNumber, employeeMock.getEmployeeList().size());
        }
    }

    @Test
    void addEmployeeTC3() {
        try {
            employee.setEmployeeId(3);
            employee.setCnp("18712013354711");
            assertEquals(false, employeeMock.addEmployee(employee));
            assert (true);
        } catch(Exception e) {
            assert (false);
            assertEquals(employeesNumber, employeeMock.getEmployeeList().size());
        }
    }

    @Test
    void addEmployeeTC4() {
        try {
            employee.setEmployeeId(4);
            employee.setCnp("187120133547");
            assertEquals(false, employeeMock.addEmployee(employee));
            assert (true);
        } catch(Exception e) {
            assert (false);
            assertEquals(employeesNumber, employeeMock.getEmployeeList().size());
        }
    }

    @Test
    void addEmployeeTC5() {
        try {
            employee.setEmployeeId(null);
            assertEquals(false, employeeMock.addEmployee(employee));
            assert (true);
        } catch(Exception e) {
            assert (false);
            assertEquals(employeesNumber, employeeMock.getEmployeeList().size());
        }
    }

    @Test
    void addEmployeeTC6() {
        try {
            employee.setEmployeeId(-2);
            assertEquals(false, employeeMock.addEmployee(employee));
            assert (true);
        } catch(Exception e) {
            assert (false);
            assertEquals(employeesNumber, employeeMock.getEmployeeList().size());
        }
    }

    @Test
    void addEmployeeTC7() {
        try {
            employee.setEmployeeId(0);
            assertEquals(false, employeeMock.addEmployee(employee));
            assert (true);
        } catch(Exception e) {
            assert (false);
            assertEquals(employeesNumber, employeeMock.getEmployeeList().size());
        }
    }

    @Test
    void addEmployeeTC8() {
        try {
            employee.setEmployeeId(5);
            employee.setSalary(0d);
            assertEquals(false, employeeMock.addEmployee(employee));
            assert (true);
        } catch(Exception e) {
            assert (false);
            assertEquals(employeesNumber, employeeMock.getEmployeeList().size());
        }
    }

    @Test
    void addEmployeeTC9() {
        try {
            employee.setEmployeeId(6);
            employee.setSalary(1d);
            assertEquals(true, employeeMock.addEmployee(employee));
            assert (true);
            assertEquals(employeesNumber + 1, employeeMock.getEmployeeList().size());
        } catch(Exception e) {
            assert (false);
        }
    }

    @Test
    void addEmployeeTC10() {
        try {
            employee.setEmployeeId(7);
            employee.setSalary(2d);
            assertEquals(true, employeeMock.addEmployee(employee));
            assert (true);
            assertEquals(employeesNumber + 1, employeeMock.getEmployeeList().size());
        } catch(Exception e) {
            assert (false);
        }
    }
}