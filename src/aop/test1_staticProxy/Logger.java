package aop.test1_staticProxy;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tjl on 2018/9/5 8:45.
 */
public class Logger {

    public void logBef(String msg) {
        System.out.println("log:"+msg+"执行前"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
    public void logAfter(String msg) {
        System.out.println("log:"+msg+"执行后"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
    public void tranComm() {
        System.out.println("事务提交");
    }

}

