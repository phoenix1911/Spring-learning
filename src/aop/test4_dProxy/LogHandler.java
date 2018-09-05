package aop.test4_dProxy;



import aop.test1_staticProxy.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;



// 拦截器
public class LogHandler implements InvocationHandler{
	// 注入目标对象
	// 因为这里要用反射调用目标对象方法
	private Object target;
	private Logger log;//切面
	
	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, 
			Object[] args) throws Throwable {
		Object obj = null;
		if(method.getName().equals("bankAction")&& !"".equals(method.getName())){
			//进行日志输出
			System.out.println("logger:"+
			proxy.getClass()+" method:"+method.getName()
			+" start!");
			//用反射调用目标对象的方法
			obj = method.invoke(this.target, args);
			log.logAfter(method.getName());
		}
		return obj;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
}
