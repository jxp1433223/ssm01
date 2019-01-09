package com.jmypackage1.dao;

import com.jmypackage1.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    public int insert(User user);
    public List<User> getLists(User user);
    public User getTwo(String username);
    public int amend(User user);
    public int deleUser(int id);
    public User getOne(int id);
}
