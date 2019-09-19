package action;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.BuildingBean;
import util.HibernateUtil;

public class BuildingAction3 {

	private SessionFactory factory;
	private Session session;

	public BuildingAction3() {

		factory = HibernateUtil.getSessionfactory();
		session = factory.openSession();
	}

	public void queryDB() {
		BuildingBean bean1 = session.load(BuildingBean.class, 1004);
		int id = bean1.getBuildingid();
		String name = bean1.getBuildingname();
		int age = bean1.getBuildingage();
		System.out.println("id:" + id);
		System.out.println("name:" + name);
		System.out.println("age:" + age);

	}

	public void insertDB() {

		BuildingBean build1 = new BuildingBean();
		build1.setBuildingid(1003);
		build1.setBuildingname("Action Buliding");
		build1.setBuildingage(50);

		BuildingBean build2 = new BuildingBean();
		build2.setBuildingid(1004);
		build2.setBuildingname("Save Buliding");
		build2.setBuildingage(15);

		ArrayList<BuildingBean> BuildingBeanList = new ArrayList<BuildingBean>();

		BuildingBeanList.add(build1);
		BuildingBeanList.add(build2);
		for (BuildingBean build : BuildingBeanList) {
			session.save(build);
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void queryAll() {
		Query query = session.createQuery("from BuildingBean");
		List<BuildingBean> buildingList = (List<BuildingBean>) query.list();
		for (BuildingBean build : buildingList) {
			System.out.println("id:" + build.getBuildingid());
			System.out.println("name:" + build.getBuildingname());
			System.out.println("age:" + build.getBuildingage());

		}
	}

	public void processAction() {
		try {
			session.beginTransaction();
//			insertDB();
//			queryDB();
			queryAll();
			session.getTransaction().commit();
		}

		catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.closeFactory();
		}

	}

	public static void main(String[] args) {
		BuildingAction3 BA2 = new BuildingAction3();
		BA2.processAction();

	}

}
