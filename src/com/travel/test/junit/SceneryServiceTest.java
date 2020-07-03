package com.travel.test.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.travel.service.impl.SceneryServiceImpl;
import com.travel.vo.Scenery;

import junit.framework.TestCase;

class SceneryServiceTest {

	@Test
	void testInsert() {
		ArrayList<String> sceneryPic = new ArrayList<String>();
		sceneryPic.add("C:\\Users\\����\\Desktop\\�ĵ�\\���֮��\\1.jpg");
		sceneryPic.add("C:\\Users\\����\\Desktop\\�ĵ�\\���֮��\\2.jpg");
		sceneryPic.add("C:\\Users\\����\\Desktop\\�ĵ�\\���֮��\\3_.jpg");
		
		Scenery s = new Scenery("�ʹ�","�й�","����","alfjajfljal","aljflajlkfjaljfla","fjlajlfjaljflajlafj",sceneryPic);
		
		TestCase.assertTrue(new SceneryServiceImpl().insert(s));
	}

	@Test
	void testUpdate() {
		ArrayList<String> sceneryPic = new ArrayList<String>();
		sceneryPic.add("C:\\Users\\����\\Desktop\\�ĵ�\\���֮��\\1.jpg");
		sceneryPic.add("C:\\Users\\����\\Desktop\\�ĵ�\\���֮��\\2.jpg");
		sceneryPic.add("C:\\Users\\����\\Desktop\\�ĵ�\\���֮��\\3_.jpg");
		
		Scenery s = new Scenery("��","�й�","����","�����������ǵط�","���ֶ���","��������������",sceneryPic);
		s.setSceneryNumber(32883);
		
		TestCase.assertTrue(new SceneryServiceImpl().update(s));
	}

	@Test
	void testRemove() {
		TestCase.assertTrue(new SceneryServiceImpl().remove(32883));
	}

	@Test
	void testQuery() {
		TestCase.assertNotNull(new SceneryServiceImpl().query(32883));
	}

	@Test
	void testQueryAll() {
		TestCase.assertNotNull(new SceneryServiceImpl().queryAll());
	}

	@Test
	void testScenerySift() {
		TestCase.assertNotNull(new SceneryServiceImpl().scenerySift("122","","����",""));
	}

}
