package ioc.instanceFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Tjl on 2018/9/4 10:39.
 */
public class ConnectionInstanceFactory {
    private String driver;
    private String url;
    private String user;
    private String password;

    //指定的获取产品的方法
    public Connection getConnection() {
        Connection connection= null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public String getDriver() {
        return driver;
    }

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
}
