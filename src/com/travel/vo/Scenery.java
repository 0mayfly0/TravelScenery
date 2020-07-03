package com.travel.vo;

import java.util.ArrayList;

public class Scenery {
	private int sceneryNumber; // 编号
	private String sceneryName = null; // 景点名字
	private String sceneryCountry; // 国家
	private String sceneryProvince;// 省份
	private String sceneryCity;// 城市
	private String sceneryAddress;// 地址
	private String sceneryDesc;// 描述
	private ArrayList<String> sceneryPic;// 图片

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
