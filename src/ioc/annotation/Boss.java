package ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("boss")
public class Boss {
	private String name;

//	先按照byType找再按照byName方式找
	@Autowired(required=false)
	@Qualifier("car2")
	private Car car;
	@Resource(name ="office3")
	private Office office;

	@Override
	public String toString() {
		return "Boss{" +
				"name='" + name + '\'' +
				", car=" + car +
				", office=" + office +
				'}';
	}

	public Boss(){
		
	}
	
	public Boss(String name, Car car, Office office) {
		this.name = name;
		this.car = car;
		this.office = office;
	}
	
	public Boss( Car car, Office office) {
		this.car = car;
		this.office = office;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	
	
	public void setCar(Car car) {
		this.car = car;
	}
	public Office getOffice() {
		return office;
	}
	
	public void setOffice(Office office) {
		this.office = office;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("初始化..");
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("销毁...");
	}
	
	
	
}
