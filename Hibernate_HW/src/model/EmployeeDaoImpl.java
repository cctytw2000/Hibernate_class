package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class EmployeeDaoImpl implements IEmployeeDao {

	private Session session;

	public EmployeeDaoImpl(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}




	@Override
	public Department insertDepartment(Department dept) {

		Department build = (Department) getSession().get(Department.class, dept.getDeptid());
		if (build == null) {
			getSession().save(dept);
			return dept;
		}
		return null;

	}

	@Override
	public Employee inserEmployee(Employee emp) {
		Employee build = (Employee) getSession().get(Employee.class, emp.getEmpid());
		if (build == null) {
			getSession().save(emp);
			return emp;
		}
		return null;

	}

	@Override
	public boolean deleteDepartment(int deptID) {
		Department result = (Department) getSession().get(Department.class, deptID);
		if (result != null) {
			getSession().delete(result);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int empid) {
		Employee result = (Employee) getSession().get(Employee.class, empid);
		if (result != null) {
			getSession().delete(result);
			return true;
		}
		return false;
	}

	@Override
	public Employee updateEmployee(int empid, Employee emp) {
		Employee result = (Employee) getSession().get(Employee.class, empid);
		if (result != null) {
			result.setEmpname(emp.getEmpname());
			result.setSalary(emp.getSalary());
			result.setGender(emp.getGender());
			return result;
		}
		return null;
	}

	@Override
	public Department updateDepartment(int deptid, Department dept) {
		Department result = (Department) getSession().get(Department.class, deptid);
		if (result != null) {
			result.setDeptname(dept.getDeptname());

			return result;
		}
		return null;
	}



	@Override
	public Employee selectEmployee(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department selectDepartment(int deptid) {
		Department result = (Department) getSession().get(Department.class, deptid);
		if (result != null) {

			return result;
		}
		return null;
	}

	@Override
	public List<Department> selectAllDepartment() {
		Query query = session.createQuery("from Department");
		return (List<Department>) query.list();
	}

}
