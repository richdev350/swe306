package com.peg6.peg6backend.mapper;

import com.peg6.peg6backend.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    public List<User> getUserList();

    public User getUserByUserId(@Param("userId")Integer userId);

    public User getUserByUsername(@Param("username")String username);

    public void addUser(@Param("username")String username, @Param("password")String password,
                        @Param("firstName") String firstName, @Param("lastName")String lastName,
                        @Param("phoneNum")String phoneNum, @Param("isAdmin")Integer isAdmin);

    public void updateUser(@Param("userId")Integer userId, @Param("username")String username, @Param("password")String password,
                           @Param("firstName") String firstName, @Param("lastName")String lastName,
                           @Param("phoneNum")String phoneNum, @Param("isAdmin")Integer isAdmin);

    public void deleteUser(@Param("userId")Integer userId);
}
