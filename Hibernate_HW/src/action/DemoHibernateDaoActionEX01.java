package action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.BuildingBean;
import model.BuildingDaoImple;
import util.HibernateUtil;

public class DemoHibernateDaoActionEX01 {

	public static void main(String[] args) {
		SessionFactory sessionfactory = HibernateUtil.getSessionfactory();
		Session session = sessionfactory.openSession();
		BuildingDaoImple bDao = new BuildingDaoImple(session);



		try {
			session.beginTransaction();
			
		
//			BuildingBean build = new BuildingBean();
//			build.setBuildingid(106);
//			build.setBuildingname("Coding House");
//			build.setBuildingage(1);
			
//			bDao.insert(build);
			
//			bDao.update(1003, "Food House");
			
//			bDao.delete(1001);
			
			
//			List<BuildingBean> buildList = bDao.selectAll();
//			for(BuildingBean build:buildList) {
//				System.out.println(build.getBuildingid());
//				System.out.println(build.getBuildingname());
//				System.out.println(build.getBuildingage());
//			}
			
			
			BuildingBean build = bDao.select(1006);
			
			System.out.println("id:"+build.getBuildingid());
			System.out.println("name:"+build.getBuildingname());
			System.out.println("age:"+build.getBuildingage());
			
			session.getTransaction().commit();
		} catch (Exception e) {

			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
			HibernateUtil.closeFactory();
		}
	}

}
