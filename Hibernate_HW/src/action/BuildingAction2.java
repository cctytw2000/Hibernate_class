package action;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.BuildingBean;
import util.HibernateUtil;

public class BuildingAction2 {

	private SessionFactory factory;
	private Session session;

	public BuildingAction2() {

		factory = HibernateUtil.getSessionfactory();
		session = factory.openSession();
	}

	public void queryDB() {
		BuildingBean bean1 = session.load(BuildingBean.class, 1001);
		int id = bean1.getBuildingid();
		String name = bean1.getBuildingname();
		int age = bean1.getBuildingage();
		System.out.println("id:" + id);
		System.out.println("name" + name);
		System.out.println("age:" + age);

	}

	public void saveDB() {
		try {
			session.beginTransaction();
			BuildingBean build1 = new BuildingBean();
			build1.setBuildingid(1001);
			build1.setBuildingname("Yellow Buliding");
			build1.setBuildingage(50);

			BuildingBean build2 = new BuildingBean();
			build2.setBuildingid(1002);
			build2.setBuildingname("Blue Buliding");
			build2.setBuildingage(15);

			ArrayList<BuildingBean> BuildingBeanList = new ArrayList<BuildingBean>();

			BuildingBeanList.add(build1);
			BuildingBeanList.add(build2);

			for (BuildingBean build : BuildingBeanList) {
				session.save(build);
			}
//			session.delete(build1);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void closeAll() {

		session.close();
		HibernateUtil.closeFactory();
	}

	public static void main(String[] args) {
		BuildingAction2 BA2 = new BuildingAction2();
		BA2.queryDB();
		BA2.closeAll();
	}

}
