package com.travel.dbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 	本类负责数据库的连接操作，在进行本类对象实例化时自动进行数据库的连接处理。
 * @author 沐云
 */
public class DatabaseConnection {
	private static final String path = "src/jdbc.properties";
	private static String DBDRIVER = null;
	private static String DBURL = null;
	private static String DBUSER = null;
	private static String PASSWORD = null;
	private Connection conn = null;
	
	static {
		Properties pro = new Properties();
		
		try {
			pro.load(new FileReader(path));
			
			DBDRIVER = pro.getProperty("driverClassName");
			DBURL = pro.getProperty("url");
			DBUSER = pro.getProperty("user");
			PASSWORD = pro.getProperty("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	在构造方法调用时将进行数据库连接对象的取得。
	 */
	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER);// 1. 加载驱动程序
			this.conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);// 2. 与数据库建立连接
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	得到数据库的连接对象。
	 * @return 返回数据库的连接对象。
	 */
	public Connection getConnection() {
		return this.conn;
	}
	
	/**
	 * 	关闭数据库的连接。
	 */
	public void close() {
		if(this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
