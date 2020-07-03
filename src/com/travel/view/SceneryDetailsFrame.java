package com.travel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.travel.vo.Scenery;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import java.awt.FlowLayout;

public class SceneryDetailsFrame extends JFrame {
	private Scenery scenery;
	private ArrayList<String> sceneryPic = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ImagePanel panel = null;

	/**
	 * Create the frame.
	 */
	public SceneryDetailsFrame(Scenery scenery) {
		this.scenery = scenery;

		this.setTitle("详细信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 250, 948, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);
		
		if (this.scenery.getSceneryPic() != null && scenery.getSceneryPic().size() > 1) {
			panel = new ImagePanel(this.scenery.getSceneryPic());
			panel.setBounds(0, 44, 516, 688);
			contentPane.add(panel);
			panel.setLayout(null);
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(515, 5, 415, 727);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("\u666F\u70B9\u540D\u79F0\uFF1A");
		label.setBounds(37, 93, 75, 18);
		panel_1.add(label);

		JLabel label_1 = new JLabel("\u6240\u5728\u56FD\u5BB6\uFF1A");
		label_1.setBounds(37, 124, 75, 18);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("\u6240\u5728\u7701\u5E02\uFF1A");
		label_2.setBounds(37, 155, 75, 18);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("\u57CE\u5E02\u540D\u79F0\uFF1A");
		label_3.setBounds(37, 186, 75, 18);
		panel_1.add(label_3);

		JLabel label_3_1 = new JLabel("\u666F\u70B9\u7F16\u53F7\uFF1A");
		label_3_1.setBounds(37, 62, 75, 18);
		panel_1.add(label_3_1);

		textField = new JTextField();
		textField.setBounds(112, 59, 259, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(scenery.getSceneryNumber()));

		textField_1 = new JTextField();
		textField_1.setBounds(112, 90, 259, 24);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(scenery.getSceneryName());

		textField_2 = new JTextField();
		textField_2.setBounds(112, 124, 259, 24);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(scenery.getSceneryCountry());

		textField_3 = new JTextField();
		textField_3.setBounds(112, 155, 259, 24);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(scenery.getSceneryProvince());

		textField_4 = new JTextField();
		textField_4.setBounds(112, 186, 259, 24);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(scenery.getSceneryCity());

		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(112, 223, 259, 71);
		panel_1.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setText(scenery.getSceneryAddress());

		JTextArea textArea_1 = new JTextArea();
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		scrollPane_1.setBounds(112, 307, 259, 197);
		panel_1.add(scrollPane_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textArea_1.setText(scenery.getSceneryDesc());

		JLabel label_3_2 = new JLabel("\u5177\u4F53\u5730\u5740\uFF1A");
		label_3_2.setBounds(37, 217, 75, 18);
		panel_1.add(label_3_2);

		JLabel label_3_2_1 = new JLabel("\u666F\u70B9\u63CF\u8FF0\uFF1A");
		label_3_2_1.setBounds(37, 307, 75, 18);
		panel_1.add(label_3_2_1);

		JButton btnNewButton = new JButton("\u4E0B\u4E00\u5F20");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (scenery.getSceneryPic() != null && scenery.getSceneryPic().size() > 1) {
					panel.setNum((panel.getNum() + 1) % scenery.getSceneryPic().size());
					panel.repaint();
				}
			}
		});
		btnNewButton.setBounds(14, 432, 77, 27);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u4E0A\u4E00\u5F20");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (scenery.getSceneryPic() != null && scenery.getSceneryPic().size() > 1) {
					if(panel.getNum() == 0) {
						panel.setNum(scenery.getSceneryPic().size() - 1);
					} else {
						panel.setNum(panel.getNum()-1);
					}
					
					panel.repaint();
				}
			}
		});
		btnNewButton_1.setBounds(14, 374, 77, 27);
		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("\u666F\u70B9\u56FE\u7247\u9884\u89C8");
		lblNewLabel.setBounds(168, 13, 132, 18);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 20));
	}
}

/**
 * 面板中打开图片
 */
class ImagePanel extends JPanel {
	private Image image;
	private int num = 0;
	private ArrayList<String> path;

	public ImagePanel(ArrayList<String> path) {
		this.path = path;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 我需要他的宽是固定，高跟随他自己的情况。
		try {
			image = ImageIO.read(new File(path.get(num % path.size())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, 5, 5, 500, image.getHeight(null) * 500 / image.getWidth(null), null);
	}
}
