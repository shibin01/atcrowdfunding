package com.shibin.dao;

import com.shibin.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {

    @Select("select * from user where user_name = #{userName} and password = #{password}")
    User getUserByMsg(User user);

    List<User> findUsers(Map<String, Integer> pageMap);

    int findUserCounts();
}
