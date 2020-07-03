package com.travel.vo;

import java.util.ArrayList;

public class Scenery {
	private int sceneryNumber; // ���
	private String sceneryName = null; // ��������
	private String sceneryCountry; // ����
	private String sceneryProvince;// ʡ��
	private String sceneryCity;// ����
	private String sceneryAddress;// ��ַ
	private String sceneryDesc;// ����
	private ArrayList<String> sceneryPic;// ͼƬ

	public Scenery() {
		super();
	}
	
	public Scenery(String sceneryName, String sceneryCountry, String sceneryProvince,
			String sceneryCity, String sceneryAddress, String sceneryDesc, ArrayList<String> sceneryPic) {
		super();
		this.sceneryName = sceneryName;
		this.sceneryCountry = sceneryCountry;
		this.sceneryProvince = sceneryProvince;
		this.sceneryCity = sceneryCity;
		this.sceneryAddress = sceneryAddress;
		this.sceneryDesc = sceneryDesc;
		this.sceneryPic = sceneryPic;
	}
	
	public int getSceneryNumber() {
		return sceneryNumber;
	}
	
	public void setSceneryNumber(int sceneryNumber) {
		this.sceneryNumber = sceneryNumber;
	}

	public String getSceneryName() {
		return sceneryName;
	}

	public void setSceneryName(String sceneryName) {
		this.sceneryName = sceneryName;
	}

	public String getSceneryCountry() {
		return sceneryCountry;
	}

	public void setSceneryCountry(String sceneryCountry) {
		this.sceneryCountry = sceneryCountry;
	}

	public String getSceneryProvince() {
		return sceneryProvince;
	}

	public void setSceneryProvince(String sceneryProvince) {
		this.sceneryProvince = sceneryProvince;
	}

	public String getSceneryCity() {
		return sceneryCity;
	}

	public void setSceneryCity(String sceneryCity) {
		this.sceneryCity = sceneryCity;
	}

	public String getSceneryAddress() {
		return sceneryAddress;
	}

	public void setSceneryAddress(String sceneryAddress) {
		this.sceneryAddress = sceneryAddress;
	}

	public String getSceneryDesc() {
		return sceneryDesc;
	}

	public void setSceneryDesc(String sceneryDesc) {
		this.sceneryDesc = sceneryDesc;
	}

	public ArrayList<String> getSceneryPic() {
		return sceneryPic;
	}

	public void setSceneryPic(ArrayList<String> sceneryPic) {
		this.sceneryPic = sceneryPic;
	}
}
