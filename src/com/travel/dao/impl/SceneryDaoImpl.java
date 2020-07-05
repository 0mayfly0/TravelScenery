package com.travel.dao.impl;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;
import com.travel.dao.SceneryDao;
import com.travel.dbc.DatabaseConnection;
import com.travel.vo.Scenery;

/**
 * 	该类是数据层的实现类。
 * @author 沐云
 */
public class SceneryDaoImpl implements SceneryDao {
	private Connection conn;
	private PreparedStatement psScenery;
	private PreparedStatement psAddress;
	private PreparedStatement psPic;

	/**
	 * 	实例化数据层子类对象
	 */
	public SceneryDaoImpl() {
		try {
			this.conn = new DatabaseConnection().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean doCreate(Scenery s) {
		try {
			String sql = "insert into t_scenery(scenery_name,scenery_desc) values(?,?)";
			psScenery = conn.prepareStatement(sql);
			psScenery.setString(1, s.getSceneryName());
			psScenery.setString(2, s.getSceneryDesc());
			psScenery.executeUpdate();

			sql = "select scenery_id from t_scenery where scenery_name='" + s.getSceneryName() + "' and scenery_desc='"
					+ s.getSceneryDesc() + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);

			rs.next();
			String strId = String.valueOf(rs.getString(1));

			sql = "insert into t_address(address_id,address_country,address_province,address_city,address_place) values(?,?,?,?,?)";
			psAddress = conn.prepareStatement(sql);
			psAddress.setInt(1, Integer.parseInt(strId));
			psAddress.setString(2, s.getSceneryCountry());
			psAddress.setString(3, s.getSceneryProvince());
			psAddress.setString(4, s.getSceneryCity());
			psAddress.setString(5, s.getSceneryAddress());
			psAddress.executeUpdate();

			sql = "insert into t_pic(pic_id,pic_path) values(?,?)";
			psPic = conn.prepareStatement(sql);
			for (String strPath : s.getSceneryPic()) {
				psPic.setInt(1, Integer.parseInt(strId));
				psPic.setString(2, strPath);
				psPic.executeUpdate();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "创建失败");
			e.printStackTrace();
			return false;
		} finally {
			return true;
		}
	}

	public boolean doUpdate(Scenery s) {
		try {
			String sql1 = "update t_scenery set scenery_name=?,scenery_desc=? where scenery_id = '"
					+ s.getSceneryNumber() + "'";
			String sql2 = "update t_address set address_country=?,address_province=?,address_city=?,address_place=? where address_id = '"
					+ s.getSceneryNumber() + "'";
			String sql3 = "update t_pic set pic_path=? where pic_id = '" + s.getSceneryNumber() + "'";

			psScenery = conn.prepareStatement(sql1);
			psAddress = conn.prepareStatement(sql2);
			psPic = conn.prepareStatement(sql3);

			psScenery.setString(1, s.getSceneryName());
			psScenery.setString(2, s.getSceneryDesc());
			psScenery.executeUpdate();

			psAddress.setString(1, s.getSceneryCountry());
			psAddress.setString(2, s.getSceneryProvince());
			psAddress.setString(3, s.getSceneryCity());
			psAddress.setString(4, s.getSceneryAddress());
			psAddress.executeUpdate();
			

			psPic = conn.prepareStatement("delete from t_pic where pic_id = '"+s.getSceneryNumber()+"'");
			psPic.executeUpdate("delete from t_pic where pic_id = '"+s.getSceneryNumber()+"'");
			
			psPic = conn.prepareStatement("insert into t_pic(pic_id,pic_path) values(?,?)");
			for (String strPath : s.getSceneryPic()) {
				psPic.setInt(1, s.getSceneryNumber());
				psPic.setString(2, strPath);
				psPic.executeUpdate();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, " 修改失败");
			e.printStackTrace();
			return false;
		} finally {
			return true;
		}
	}

	public boolean doRemove(Integer id) {
		try {
			String sql = "delete from t_scenery where scenery_id='" + id + "'";
			psScenery = conn.prepareStatement(sql);

			psScenery.executeUpdate(sql);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "删除失败");
			e.printStackTrace();
			return false;
		} finally {
			return true;
		}
	}

	public Scenery findById(Integer id) {
		Scenery scenery = new Scenery();
		try {
			String sql = "select * from t_pic where pic_id='" + id + "'";
			psScenery = conn.prepareStatement("select * from t_scenery where scenery_id = '" + id + "'");
			psAddress = conn.prepareStatement("select * from t_address where address_id = '" + id + "'");
			psPic = conn.prepareStatement(sql);

			ResultSet rsScenery = psScenery.executeQuery();
			ResultSet rsAddress = psAddress.executeQuery();
			ResultSet rsPic = psPic.executeQuery();

			rsScenery.next();
			scenery.setSceneryName(rsScenery.getString(2));
			scenery.setSceneryDesc(rsScenery.getString(3));

			rsAddress.next();
			scenery.setSceneryCountry(rsAddress.getString(2));
			scenery.setSceneryProvince(rsAddress.getString(3));
			scenery.setSceneryCity(rsAddress.getString(4));
			scenery.setSceneryAddress(rsAddress.getString(5));

			ArrayList<String> sceneryPath = new ArrayList<String>();
			while (rsPic.next() && rsPic.getRow() > 0) {
				sceneryPath.add(String.valueOf(rsPic.getString(2)));
			}
			if (sceneryPath.size() > 0) {
				scenery.setSceneryPic(sceneryPath);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "查询失败");
			e.printStackTrace();
			return null;
		} finally {
			return scenery;
		}
	}

	public Vector findAll() {
		Vector vector = null;
		try {
			vector = new Vector();
			psScenery = conn.prepareStatement("select * from t_scenery");
			ResultSet rsScenery = psScenery.executeQuery();

			while (rsScenery.next() && rsScenery.getRow() > 0) {
				Vector row = new Vector();
				String addressId = null;
				for (int col = 1; col <= rsScenery.getMetaData().getColumnCount(); col++) {
					// 因为id是int类型，需要用if进行判断
					if (col == 1) {
						addressId = String.valueOf(rsScenery.getInt(col));
						row.add(addressId);
					} else {
						row.add(String.valueOf(rsScenery.getString(col)));

						if (col == 2) {
							psAddress = conn
									.prepareStatement("select * from t_address where address_id = '" + addressId + "'");
							ResultSet rsAddress = psAddress.executeQuery();

							while (rsAddress.next() && rsAddress.getRow() > 0) {
								for (int i = 2; i <= rsAddress.getMetaData().getColumnCount(); i++) {
									row.add(String.valueOf(rsAddress.getString(i)));
								}
							}
						}
					}
				}
				vector.add(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "查询失败");
			e.printStackTrace();
			return null;
		} finally {
			return vector;
		}
	}

	public Vector scenerySift(String name, String country, String province, String city) {
		Vector vector = null;
		try {
			vector = new Vector();
			psScenery = conn.prepareStatement("select * from t_scenery where scenery_name like \"%" + name + "%\"");
			ResultSet rsScenery = psScenery.executeQuery();

			while (rsScenery.next() && rsScenery.getRow() > 0) {
				Vector row = new Vector();
				String addressId = null;
				for (int col = 1; col <= rsScenery.getMetaData().getColumnCount(); col++) {
					// 因为id是int类型，需要用if进行判断
					if (col == 1) {
						addressId = String.valueOf(rsScenery.getInt(col));
					} else if (col == 2) {
						name = String.valueOf(rsScenery.getString(col));

						String sql = "select * from t_address where address_id = '" + addressId
								+ "' and address_country like \"%" + country + "%\" and address_province like \"%"
								+ province + "%\" and address_city like \"%" + city + "%\"";
						psAddress = conn.prepareStatement(sql);
						ResultSet rsAddress = psAddress.executeQuery();

						while (rsAddress.next() && rsAddress.getRow() > 0) {
							row.add(addressId);
							row.add(name);
							for (int i = 2; i <= rsAddress.getMetaData().getColumnCount(); i++) {
								row.add(String.valueOf(rsAddress.getString(i)));
							}
							col++;
							row.add(String.valueOf(rsScenery.getString(col)));
							vector.add(row);
						}
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "筛选失败");
			e.printStackTrace();
			return null;
		} finally {
			return vector;
		}
	}

}
