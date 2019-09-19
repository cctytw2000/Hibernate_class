package model;

import java.util.List;

import org.hibernate.Session;

interface IBuildingDao {

	public Session getSession();

	public BuildingBean insert(BuildingBean bean);

	public BuildingBean select(int bulidingID);

	public List<BuildingBean> selectAll();

	public boolean delete(int bulidingID);

	public BuildingBean update(int bulidingID, String buildingName);
}
