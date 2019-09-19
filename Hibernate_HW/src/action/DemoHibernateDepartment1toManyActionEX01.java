package action;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.Department;
import model.Employee;
import util.HibernateUtil;

public class DemoHibernateDepartment1toManyActionEX01 {
	private SessionFactory sessionFactory;
	private Session session;

	public void processAction() {
		try {
			sessionFactory = HibernateUtil.getSessionfactory();
			session = sessionFactory.openSession();
			session.beginTransaction();

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.closeFactory();
		}

	}

	public boolean deleteDepartment(int deptID) {

		Department result = session.get(Department.class, deptID);
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

	public boolean deleteEmployee(int empid) {

		Employee result = session.get(Employee.class, empid);
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

	public Employee updateEmployee(int empid, String empname) {

		Employee result = session.get(Employee.class, empid);
		if (result != null) {
			result.setEmpname(empname);
			return result;
		}
		return null;
	}

	public Department updateDepartment(int deptid, String deptname) {

		Department result = session.get(Department.class, deptid);
		if (result != null) {
			result.setDeptname(deptname);
			return result;
		}
		return null;
	}

	public Employee select(int empid) {
		return session.get(Employee.class, empid);
	}

	public List<Employee> selectAll() {
		Query query = session.createQuery("from Employee");
		return (List<Employee>) query.list();
	}

	private void insertdata() {

		Department dept1 = new Department();
		dept1.setDeptid(1);
		dept1.setDeptname("IT");

		Employee emp1 = new Employee();
		emp1.setEmpname("John");
		emp1.setGender("male");
		emp1.setSalary(100000);

		Employee emp2 = new Employee();
		emp2.setEmpname("Tony");
		emp2.setGender("male");
		emp2.setSalary(30000);

		emp1.setDept(dept1);
		emp2.setDept(dept1);

		Set<Employee> empSet = new LinkedHashSet<Employee>();
		empSet.add(emp1);
		empSet.add(emp2);

		dept1.setEmployees(empSet);
		session.save(dept1);

	}

	public static void main(String[] args) {
		DemoHibernateDepartment1toManyActionEX01 act1 = new DemoHibernateDepartment1toManyActionEX01();
		act1.processAction();

	}

}
