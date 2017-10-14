package dao;

import doMain.User;

public interface UserDaoImpl {
    public void addUser(User user) throws Exception;
    public User login(User user) throws Exception;
    public void updateUser(User user)throws Exception;
    public void deleteUser(String id)throws Exception;

}
