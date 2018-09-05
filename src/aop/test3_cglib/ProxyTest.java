package aop.test3_cglib;

/**
 * Created by Tjl on 2018/9/5 10:27.
 */
public class ProxyTest {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        SayHello proxy = (SayHello)cglibProxy.getProxy(SayHello.class);
        proxy.say();
    }
}
