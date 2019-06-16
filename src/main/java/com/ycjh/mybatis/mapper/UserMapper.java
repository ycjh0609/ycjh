package com.ycjh.mybatis.mapper;


import com.ycjh.user.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<UserModel> selectUser();

}
