package service.impl;

import dao.UserDaoImpl;
import dao.impl.UserDao;
import doMain.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    UserDaoImpl userdao = new UserDao();
    public void register(User user)throws Exception{
        userdao.addUser(user);
    }
    public User login(User user)throws Exception{

//        User u = new User();
//        try {
//            u =  userdao.login(user);
//        }catch (Exception e ){
//            e.printStackTrace();
//        }
//        return u ;

          User uu = userdao.login(user);

          if(uu!=null){
              uu.setUsername(uu.getUsername());
          }
        return uu;
    }
    public void updateUser(User user)throws Exception{
        userdao.updateUser(user);
    }

    public void deleteUser(String id)throws Exception{
        userdao.deleteUser(id);
    }

}
