package ioc.propertyEditor;

import java.beans.PropertyEditorSupport;

public class AddressEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("遇到了情况,获取到的是字符串,字符串的值是"+text+"不能处理");
		String[] str = text.split(",");
		String city = str[0];
		String street = str[1];
		String country = str[2];
		Address add = new Address(city, street, country);
		//把新的值设置到对象中
		setValue(add);
	}

}
