package dao.impl;

import dao.UserDaoImpl;
import doMain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.C3P0Utils;
//import utils.Dbutils;


public class UserDao implements UserDaoImpl{

   /* public void addUser(User user){
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn= C3P0Utils.getConnection();
            ps = conn.prepareStatement("INSERT INTO users(username,PASSWORD,email,birthday)VALUE (?,?,?,?)");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getBirthday());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            C3P0Utils.release(null,ps,conn);
        }
    } */
    public void updateUser(User user)throws Exception{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        qr.update("update users set username=?,password=?,email=?,birthday=? where id=?",user.getUsername(),user.getPassword(),user.getEmail(),user.getBirthday(),user.getId());
    }
    public void deleteUser(String id)throws Exception{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        qr.update("delete from users where id=?",id);
    }
    public void addUser(User user) {
        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            qr.update("INSERT INTO users (id,username,PASSWORD,email,birthday)VALUE (?,?,?,?,?)",user.getId(),user.getUsername(),user.getPassword(),user.getEmail(),user.getBirthday());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
//    public User login(User user) throws Exception {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        User u = null;
//       try {
//           conn = C3P0Utils.getConnection();
////           conn.setTransactionIsolation(Connection.RANSACTION_REPEATABLE_READ);//设置级别为4，避免脏读，不可重复读。
//           conn.setAutoCommit(false);//开启事务
//           ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
//           ps.setString(1,user.getUsername());
//           ps.setString(2,user.getPassword());
//           rs = ps.executeQuery();
//           if(rs.next()){
//                u  = new User();
//                u.setUsername(rs.getString(2));
//                u.setPassword(rs.getString(3));
//                u.setId(rs.getInt(1));
//                u.setEmail(rs.getString(4));
//                u.setBirthday(rs.getString(5));
//           }
//       }catch (Exception e){
//            e.printStackTrace();
//       }finally {
//          C3P0Utils.release(rs,ps,conn);
//       }
//            return u;
//    }

    public User login(User user) throws Exception{
            User u = new User();
    try{
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//          Connection  conn = C3P0Utils.getConnection();
//          conn.setAutoCommit(false);
//          conn.setTransactionIsolation(Connection.RANSACTION_REPEATABLE_READ);
            u =  qr.query("select * from users where username=? and password=?",new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
    }catch (Exception e){
        e.printStackTrace();
    }
            return u;
    }
}