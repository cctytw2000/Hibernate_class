package action;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.BuildingBean;
import util.HibernateUtil;

public class BuildingAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session = factory.openSession();

		try {
			session.beginTransaction();
			BuildingBean build1 = new BuildingBean();
			build1.setBuildingid(1001);
			build1.setBuildingname("Yellow Buliding");
			build1.setBuildingage(50);

//			
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
		} finally {
			session.close();
			HibernateUtil.closeFactory();
		}
	}

}
