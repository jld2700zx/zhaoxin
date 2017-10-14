package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class C3P0Utils {
    //获得一个数据源

    private static DataSource dataSource = new ComboPooledDataSource();

    public  static  DataSource getDataSource (){
        return dataSource;
    }
    public static Connection getConnection(){
        try{
            return dataSource.getConnection();
        }catch (Exception e){
            throw new RuntimeException("服务器错误");
        }

    }
    public  static void release(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn!=null){
            try {
                conn.close();//关闭
            } catch (Exception e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
