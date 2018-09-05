package aop.test1_staticProxy;

/**
 * Created by Tjl on 2018/9/5 8:31.
 */
public class HelloServcieImpl implements IHelloServcie{

    @Override
    public void sayHello() {
        System.out.println("委托类真正实现sayhello功能,hello");
    }

    @Override
    public Object loginTest() {
        System.out.println("委托类的目标对象真正实现登陆功能的操作login success");
        return "loginSuccess";
    }
}
