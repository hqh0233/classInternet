package com.hqh.service.imp;

import com.hqh.dao.UserDaoMapper;
import com.hqh.pojo.Notice;
import com.hqh.pojo.User;
import com.hqh.pojo.UserEvent;
import com.hqh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDaoMapper userDaoMapper;


    public void setUserDaoMapper(UserDaoMapper userDaoMapper) {
        this.userDaoMapper = userDaoMapper;
    }

    @Override
    public List<User> queryAllUser() {
        return userDaoMapper.queryAllUser();
    }

    @Override
    public int updateUser(User user) {
        return userDaoMapper.updateUser(user);
    }

    @Override
    public int updateUserPassword(String password, int id) {
        return userDaoMapper.updateUserPassword(password,id);
    }

    @Override
    public User queryUserById(int id) {
        return userDaoMapper.queryUserById(id);
    }

    @Override
    public List<Notice> queryAllNotice() {
        return userDaoMapper.queryAllNotice();
    }

    @Override
    public List<UserEvent> queryAllUserEvent() {
        return userDaoMapper.queryAllUserEvent();
    }

    @Override
    public int addUserEvent(UserEvent userEvent) {
        return userDaoMapper.addUserEvent(userEvent);
    }

    @Override
    public User checkLogin(String userName, String password) {
        User user=userDaoMapper.queryUserByName(userName);
        System.out.println(user);
        if(user!=null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

}
