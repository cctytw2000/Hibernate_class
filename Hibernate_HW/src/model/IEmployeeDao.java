package model;

import java.util.List;

interface IEmployeeDao {



	public Department insertDepartment(Department dept);

	public Employee inserEmployee(Employee emp);

	public boolean deleteDepartment(int deptID);

	public boolean deleteEmployee(int empid);

	public Employee updateEmployee(int empid,Employee emp);

	public Department updateDepartment(int deptid,Department dept);

	public Employee selectEmployee(int empid);

	public List<Employee> selectAllEmployee();
	
	public Department selectDepartment(int deptid);

	public List<Department> selectAllDepartment();

}
