package ioc.factory;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Tjl on 2018/9/4 9:59.
 */
/*
如果工厂类实现了spring提供的FatoryBean接口,将来配置的工厂bean获取到的bean对象,,不是工厂类对象
而是产生的产品,通过工厂类对象执行getObject方法返回的
 */
public class ConnectionFactory implements FactoryBean<Connection> {
    //set方式注入初始属性
    private String driver;
    private String url;
    private String user;
    private String password;



    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    //获取产品的方法
    @Override
    public Connection getObject() throws Exception {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    //获取产品的类型
    @Override
    public Class<?> getObjectType() {
        return null;
    }
    //生产的产品是否单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
