package com.jmypackage1.service; /*这个包是逻辑处理*/

import com.jmypackage1.pojo.User;

import java.util.List;

public interface IUserService {
    public int insert(User user);
    public User getTwo(String username);
    public int amend(User user);
    public List<User> getLists(User user);
    public int deleUser(int id);
    public User getOne(int id);
}
