package theory.ioc;

public class IOCTest {
	public static void main(String[] args) {
		//1.读取配置文件,生成容器对象[创建,装配配置文件中配置的bean对象]
		BeanFactory beanFactory = new BeanFactory();
		//从容器中获取已经配置好的对象,检查是否创建,装配成功
		Student student = (Student) beanFactory.getBean("stu");
		Teacher teacher = (Teacher) beanFactory.getBean("t");

		System.out.println("容器中的student"+student);
		System.out.println("容器中的teacher"+teacher);
		System.out.println("teacher中的student"+teacher.getStudent());


}
}
