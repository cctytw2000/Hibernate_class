package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class BuildingDaoImple implements IBuildingDao {
	private Session session;

	public BuildingDaoImple(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	public boolean delete(int bulidingID) {

		BuildingBean result = (BuildingBean) getSession().get(BuildingBean.class, bulidingID);
		if (result != null) {
			getSession().delete(result);
			return true;
		}
		return false;
	}

	public BuildingBean update(int bulidingID, String buildingName) {

		BuildingBean result = (BuildingBean) getSession().get(BuildingBean.class, bulidingID);
		if (result != null) {
			result.setBuildingname(buildingName);
			return result;
		}
		return null;
	}

	public BuildingBean insert(BuildingBean bean) {
		BuildingBean build = (BuildingBean) getSession().get(BuildingBean.class, bean.getBuildingid());
		if (build == null) {
			getSession().save(bean);
			return bean;
		}
		return null;

	}

	public BuildingBean select(int bulidingID) {
		return getSession().get(BuildingBean.class, bulidingID);
	}

	public List<BuildingBean> selectAll() {
		Query query = session.createQuery("from BuildingBean");
		return (List<BuildingBean>) query.list();
	}
}
