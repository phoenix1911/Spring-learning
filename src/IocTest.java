
import ioc.annotation.Boss;
import ioc.event.RainEvent;
import ioc.life.Life_User;
import ioc.propertyEditor.PropertyEditor_Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Student;
import bean.Teacher;

import java.sql.Connection;

//ioc功能的测试类
//每个方法测试一个知识点
//每个知识点对应src下面的一个package
//每个package中是这个知识点的配置方式

//这里面的方法名字和对应的src下面的package名字是对应的
//这个类中从上到下 方法的顺序就是我们学习ioc知识点的顺序
@SuppressWarnings("all")
public class IocTest {


    //本类中的测试方法中的代码大致的编写模式
    public void ioc_test() {

        try {
            //1 声明要读取的xml文件路径(如果有多个可以放在数组中)
            //2 读取xml文件创建spring的容器contanier
            //3 从容器container中根据配置的名字拿出需要使用的对象
            //4 使用对象进行操作(对象中的需要的各种数据和依赖的其他对象早已经被spring的容器注入进来)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 知识点:spring的set方式注入
    @Test
    public void ioc_set() {

        try {
            String[] path = {"ioc/set/set.xml"};
            ApplicationContext container =
                    new ClassPathXmlApplicationContext(path);
            //1.对象是否生成,默认单例
            //2.普通属性添加
//            getBean("")和set.xml里的bean name=""关联
            Student student = (Student) container.getBean("student");
            System.out.println(student.getClass());
            System.out.println(student);
            //3.对象属性注入
            Teacher teacher = (Teacher) container.getBean("teacher");
            System.out.println(teacher);
            System.out.println(teacher.getStudent());
            //4.集合的注入
            Student studentColl = (Student) container.getBean("studentColl");
            Student studentColl2 = (Student) container.getBean("studentColl2");
            studentColl.show();
            studentColl2.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 知识点:向一个对象中注入集合
    @Test
    public void ioc_collection() {
        try {
            String[] path = {"ioc/collection/collection.xml"};
            ApplicationContext container = new ClassPathXmlApplicationContext(path);
//


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //知识点:构造器注入(之前的是set注入)
    @Test
    public void ioc_constructor() {
        try {
            String path = "ioc/constructor/constructor.xml";

            ApplicationContext container = new ClassPathXmlApplicationContext(path);
            Student student1 = (Student) container.getBean("student1");
            Student student2 = (Student) container.getBean("student2");
            System.out.println(student1);
            System.out.println(student2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //知识点:自动注入
    @Test
    public void ioc_autowired() {
        try {
            String path = "ioc/autowired/autowired.xml";
            ApplicationContext container = new ClassPathXmlApplicationContext(path);
//            自动把student注入到teacher  <beans>里加or<bean>里加,范围不一样 default-autowire="byName"
            Student student = (Student) container.getBean("student");
            Teacher teacher = (Teacher) container.getBean("teacher");
            System.out.println(student);
            System.out.println(teacher);
            System.out.println("是否自动装配"+teacher.getStudent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //知识点:配置文件中的标签 bean和bean之间也是可以继承的
    @Test
    public void ioc_extend() {
        try {
            String[] path = {"ioc/extend/extends.xml"};
            ApplicationContext container = new ClassPathXmlApplicationContext(path);
            Student student = (Student) container.getBean("student2");
            System.out.println(student);
            Teacher teacher2 = (Teacher) container.getBean("teacher2");
            System.out.println(teacher2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //知识点:spring所管理对象的声明周期
    @Test
    public void ioc_life() {
        try {
            String path = "ioc/life/life.xml";
            System.out.println("生命周期+起别名+默认单例+非单例+");
            ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext(path);
            Life_User user1 = (Life_User) container.getBean("user1");
            System.out.println(user1);
            System.out.println(user1.getBeanName());

            Life_User user2 = (Life_User) container.getBean("user1_1");
            Life_User user3 = (Life_User) container.getBean("user1_2");
            System.out.println(user1==user2);
            System.out.println(user2==user3);
            //容器销毁
            container.destroy();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //知识点:一个xml配置文件中 导入另外一个xml配置文件
    @Test
    public void ioc_imp() {
        try {

//			String[] path = {"ioc/imp/teacher.xml","ioc/imp/student.xml"};
            String[] path = {"ioc/imp/import.xml"};
            ApplicationContext container = new ClassPathXmlApplicationContext(path);
            Teacher tea = (Teacher) container.getBean("tea");
            Student stu = (Student) container.getBean("stu");
            System.out.println(stu);
            System.out.println(tea);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //知识点: 在xml中配置工厂类，然后通过这个工厂类获得工厂生产的实例
    @Test
    public void ioc_Factory() {
        try {
            String path = "ioc/factory/factory.xml";
            ApplicationContext container = new ClassPathXmlApplicationContext(path);
            Connection connection = (Connection) container.getBean("connection");
            System.out.println(connection);
            Connection connection1 = (Connection) container.getBean("connection");
            Connection connection2 = (Connection) container.getBean("connection");
            Connection connection3 = (Connection) container.getBean("connection");
            System.out.println(connection1);
            System.out.println(connection2);
            System.out.println(connection3);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //知识点: 实例工厂
    @Test
    public void ioc_instanceFactory() {
        try {
            String path = "ioc/instanceFactory/instanceFactory.xml";
            ApplicationContext container = new ClassPathXmlApplicationContext(path);
            Connection connection = (Connection) container.getBean("connection");
            System.out.println(connection);




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //知识点: 静态工厂
    @Test
    public void ioc_staticFactory() {
        try {
            String path = "ioc/staticFactory/staticFactory.xml";
            ApplicationContext container = new ClassPathXmlApplicationContext(path);
            Connection connection = (Connection) container.getBean("connection");
            System.out.println(connection);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    //知识点: 使用自定义属性编辑器
    public void ioc_proEdit() {
        try {
            String[] path = {"ioc/propertyEditor/proEdit.xml"};
            ApplicationContext container = new ClassPathXmlApplicationContext(path);
            PropertyEditor_Student student = (PropertyEditor_Student) container.getBean("student");
            System.out.println(student);
            System.out.println(student.getAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    //知识点: 自定义事件
    public void ioc_event() {
        try {
            String path = "ioc/event/event.xml";
            ApplicationContext container = new ClassPathXmlApplicationContext(path);
            //容器发布事件
            container.publishEvent(new RainEvent("下雨了"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    //知识点: ioc中的注解
    public void ioc_annotation() {
        try {
            String path = "ioc/annotation/annotation.xml";
            ApplicationContext container = new ClassPathXmlApplicationContext(path);
            Boss boss = (Boss) container.getBean("boss");
            System.out.println(boss);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
