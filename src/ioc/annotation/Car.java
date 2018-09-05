package ioc.annotation;

import org.springframework.stereotype.Component;

@Component("car2")
public class Car {
	private double price;
	private String name;
	
	public Car(){
		
	}

	@Override
	public String toString() {
		return "Car{" +
				"price=" + price +
				", name='" + name + '\'' +
				'}';
	}

	public Car(double price, String name) {
		this.price = price;
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
