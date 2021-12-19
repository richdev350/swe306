package com.peg6.peg6backend.mapper;

import com.peg6.peg6backend.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public User getUserByUsernameAndPassword(@Param("userId") String userId, @Param("password") String password);
}
