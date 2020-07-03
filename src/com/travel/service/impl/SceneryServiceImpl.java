package com.travel.service.impl;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Vector;
import com.travel.service.SceneryService;
import com.travel.vo.Scenery;

/**
 * 业务层的实现类，当取得了本类对象时，就意味着可以进行数据库操作了。
 * 
 * @author 沐云
 */
public class SceneryServiceImpl implements SceneryService {
	private static final String classPath = "src/serviceClass.properties";
	
	@Override
	public boolean insert(Scenery s) {
		Properties prop = new Properties();

		try {
			FileReader fr = new FileReader(classPath);
			prop.load(fr);
			fr.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String className = prop.getProperty("className");
		String methodName = prop.getProperty("insertMethod");

		try {
			Class c = Class.forName(className);

			Constructor con = c.getConstructor();
			Object obj = con.newInstance();

			Method m = c.getMethod(methodName, s.getClass());

			return (boolean) m.invoke(obj, s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Scenery s) {
		Properties prop = new Properties();

		try {
			FileReader fr = new FileReader(classPath);
			prop.load(fr);
			fr.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String className = prop.getProperty("className");
		String methodName = prop.getProperty("updateMethod");

		try {
			Class c = Class.forName(className);

			Constructor con = c.getConstructor();
			Object obj = con.newInstance();

			Method m = c.getMethod(methodName, s.getClass());

			return (boolean) m.invoke(obj, s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(Integer id) {
		Properties prop = new Properties();

		try {
			FileReader fr = new FileReader(classPath);
			prop.load(fr);
			fr.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String className = prop.getProperty("className");
		String methodName = prop.getProperty("removeMethod");

		try {
			Class c = Class.forName(className);

			Constructor con = c.getConstructor();
			Object obj = con.newInstance();

			Method m = c.getMethod(methodName, id.getClass());

			return (boolean) m.invoke(obj, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Scenery query(Integer id) {
		Properties prop = new Properties();

		try {
			FileReader fr = new FileReader(classPath);
			prop.load(fr);
			fr.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String className = prop.getProperty("className");
		String methodName = prop.getProperty("queryMethod");

		try {
			Class c = Class.forName(className);

			Constructor con = c.getConstructor();
			Object obj = con.newInstance();

			Method m = c.getMethod(methodName, id.getClass());

			return (Scenery) m.invoke(obj, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Vector queryAll() {
		Properties prop = new Properties();

		try {
			FileReader fr = new FileReader(classPath);
			prop.load(fr);
			fr.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String className = prop.getProperty("className");
		String methodName = prop.getProperty("queryAllMethod");

		try {
			Class c = Class.forName(className);

			Constructor con = c.getConstructor();
			Object obj = con.newInstance();

			Method m = c.getMethod(methodName);

			return (Vector) m.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Vector scenerySift(String name, String country, String province, String city) {
		Properties prop = new Properties();

		try {
			FileReader fr = new FileReader(classPath);
			prop.load(fr);
			fr.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String className = prop.getProperty("className");
		String methodName = prop.getProperty("scenerySifgMethod");

		try {
			Class c = Class.forName(className);

			Constructor con = c.getConstructor();
			Object obj = con.newInstance();

			Method m = c.getMethod(methodName, name.getClass(),country.getClass(),province.getClass(),city.getClass());

			return (Vector) m.invoke(obj, name,country,province,city);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
