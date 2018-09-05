package aop.test1_staticProxy;

/**
 * Created by Tjl on 2018/9/5 8:33.
 */
public class ProxyTest {
    public static void main(String[] args) {
        //target:目标
        IHelloServcie target = new HelloServcieImpl();

        target.sayHello();
        target.loginTest();
        System.out.println("*******************************");
        IHelloServcie proxy = new HelloServiceProxy(target);
        proxy.sayHello();
        proxy.loginTest();

    }
}
