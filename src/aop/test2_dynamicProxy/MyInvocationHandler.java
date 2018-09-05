package aop.test2_dynamicProxy;

import aop.test1_staticProxy.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Tjl on 2018/9/5 9:25.
 */
public class MyInvocationHandler implements InvocationHandler {
    //通过代理对象调用方法执行invoke
    //object proxy:将来产生的代理对象
    //Method method:方法的镜像
    //object[] args:调用方法是所传的参数列表

    private Object target;
    private Logger logger;


    public MyInvocationHandler(Object target) {
        logger = new Logger();
        this.target = target;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //切面:委托类不想负责的任务
        logger.logBef(method.getName());
        //真正执行目标对象的方法:
        Object res = method.invoke(target, args);
        //切面
        logger.logAfter(method.getName());

        //有些方法想被代理的时候加东西,有些不想,筛选
        if (!method.getName().equals("find")) {
            //切面
            logger.tranComm();
        }


        return null;
    }
}
