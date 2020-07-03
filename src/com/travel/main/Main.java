package com.travel.main;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.travel.view.SceneryFrame;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceneryFrame frame = new SceneryFrame();
					frame.setFrame(frame);
					frame.setVisible(true);

					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							frame.dispose();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//		SceneryDetailsFrame frame = new SceneryDetailsFrame();
//		frame.setVisible(true);

//		ArrayList<String> country = new ArrayList<String>();
//		ArrayList<String> province = new ArrayList<String>();
//
//		country.add("�й�");
//
//		province.add("����ʡ");
//		province.add("����ʡ");
//		province.add("����ʡ");
//		province.add("�ӱ�ʡ");
//		province.add("ɽ��ʡ");
//		province.add("ɽ��ʡ");
//		province.add("����ʡ");
//		province.add("����ʡ");
//		province.add("����ʡ");
//		province.add("�㽭ʡ");
//		province.add("����ʡ");
//
//		SceneryDaoImpl sdi = new SceneryDaoImpl();
//
//		for (int i = 11; i < 10100; i++) {
//			String sceneryName = "����" + i;
//			String sceneryCountry = "�й�";
//			String sceneryProvince = province.get((int) (Math.random() * 100) % province.size());
//			String sceneryCity = "city" + i;
//			String sceneryPlace = "place" + i;
//			String sceneryDesc = "SceneryDesc" + i + i + i + i;
//
//			ArrayList<String> path = new ArrayList<String>();
//			path.add("C:\\Users\\����\\Desktop\\�ĵ�\\���֮��\\1.jpg");
//			path.add("C:\\Users\\����\\Desktop\\�ĵ�\\���֮��\\2.jpg");
//			path.add("C:\\Users\\����\\Desktop\\�ĵ�\\���֮��\\3_.jpg");
//
//			Scenery s = new Scenery(sceneryName, sceneryCountry, sceneryProvince, sceneryCity, sceneryPlace,
//					sceneryDesc, path);
//
//			sdi.doCreate(s);
//		}

	}
}
