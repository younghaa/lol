package com.test.dto;

import java.util.HashMap;
import java.util.List;


public class Vendor {

	private int viNum;
	private String viName;
	private String viDesc;
	private String viAddress;
	private String viPhone;
	private String viCredat;
	private String viCretim;
	private Page page;
	private String command;
	private String selectVendor;
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getViNum() {
		return viNum;
	}
	public void setViNum(int viNum) {
		this.viNum = viNum;
	}
	public String getViName() {
		return viName;
	}
	public void setViName(String viName) {
		this.viName = viName;
	}
	public String getViDesc() {
		return viDesc;
	}
	public void setViDesc(String viDesc) {
		this.viDesc = viDesc;
	}
	public String getViAddress() {
		return viAddress;
	}
	public void setViAddress(String viAddress) {
		this.viAddress = viAddress;
	}
	public String getViPhone() {
		return viPhone;
	}
	public void setViPhone(String viPhone) {
		this.viPhone = viPhone;
	}
	public String getViCredat() {
		return viCredat;
	}
	public void setViCredat(String viCredat) {
		this.viCredat = viCredat;
	}
	public String getViCretim() {
		return viCretim;
	}
	public void setViCretim(String viCretim) {
		this.viCretim = viCretim;
	}
	@Override
	public String toString() {
		return "Vendor [viNum=" + viNum + ", viName=" + viName + ", viDesc=" + viDesc + ", viAddress=" + viAddress
				+ ", viPhone=" + viPhone + ", viCredat=" + viCredat + ", viCretim=" + viCretim + ", page=" + page
				+ ", command=" + command + "]";
	}
	
	
}
