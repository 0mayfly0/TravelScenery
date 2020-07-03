package com.travel.service;

import java.util.Vector;
import com.travel.vo.Scenery;

/**
 * 	定义Scenery得业务层操作标准
 * @author 沐云
 */
public interface SceneryService {
	/**
	 * 	实现景点数据的增加操作，在本操作之中需要使用SceneryDao接口中的方法。
	 * @param s	包含了要增加数据的Scenery类对象。
	 * @return	数据增加成功返回true，否则返回false。
	 */
	public boolean insert(Scenery s); 	//插入一条数据
	
	/**
	 * 	实现景点数据的修改操作，在本操作之中需要使用SceneryDao接口中的方法。
	 * @param s	包含了要修改数据的Scenery类对象。
	 * @return	数据增加成功返回true，否则返回false。
	 */
	public boolean update(Scenery s);	//更新一条数据
	
	/**
	 * 	实现景点数据的移除操作，在本操作之中需要使用SceneryDao接口中的方法。
	 * @param id 包含了要移除数据的id。
	 * @return	数据增加成功返回true，否则返回false。
	 */
	public boolean remove(Integer id);	//移除一条数据
	
	/**
	 * 	实现景点数据的查询操作，在本操作之中需要使用SceneryDao接口中的方法。
	 * @param id 包含了要查询的数据的id。
	 * @return 查询成功则返回一个Scenery对象，否则返回null。
	 */
	public Scenery query(Integer id);	//查询某个id数据
	
	/**
	 * 	实现景点数据的查询操作，查询数据库中所有景点的信息。
	 * @return	返回数据库中所有景点的信息。
	 */
	public Vector queryAll();			//查询所有数据
	
	/**
	 * 	实现景点数据的筛选操作，筛选数据库中的信息。
	 * @param name 要筛选的景点名称。
	 * @param country 要筛选的景点所在国家。
	 * @param province 要筛选的景点所在省份。
	 * @param city 要筛选的景点所在城市。
	 * @return 返回筛选到的信息。
	 */
	public Vector scenerySift(String name, String country, String province, String city);		//筛选数据
}
