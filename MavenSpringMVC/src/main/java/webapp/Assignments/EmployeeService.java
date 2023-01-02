package webapp.Assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
	private static List<Employee> employee = new ArrayList<Employee>();
	public void addEmployee(int employeeId, String employeeName,String employeeDepartment,String employeeDesignation,long employeeSalary)
	{
		employee.add(new Employee(employeeId, employeeName,employeeDepartment,employeeDesignation,employeeSalary));
	}
	public void deleteEmployee(int id) {
		Iterator<Employee> iterator = employee.iterator();
		while (iterator.hasNext()) {
			Employee emp = iterator.next();
			if (emp.getEmployeeId() == id) {
				iterator.remove();
			}
		}
	}
	public List<Employee> retrieveEmployees(String user) {
		List<Employee> filteredEmployees = new ArrayList<Employee>();
		for (Employee emp :employee) {
			if (emp.getEmployeeName().equals(user))
				filteredEmployees.add(emp);
		}
		return filteredEmployees;
	}
	public Employee retrieveEmployee(int id) {
		for (Employee emp:employee) {
			if (emp.getEmployeeId() == id)
				return emp;
		}
		return null;
	}

	public void updateEmployee(Employee emp) {
		employee.remove(emp);
		employee.add(emp);
	}
}
