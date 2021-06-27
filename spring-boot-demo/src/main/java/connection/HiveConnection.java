package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveConnection {
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    // Hive 0.11.0版本以后org.apache.hive.jdbc.HiveDriver
    private static String url = "jdbc:hive2://localhost:10000/default";
    // Hive 0.11.0版本以后jdbc:hive2://localhost:10000/default
    private static String userName = "root";
    private static String passWord = "pjx2021!";

    public static void main(String[] args) {
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, passWord);
            Statement stmt = con.createStatement();
            // 如果存在了就删除
            String tableName = "test_table";
            String sql = "drop table if exists " + tableName;
            stmt.execute(sql);
            // 创建表
            sql = "create table "
                    + tableName
                    + " (key string,value string) row format delimited fields terminated by ','   stored as textfile ";
            stmt.execute(sql);
            //加载数据
            String Path = "/Users/bytedance/Documents/hive.txt";
            sql = "load data local inpath '" + Path + "' into table " + tableName;
            stmt.execute(sql);
            // 查询数据
            sql = "select * from " + tableName;
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getString(1) + "\t" + res.getString(1));

            }

        } catch (ClassNotFoundException e) {
            System.out.println("没有找到驱动类");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接Hive的信息有问题");
            e.printStackTrace();
        }

    }
}
