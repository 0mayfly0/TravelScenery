package com.travel.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.travel.dao.impl.SceneryDaoImpl;
import com.travel.service.impl.SceneryServiceImpl;
import com.travel.vo.Scenery;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;

public class SceneryFrame extends JFrame {
	private JPanel contentPane;
	private final JTextField f1;
	private final JTextField f2;
	private final JTextField f3;
	public static JFrame frame;

	JButton b1 = new JButton("\u7B5B\u9009");
	JButton b2 = new JButton("修改");
	JButton b3 = new JButton("删除");
	JButton b5 = new JButton("添加");
	JButton b6 = new JButton("查看详情");

	public final static JTable table = new JTable();

	public static Vector<String> title;
	public static Vector allValue;
	private JTextField textField;
	
	public static void initInformation() {
		SceneryServiceImpl ssi = new SceneryServiceImpl();
		allValue = ssi.queryAll();
		final DefaultTableModel model = new DefaultTableModel(allValue, title);
		table.setModel(model);
	}
	
	public void setFrame(SceneryFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the frame.
	 */
	public SceneryFrame() {
		this.setTitle("景点管理模块");
		this.setLocation(400, 200);
		this.setSize(1120, 745);
		getContentPane().setLayout(null);
		JLabel j1 = new JLabel("\u56FD\u5BB6\uFF1A");
		j1.setBounds(272, 18, 54, 18);
		JLabel j2 = new JLabel("\u7701\u4EFD\uFF1A");
		j2.setBounds(436, 18, 54, 18);
		JLabel j3 = new JLabel("\u57CE\u5E02\uFF1A");
		j3.setBounds(605, 18, 46, 18);
		f1 = new JTextField(4);
		f1.setBounds(321, 15, 101, 24);
		f2 = new JTextField(4);
		f2.setBounds(490, 15, 101, 24);
		f3 = new JTextField(4);
		f3.setBounds(652, 15, 101, 24);
		JPanel panel2 = new JPanel();
		panel2.setBounds(89, 102, 923, 41);
		JPanel panel3 = new JPanel();
		panel3.setBounds(116, 156, 863, 529);
		getContentPane().setLayout(null);
		panel3.setLayout(null);
		b2.setBounds(382, 5, 63, 27);
		panel3.add(b2);
		b3.setBounds(305, 5, 63, 27);
		panel3.add(b3);
		b5.setBounds(228, 5, 63, 27);
		panel3.add(b5);
		b6.setBounds(459, 5, 93, 27);
		panel3.add(b6);
		getContentPane().add(panel3);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(27, 45, 809, 444);
		panel3.add(scrollPane);
		title = new Vector<String>();
		title.add("编号");
		title.add("景点名称 ");
		title.add("国家");
		title.add("省份");
		title.add("城市");
		title.add("地址");
		title.add("景点介绍");

		SceneryFrame.initInformation();

		// 修改按钮的事件
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();// 获取你选中的行号（记录）
				
				if (count != -1) {
					Integer sceneryId = Integer.valueOf(table.getValueAt(count, 0).toString());
					String sceneryName = String.valueOf(table.getValueAt(count, 1).toString());
					String country = String.valueOf(table.getValueAt(count, 2).toString());
					String province = String.valueOf(table.getValueAt(count, 3).toString());
					String city = String.valueOf(table.getValueAt(count, 4).toString());
					String address = String.valueOf(table.getValueAt(count, 5).toString());
					String sceneryDesc = String.valueOf(table.getValueAt(count, 6).toString());
					
					SceneryServiceImpl ssi = new SceneryServiceImpl();
					Scenery scenery = ssi.query(sceneryId);

					scenery.setSceneryNumber(sceneryId);
					scenery.setSceneryName(sceneryName);
					scenery.setSceneryCountry(country);
					scenery.setSceneryProvince(province);
					scenery.setSceneryCity(city);
					scenery.setSceneryAddress(address);
					scenery.setSceneryDesc(sceneryDesc);
					
					SceneryUpdateFrame suf = SceneryUpdateFrame.getInstance(scenery);
					frame.setVisible(false);
					suf.setVisible(true);

					suf.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							suf.dispose();
							frame.setVisible(true);
						}
					});
				}
			}
		});

		// 删除按钮事件
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();// 获取你选中的行号（记录）

				if (count != -1) {
					Integer sceneryId = Integer.valueOf(table.getValueAt(count, 0).toString());

					new SceneryServiceImpl().remove(sceneryId);
					SceneryFrame.initInformation();
				}
			}
		});

		// 添加按钮的事件
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SceneryAddFrame saf = SceneryAddFrame.getInstance();
				frame.setVisible(false);
				saf.setVisible(true);

				saf.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						saf.dispose();
						frame.setVisible(true);
					}
				});
			}
		});

		// 详细信息按钮的事件
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = table.getSelectedRow();// 获取你选中的行号（记录）

				if (count != -1) {
					Integer sceneryId = Integer.valueOf(table.getValueAt(count, 0).toString());
					String sceneryName = String.valueOf(table.getValueAt(count, 1).toString());
					String country = String.valueOf(table.getValueAt(count, 2).toString());
					String province = String.valueOf(table.getValueAt(count, 3).toString());
					String city = String.valueOf(table.getValueAt(count, 4).toString());
					String address = String.valueOf(table.getValueAt(count, 5).toString());
					String sceneryDesc = String.valueOf(table.getValueAt(count, 6).toString());

					SceneryServiceImpl ssi = new SceneryServiceImpl();
					Scenery scenery = ssi.query(sceneryId);

					scenery.setSceneryNumber(sceneryId);
					scenery.setSceneryName(sceneryName);
					scenery.setSceneryCountry(country);
					scenery.setSceneryProvince(province);
					scenery.setSceneryCity(city);
					scenery.setSceneryAddress(address);
					scenery.setSceneryDesc(sceneryDesc);

					SceneryDetailsFrame sdf = new SceneryDetailsFrame(scenery);
					frame.setVisible(false);
					sdf.setVisible(true);

					sdf.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							sdf.dispose();
							frame.setVisible(true);
						}
					});
				}

			}
		});
		panel2.setLayout(null);
		panel2.add(j1);
		panel2.add(f1);
		panel2.add(j2);
		panel2.add(f2);
		panel2.add(j3);
		panel2.add(f3);
		this.setResizable(true); // 设置不可以变大
		getContentPane().add(panel2);
		
		//筛选
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String country = f1.getText();
				String province = f2.getText();
				String city = f3.getText();
				
				Vector value = new SceneryServiceImpl().scenerySift(name, country, province, city);
				final DefaultTableModel model = new DefaultTableModel(value,title);
				table.setModel(model);
				
				
				textField.setText("");
				f1.setText("");
				f2.setText("");
				f3.setText("");
			}
		});
		b1.setBounds(767, 14, 63, 27);
		panel2.add(b1);
		
		JLabel j1_1 = new JLabel("\u540D\u79F0\uFF1A");
		j1_1.setBounds(108, 18, 54, 18);
		panel2.add(j1_1);
		
		textField = new JTextField(4);
		textField.setBounds(159, 14, 101, 24);
		panel2.add(textField);
		
		JButton b1_1 = new JButton("\u8FD8\u539F");
		b1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final DefaultTableModel model = new DefaultTableModel(allValue, title);
				table.setModel(model);
			}
		});
		b1_1.setBounds(844, 14, 63, 27);
		panel2.add(b1_1);

		this.setVisible(true);
	}
}
