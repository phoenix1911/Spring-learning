package ioc.annotation;

import org.springframework.stereotype.Component;

@Component("office3")
public class Office {
	private String num = "001";
	
	public Office(){
		
	}

	@Override
	public String toString() {
		return "Office{" +
				"num='" + num + '\'' +
				'}';
	}

	public Office(String num) {
		this.num = num;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
}
