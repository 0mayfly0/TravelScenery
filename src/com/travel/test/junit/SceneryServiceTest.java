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
		sceneryPic.add("C:\\Users\\沐云\\Desktop\\文档\\天空之境\\1.jpg");
		sceneryPic.add("C:\\Users\\沐云\\Desktop\\文档\\天空之境\\2.jpg");
		sceneryPic.add("C:\\Users\\沐云\\Desktop\\文档\\天空之境\\3_.jpg");
		
		Scenery s = new Scenery("故宫","中国","北京","alfjajfljal","aljflajlkfjaljfla","fjlajlfjaljflajlafj",sceneryPic);
		
		TestCase.assertTrue(new SceneryServiceImpl().insert(s));
	}

	@Test
	void testUpdate() {
		ArrayList<String> sceneryPic = new ArrayList<String>();
		sceneryPic.add("C:\\Users\\沐云\\Desktop\\文档\\天空之境\\1.jpg");
		sceneryPic.add("C:\\Users\\沐云\\Desktop\\文档\\天空之境\\2.jpg");
		sceneryPic.add("C:\\Users\\沐云\\Desktop\\文档\\天空之境\\3_.jpg");
		
		Scenery s = new Scenery("鸟巢","中国","北京","啊发发啊啊是地方","啊手动阀","阿发阿发阿萨发",sceneryPic);
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
		TestCase.assertNotNull(new SceneryServiceImpl().scenerySift("122","","湖南",""));
	}

}
