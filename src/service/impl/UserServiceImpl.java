package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userdao = new UserDaoImpl();
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
