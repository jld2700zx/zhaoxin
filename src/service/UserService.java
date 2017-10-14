package service;

import domain.User;

public interface UserService {
    public void register (User user) throws Exception;
    public User login (User user) throws Exception;
    public  void updateUser(User user) throws Exception;
    public void deleteUser(String id)throws Exception;
}
