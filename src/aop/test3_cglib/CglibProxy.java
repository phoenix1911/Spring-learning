package aop.test3_cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Tjl on 2018/9/5 10:19.
 * 该类CglibProxy实现了动态创建一个类的子类的方法(cglib给一个类生成代理对象的方式)
 *    getProxy(SuperClass.class)方法通过参数即父类的class对象，创建出它的一个子类对象,也就是cglib方式的代理对象
 *    intercept()方法拦截所有目标类方法的调用，
 *    obj表示将来生成的代理对象，
 *    method为目标类中方法的反射对象，args为方法的动态入参，
 *    mproxy为代理类(子类)中方法的反射对象。
 *    mproxy.invokeSuper(obj, args)通过代理类调用目标对象(父类)中的方法。
 */
public class CglibProxy implements MethodInterceptor{

    public Object getProxy(Class clazz){
        Enhancer enhancer = new Enhancer();
        //设置谁是父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    //实现MethodInterceptor接口方法
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy mproxy) throws Throwable {
        System.out.println("前置代理");
        //通过代理类调用父类中的方法
        Object result = mproxy.invokeSuper(obj, args);
        System.out.println("后置代理");
        return result;
    }
}
