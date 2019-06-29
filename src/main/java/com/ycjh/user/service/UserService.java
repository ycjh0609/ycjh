package com.ycjh.user.service;

import com.ycjh.user.model.UserModel;

import java.util.List;

public interface UserService {
    public UserModel selectUserOne(UserModel userModel);
    public List<UserModel> selectUserList(UserModel userModel);
    public void insertUser(UserModel userModel);
    public void updateUser(UserModel userModel);
    public void deleteUser(UserModel userModel);

}
