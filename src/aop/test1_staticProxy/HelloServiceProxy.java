package aop.test1_staticProxy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tjl on 2018/9/5 8:35.
 */
//代理类(代理对象):执行功能时真正执行功能的是委托类产生的目标对象,但是代理对象会做委托类不想做的事情(切面):日志,事务

public class HelloServiceProxy implements IHelloServcie{
    //引入一个目标对象
    private IHelloServcie target;
    //引入日志 事务 管理器
    private Logger logger=new Logger();

    //创建代理对象,需要传入一个目标对象
    public HelloServiceProxy(IHelloServcie target) {
        this.target = target;
    }


    @Override
    public void sayHello() {
        //目标对象不想 做的--切面
        System.out.println("log:sayHello执行前"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("事务开启");

        logger.logBef("sayhello");
        //方法的真正执行:交给目标对象
        target.sayHello();
        logger.logAfter("sayhello");
        System.out.println("事务提交");
        System.out.println("log:sayHello执行后"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }

    @Override
    public Object loginTest() {
        //目标对象不想 做的--切面
        System.out.println("log:login()执行前"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("事务开启");
        //方法的真正执行:交给目标对象
        target.loginTest();
        System.out.println("事务提交");
        System.out.println("log:login()执行后"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        return "login seccess";
    }
}
