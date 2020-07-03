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
//		country.add("中国");
//
//		province.add("湖南省");
//		province.add("湖北省");
//		province.add("河南省");
//		province.add("河北省");
//		province.add("山东省");
//		province.add("山西省");
//		province.add("江苏省");
//		province.add("吉林省");
//		province.add("辽宁省");
//		province.add("浙江省");
//		province.add("安徽省");
//
//		SceneryDaoImpl sdi = new SceneryDaoImpl();
//
//		for (int i = 11; i < 10100; i++) {
//			String sceneryName = "景点" + i;
//			String sceneryCountry = "中国";
//			String sceneryProvince = province.get((int) (Math.random() * 100) % province.size());
//			String sceneryCity = "city" + i;
//			String sceneryPlace = "place" + i;
//			String sceneryDesc = "SceneryDesc" + i + i + i + i;
//
//			ArrayList<String> path = new ArrayList<String>();
//			path.add("C:\\Users\\沐云\\Desktop\\文档\\天空之境\\1.jpg");
//			path.add("C:\\Users\\沐云\\Desktop\\文档\\天空之境\\2.jpg");
//			path.add("C:\\Users\\沐云\\Desktop\\文档\\天空之境\\3_.jpg");
//
//			Scenery s = new Scenery(sceneryName, sceneryCountry, sceneryProvince, sceneryCity, sceneryPlace,
//					sceneryDesc, path);
//
//			sdi.doCreate(s);
//		}

	}
}
