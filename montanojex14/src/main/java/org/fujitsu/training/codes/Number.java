package org.fujitsu.training.codes;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "number")
public class Number {
	private int num;
	
	@XmlValue
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
