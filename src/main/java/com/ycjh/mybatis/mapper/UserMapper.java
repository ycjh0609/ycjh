package com.ycjh.mybatis.mapper;


import com.ycjh.user.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public UserModel selectUserOne(UserModel userModel);
    public List<UserModel> selectUserList(UserModel userModel);
    public void insertUser(UserModel userModel);
    public void updateUser(UserModel userModel);
    public void deleteUser(UserModel userModel);

}
