package com.travel.dao;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.travel.vo.Scenery;

/**
 * 	定义Scenery得数据层操作标准
 * @author 沐云
 */
public interface SceneryDao {
	/**
	 * 	数据的增加操作，执行的是INSERT语句。
	 * @param s	包含了要增加的数据信息。
	 * @return	如果数据增加成功返回true，否则返回false。
	 */
	public boolean doCreate(Scenery s); // 创建一条数据

	/**
	 * 	数据的修改操作，执行的是UPDATE语句，本次的修改会根据id将部分或所有数据进行更改。
	 * @param s	包含了要修改的信息。
	 * @return	数据修改成功返回true，否则返回false。
	 */
	public boolean doUpdate(Scenery s); // 更新一条数据

	/**
	 * 	数据的删除操作，根据给定的id，删除指定的数据。
	 * @param id 要删除的数据的id号。
	 * @return	数据删除成功返回true，否则返回false。
	 */
	public boolean doRemove(Integer id); // 移除一条数据

	/**
	 * 	数据的查询操作，根据给定的id，查询指定的数据。
	 * @param id 要查询的数据的id
	 * @return	返回一个Scenery数据，里面包含要查询的内容，如果没有查询到，则Scenery里面为默认信息。
	 */
	public Scenery findById(Integer id); // 寻找某个id

	/**
	 * 	数据的查询操作，查询数据库中的所有数据。
	 * @return	将要查询的数据放在一个Vector里，并返回。
	 */
	public Vector findAll(); // 寻找所有

	/**
	 * 	数据的筛选操作，根据上层传来的信息进行模糊筛选。
	 * @param name 要查询的景点名称。
	 * @param country要查询的景点所在国家。
	 * @param province 要查询的景点所在省份。
	 * @param city 要查询的景点所在城市。
	 * @return 返回查询到的结果。
	 */
	public Vector scenerySift(String name, String country, String province, String city); // 筛选
}
