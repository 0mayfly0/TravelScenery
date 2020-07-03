package com.travel.dbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 	���ฺ�����ݿ�����Ӳ������ڽ��б������ʵ����ʱ�Զ��������ݿ�����Ӵ���
 * @author ����
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
	 * 	�ڹ��췽������ʱ���������ݿ����Ӷ����ȡ�á�
	 */
	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER);// 1. ������������
			this.conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);// 2. �����ݿ⽨������
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	�õ����ݿ�����Ӷ���
	 * @return �������ݿ�����Ӷ���
	 */
	public Connection getConnection() {
		return this.conn;
	}
	
	/**
	 * 	�ر����ݿ�����ӡ�
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
