package com.travel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.travel.dao.impl.SceneryDaoImpl;
import com.travel.service.impl.SceneryServiceImpl;
import com.travel.vo.Scenery;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SceneryUpdateFrame extends JFrame {

	private JPanel contentPane;

	private static SceneryUpdateFrame suf = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea textArea_2;
	private JTextField textField_4;

	public static synchronized SceneryUpdateFrame getInstance(Scenery scenery) {
		if (suf == null) {
			suf = new SceneryUpdateFrame(scenery);
		}
		return suf;
	}

	/**
	 * Create the frame.
	 */
	private SceneryUpdateFrame(Scenery scenery) {
		setTitle("\u4FEE\u6539\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 882, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField(scenery.getSceneryName());
		textField.setBounds(199, 13, 240, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("\u666F\u70B9\u540D\u79F0:");
		label.setBounds(113, 16, 72, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u56FD\u5BB6:");
		label_1.setBounds(113, 53, 72, 18);
		contentPane.add(label_1);

		textField_1 = new JTextField(scenery.getSceneryCountry());
		textField_1.setColumns(10);
		textField_1.setBounds(199, 50, 240, 24);
		contentPane.add(textField_1);

		JLabel label_2 = new JLabel("\u7701\u4EFD:");
		label_2.setBounds(113, 87, 72, 18);
		contentPane.add(label_2);

		textField_2 = new JTextField(scenery.getSceneryProvince());
		textField_2.setColumns(10);
		textField_2.setBounds(199, 84, 240, 24);
		contentPane.add(textField_2);

		JLabel label_3 = new JLabel("\u57CE\u5E02:");
		label_3.setBounds(113, 124, 72, 18);
		contentPane.add(label_3);

		textField_3 = new JTextField(scenery.getSceneryCity());
		textField_3.setColumns(10);
		textField_3.setBounds(199, 121, 240, 24);
		contentPane.add(textField_3);

		JLabel label_3_1 = new JLabel("\u5177\u4F53\u5730\u5740:");
		label_3_1.setBounds(113, 161, 72, 18);
		contentPane.add(label_3_1);

		JTextArea textArea_1 = new JTextArea(scenery.getSceneryDesc());
		JScrollPane jslp_1 = new JScrollPane(textArea_1);
		jslp_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jslp_1.setBounds(199, 209, 582, 118);
		contentPane.add(jslp_1);
		
		StringBuffer str = new StringBuffer("");
		ArrayList<String> array = scenery.getSceneryPic();
		for(int i = 0;i<array.size()-1;i++) {
			str.append(array.get(i)+"\r\n");
		}
		str.append(array.get(array.size()-1));
		
		textArea_2 = new JTextArea(str.toString());
		JScrollPane jslp_2 = new JScrollPane(textArea_2);
		jslp_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jslp_2.setBounds(199, 348, 582, 118);
		contentPane.add(jslp_2);

		JLabel label_3_1_1_1 = new JLabel("\u56FE\u7247\u8DEF\u5F84:");
		label_3_1_1_1.setBounds(113, 351, 72, 18);
		contentPane.add(label_3_1_1_1);

		JLabel label_3_1_1 = new JLabel("\u666F\u70B9\u63CF\u8FF0:");
		label_3_1_1.setBounds(113, 212, 72, 18);
		contentPane.add(label_3_1_1);

		JButton button = new JButton("\u6DFB\u52A0\u56FE\u7247");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importPic();
			}
		});
		button.setBounds(266, 491, 113, 27);
		contentPane.add(button);
		
		textField_4 = new JTextField(scenery.getSceneryAddress());
		textField_4.setColumns(10);
		textField_4.setBounds(199, 161, 582, 24);
		contentPane.add(textField_4);

		JButton button_1 = new JButton("\u63D0\u4EA4\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SceneryServiceImpl ssi = new SceneryServiceImpl();
				ArrayList<String> path = new ArrayList<String>();
				
				String sceneryName = textField.getText().trim();
				String sceneryCountry = textField_1.getText().trim();
				String sceneryProvince = textField_2.getText().trim();
				String sceneryCity = textField_3.getText().trim();
				String sceneryPlace = textField_4.getText().trim();
				String sceneryDesc = textArea_1.getText().trim();
				String sceneryPic = textArea_2.getText().trim();
				
				String[] strPath = sceneryPic.split("\r\n");
				for(int i = 0;i<strPath.length;i++) {
					path.add(strPath[i]);
				}
				
				Scenery s = new Scenery(sceneryName,sceneryCountry,sceneryProvince,sceneryCity,sceneryPlace,sceneryDesc,path);
				s.setSceneryNumber(scenery.getSceneryNumber());
				ssi.update(s);
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textArea_1.setText("");
				textArea_2.setText("");
				
				SceneryUpdateFrame.this.dispose();
				SceneryFrame.frame.setVisible(true);
				SceneryFrame.initInformation();
			}
		});
		button_1.setBounds(469, 491, 113, 27);
		contentPane.add(button_1);
	}

	public void importPic() {
		JFileChooser chooser = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String pathName = chooser.getSelectedFile().getPath();
			if(!textArea_2.getText().equals(""))
				textArea_2.setText(textArea_2.getText()+"\r\n"+pathName);
			else {
				textArea_2.setText(pathName);
			}
			String pathFolder = chooser.getSelectedFile().getParent();
		}
	}
}
