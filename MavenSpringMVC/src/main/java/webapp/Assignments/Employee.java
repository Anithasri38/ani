package webapp.Assignments;

import java.util.Objects;

public class Employee {
   private int employeeId;
   private String employeeName;
   private String employeeDepartment;
   private String employeeDesignation;
   private long employeeSalary;
   public Employee()
   {
	   
   }
public Employee(int employeeId, String employeeName, String employeeDepartment, String employeeDesignation,
		long employeeSalary) {
	super();
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	this.employeeDepartment = employeeDepartment;
	this.employeeDesignation = employeeDesignation;
	this.employeeSalary = employeeSalary;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getEmployeeDepartment() {
	return employeeDepartment;
}
public void setEmployeeDepartment(String employeeDepartment) {
	this.employeeDepartment = employeeDepartment;
}
public String getEmployeeDesignation() {
	return employeeDesignation;
}
public void setEmployeeDesignation(String employeeDesignation) {
	this.employeeDesignation = employeeDesignation;
}
public long getEmployeeSalary() {
	return employeeSalary;
}
public void setEmployeeSalary(long employeeSalary) {
	this.employeeSalary = employeeSalary;
}
@Override
public String toString() {
	return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDepartment="
			+ employeeDepartment + ", employeeDesignation=" + employeeDesignation + ", employeeSalary=" + employeeSalary
			+ "]";
}
@Override
public int hashCode() {
	return Objects.hash(employeeId);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	return employeeId == other.employeeId;
}


  
}
