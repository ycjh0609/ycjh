package com.ycjh.user.service;

import com.ycjh.mybatis.mapper.UserMapper;
import com.ycjh.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public UserModel selectUserOne(UserModel userModel){
        return userMapper.selectUserOne(userModel);
    }

    public List<UserModel> selectUserList(UserModel userModel){

        return userMapper.selectUserList(userModel);
    }
    public void insertUser(UserModel userModel){
        userMapper.insertUser(userModel);
    }
    public void updateUser(UserModel userModel){
        userMapper.updateUser(userModel);
    }
    public void deleteUser(UserModel userModel){
        userMapper.deleteUser(userModel);
    }

}
