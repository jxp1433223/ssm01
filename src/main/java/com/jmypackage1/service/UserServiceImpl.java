package com.jmypackage1.service;

import com.jmypackage1.dao.UserDao;
import com.jmypackage1.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao dao;
    @Override
    public int insert(User user) {   //去调用了一下dao层
        return dao.insert(user);
    }

    @Override
    public User getOne(String username) {
        return dao.getOne(username);
    }

    @Override
    public int amend(User user) {  //修改
        return dao.amend(user);
    }

    @Override
    public List<User> getLists() {
        return dao.getLists();
    }

    @Override
    public int deleUser(int id) {
        return dao.deleUser(id);
    }

    @Override
    public User getOne(int id) {
        return dao.getOne(id);
    }
}