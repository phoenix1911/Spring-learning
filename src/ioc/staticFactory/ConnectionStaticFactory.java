package ioc.staticFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Tjl on 2018/9/4 10:50.
 */
public class ConnectionStaticFactory {
    private static String driver= "oracle.jdbc.driver.OracleDriver";
    private static String url= "jdbc:oracle:thin:@127.0.0.1:1521:ORACLE";
    private static String user= "briup";
    private static String password= "123456";

    public static Connection getConnection() {
        System.out.println("准备产生产品");
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }
}
