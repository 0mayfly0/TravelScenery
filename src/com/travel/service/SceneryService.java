package com.travel.service;

import java.util.Vector;
import com.travel.vo.Scenery;

/**
 * 	����Scenery��ҵ��������׼
 * @author ����
 */
public interface SceneryService {
	/**
	 * 	ʵ�־������ݵ����Ӳ������ڱ�����֮����Ҫʹ��SceneryDao�ӿ��еķ�����
	 * @param s	������Ҫ�������ݵ�Scenery�����
	 * @return	�������ӳɹ�����true�����򷵻�false��
	 */
	public boolean insert(Scenery s); 	//����һ������
	
	/**
	 * 	ʵ�־������ݵ��޸Ĳ������ڱ�����֮����Ҫʹ��SceneryDao�ӿ��еķ�����
	 * @param s	������Ҫ�޸����ݵ�Scenery�����
	 * @return	�������ӳɹ�����true�����򷵻�false��
	 */
	public boolean update(Scenery s);	//����һ������
	
	/**
	 * 	ʵ�־������ݵ��Ƴ��������ڱ�����֮����Ҫʹ��SceneryDao�ӿ��еķ�����
	 * @param id ������Ҫ�Ƴ����ݵ�id��
	 * @return	�������ӳɹ�����true�����򷵻�false��
	 */
	public boolean remove(Integer id);	//�Ƴ�һ������
	
	/**
	 * 	ʵ�־������ݵĲ�ѯ�������ڱ�����֮����Ҫʹ��SceneryDao�ӿ��еķ�����
	 * @param id ������Ҫ��ѯ�����ݵ�id��
	 * @return ��ѯ�ɹ��򷵻�һ��Scenery���󣬷��򷵻�null��
	 */
	public Scenery query(Integer id);	//��ѯĳ��id����
	
	/**
	 * 	ʵ�־������ݵĲ�ѯ��������ѯ���ݿ������о������Ϣ��
	 * @return	�������ݿ������о������Ϣ��
	 */
	public Vector queryAll();			//��ѯ��������
	
	/**
	 * 	ʵ�־������ݵ�ɸѡ������ɸѡ���ݿ��е���Ϣ��
	 * @param name Ҫɸѡ�ľ������ơ�
	 * @param country Ҫɸѡ�ľ������ڹ��ҡ�
	 * @param province Ҫɸѡ�ľ�������ʡ�ݡ�
	 * @param city Ҫɸѡ�ľ������ڳ��С�
	 * @return ����ɸѡ������Ϣ��
	 */
	public Vector scenerySift(String name, String country, String province, String city);		//ɸѡ����
}
