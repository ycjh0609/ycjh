package com.ycjh.user.service;

import com.ycjh.mybatis.mapper.UserMapper;
import com.ycjh.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

//    @Resource(name = "UserMapper")

    @Autowired
    UserMapper userMapper;


    @Override
    public List<UserModel> selectUser() {
        return userMapper.selectUser();
    }
}
