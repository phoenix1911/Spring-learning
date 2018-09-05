package aop.test2_dynamicProxy;

import bean.Student;

import java.lang.reflect.Proxy;

/**
 * Created by Tjl on 2018/9/5 9:11.
 */
public class ProxyTest {
    public static void main(String[] args) {

        //1.创建目标对象
        IStudentServcie target = new StudentServiceImpl();
        //委托类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //2.委托类的实现的所有接口
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //3.InvocationHandler接口的实现类对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(target);

//        3.JDK动态代理获取代理对象
        IStudentServcie proxy = (IStudentServcie) Proxy.newProxyInstance(classLoader, interfaces, myInvocationHandler);

        //通过代理对象执行方法
//        proxy.save(new Dyn_Student());
//        proxy.delete(1);
//        proxy.find(10);
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());//final修饰不可以代理



    }
}
