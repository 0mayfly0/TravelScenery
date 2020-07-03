package com.travel.dao;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.travel.vo.Scenery;

/**
 * 	����Scenery�����ݲ������׼
 * @author ����
 */
public interface SceneryDao {
	/**
	 * 	���ݵ����Ӳ�����ִ�е���INSERT��䡣
	 * @param s	������Ҫ���ӵ�������Ϣ��
	 * @return	����������ӳɹ�����true�����򷵻�false��
	 */
	public boolean doCreate(Scenery s); // ����һ������

	/**
	 * 	���ݵ��޸Ĳ�����ִ�е���UPDATE��䣬���ε��޸Ļ����id�����ֻ��������ݽ��и��ġ�
	 * @param s	������Ҫ�޸ĵ���Ϣ��
	 * @return	�����޸ĳɹ�����true�����򷵻�false��
	 */
	public boolean doUpdate(Scenery s); // ����һ������

	/**
	 * 	���ݵ�ɾ�����������ݸ�����id��ɾ��ָ�������ݡ�
	 * @param id Ҫɾ�������ݵ�id�š�
	 * @return	����ɾ���ɹ�����true�����򷵻�false��
	 */
	public boolean doRemove(Integer id); // �Ƴ�һ������

	/**
	 * 	���ݵĲ�ѯ���������ݸ�����id����ѯָ�������ݡ�
	 * @param id Ҫ��ѯ�����ݵ�id
	 * @return	����һ��Scenery���ݣ��������Ҫ��ѯ�����ݣ����û�в�ѯ������Scenery����ΪĬ����Ϣ��
	 */
	public Scenery findById(Integer id); // Ѱ��ĳ��id

	/**
	 * 	���ݵĲ�ѯ��������ѯ���ݿ��е��������ݡ�
	 * @return	��Ҫ��ѯ�����ݷ���һ��Vector������ء�
	 */
	public Vector findAll(); // Ѱ������

	/**
	 * 	���ݵ�ɸѡ�����������ϲ㴫������Ϣ����ģ��ɸѡ��
	 * @param name Ҫ��ѯ�ľ������ơ�
	 * @param countryҪ��ѯ�ľ������ڹ��ҡ�
	 * @param province Ҫ��ѯ�ľ�������ʡ�ݡ�
	 * @param city Ҫ��ѯ�ľ������ڳ��С�
	 * @return ���ز�ѯ���Ľ����
	 */
	public Vector scenerySift(String name, String country, String province, String city); // ɸѡ
}
