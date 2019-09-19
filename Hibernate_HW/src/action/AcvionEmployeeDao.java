package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Department;
import model.Employee;
import model.EmployeeDaoImpl;
import util.HibernateUtil;

public class AcvionEmployeeDao {

	private static SessionFactory sessionFactory;
	private static Session session;

	public static void main(String[] args) {

		try {
			sessionFactory = HibernateUtil.getSessionfactory();
			session = sessionFactory.openSession();
			EmployeeDaoImpl empDao = new EmployeeDaoImpl(session);
			session = empDao.getSession();
//			Department dept = new Department();
//			dept.setDeptname("HR");
			session.beginTransaction();
//			empDao.insertDepartment(dept);

			
			
			Department dept = empDao.selectDepartment(4);
			
//			System.out.println(dept.getDeptname());
			
			
			
			
			
			Employee emp =new Employee();
			emp.setDept(dept);
			emp.setEmpname("Jack");
			emp.setSalary(990000);
			emp.setGender("female");
			
	
			
			
			empDao.inserEmployee(emp);
			
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.closeFactory();
		}

	}
}
